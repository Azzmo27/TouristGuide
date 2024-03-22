package com.example.turistguidev2.repository;

import com.example.turistguidev2.model.TouristAttraction;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RepositoryData {

    @Value("${spring.datasource.url}")
    private String dbUrl;

    @Value("${spring.datasource.username}")
    private String dbUsername;

    @Value("${spring.datasource.password}")
    private String dbPassword;

    // Opret en forbindelse til databasen
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
    }

    // Henter alle turistattraktioner fra databasen
    public List<TouristAttraction> getTouristAttractionList() {
        List<TouristAttraction> attractions = new ArrayList<>();
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM TouristAttraction")) {
            while (rs.next()) {
                TouristAttraction attraction = new TouristAttraction(
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getString("city"),
                        List.of(rs.getString("tag"))
                );
                attractions.add(attraction);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return attractions;
    }
    public List<String> attractionTagList(String name) {
        List<String> tags = new ArrayList<>();
        String SQL = "SELECT tag.tagName FROM tag " +
                "JOIN tourist_attraction_tag ON tourist_attraction.touristID = tourist_attraction_tag.touristID " +
                "JOIN tag ON tourist_attraction_tag.tagID = tag.tagID " +
                "WHERE tourist_attraction.name = ?;";

        try (Connection connection1 = getConnection();
             PreparedStatement ps = connection1.prepareStatement(SQL)) {
            ps.setString(1, name);
            try (ResultSet result = ps.executeQuery()) {
                while (result.next()) {
                    tags.add(result.getString("tagName"));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return tags;
    }


    // Andre CRUD-operationer (tilføj, slet, opdater, osv.) kan implementeres på samme måde.
}
