package com.example.turistguidev2.repository;

import com.example.turistguidev2.model.TouristAttraction;
import org.springframework.stereotype.Repository;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RepositoryData {

    private ConnectionManager connectionManager;

    public List<TouristAttraction> getTouristAttractionList() {
        List<TouristAttraction> attractions = new ArrayList<>();
        String selectQuery = "SELECT * FROM TouristAttraction";
        try (Connection connection = connectionManager.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet result = stmt.executeQuery(selectQuery)) {
            while (result.next()) {
                TouristAttraction attraction = new TouristAttraction(
                        result.getString("name"),
                        result.getString("description"),
                        result.getString("city"),
                        getAttractionTags(result.getString("name"))
                );
                attractions.add(attraction);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return attractions;
    }

    public List<String> getAttractionTags(String name) {
        List<String> tags = new ArrayList<>();
        String selectTagsQuery = "SELECT tag.name FROM Tag " +
                "JOIN Tourist_Attraction_Tag ON Tag.tag_ID = Tourist_Attraction_Tag.tag_ID " +
                "JOIN TouristAttraction ON TouristAttraction.touristAttractionID = Tourist_Attraction_Tag.touristAttraction_ID " +
                "WHERE TouristAttraction.name = ?";
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement ps = connection.prepareStatement(selectTagsQuery)) {
            ps.setString(1, name);
            try (ResultSet result = ps.executeQuery()) {
                while (result.next()) {
                    tags.add(result.getString("name"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tags;
    }

    public void createTouristAttraction(TouristAttraction touristAttraction) {
        String insertQuery = "INSERT INTO TouristAttraction (name, description, city) VALUES (?, ?, ?)";
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement ps = connection.prepareStatement(insertQuery)) {
            ps.setString(1, touristAttraction.getName());
            ps.setString(2, touristAttraction.getDescription());
            ps.setString(3, touristAttraction.getCity());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteTouristAttraction(String name) {
        String deleteQuery = "DELETE FROM TouristAttraction WHERE name = ?";
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement ps = connection.prepareStatement(deleteQuery)) {
            ps.setString(1, name);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateAttraction(String name, TouristAttraction updatedAttraction) {
        String updateQuery = "UPDATE TouristAttraction SET description = ?, city = ? WHERE name = ?";
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement ps = connection.prepareStatement(updateQuery)) {
            ps.setString(1, updatedAttraction.getDescription());
            ps.setString(2, updatedAttraction.getCity());
            ps.setString(3, name);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public TouristAttraction getTouristAttractionByName(String name) {
        TouristAttraction attraction = null;
        String selectQuery = "SELECT * FROM TouristAttraction WHERE name = ?";
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement ps = connection.prepareStatement(selectQuery)) {
            ps.setString(1, name);
            try (ResultSet result = ps.executeQuery()) {
                if (result.next()) {
                    attraction = new TouristAttraction(
                            result.getString("name"),
                            result.getString("description"),
                            result.getString("city"),
                            getAttractionTags(name)
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return attraction;
    }
}
