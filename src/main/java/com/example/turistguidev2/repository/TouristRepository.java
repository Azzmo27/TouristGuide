package com.example.turistguidev2.repository;

import com.example.turistguidev2.model.TouristAttraction;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TouristRepository {

    private List<TouristAttraction> touristAttractionList = new ArrayList<>(List.of(
            new TouristAttraction("The Petra",
                    "Travelers explore Site, discovering the fascinating history and breathtaking architecture of the Nabateans.",
                    "Jordan", List.of("History", "Art", "Literature")),

            new TouristAttraction("Taj Mahal",
                    "Visitors from across the world come to look at its beauty, The symbol of eternal love and architectural greatness.",
                    "Agra", List.of("Romantic", "Scenic", "Cultural")),

            new TouristAttraction("Eiffel Tower",
                    "Couples usually indulge in the romantic ambiance of the cultural landmark",
                    "Paris", List.of("Romantic", "View over Paris", "Iconic")),

            new TouristAttraction("Sydney Opera House",
                    "Visitors flock to witness world-class performances, experience the vibrant arts scene and views",
                    "Sydney", List.of("Arts and Culture", "Performing Arts", "Scenic Harbor Views")),

            new TouristAttraction("Grand Canyon",
                    "A natural wonder, with colorful landscapes and the opportunity to explore the canyon's depths through hiking and river rafting.",
                    "Arizona (United States)", List.of("Natural Beauty", "Adventure", "Outdoor Activities"))

    ));
    final private List<String> attractionCities = new ArrayList<>(
            List.of("Paris", "London", "New York", "Agra", "Copenhagen", "Tokyo"));

    final private List<String> attractionTags = new ArrayList<>(
            List.of("Historical", "Nature", "Cultural", "Family-friendly", "Free"));


    public List<TouristAttraction> getTouristAttractionList() {
        return touristAttractionList;
    }

    public List<String> getAttractionCities() {
        return attractionCities;
    }

    public List<String> getAttractionTags() {
        return attractionTags;
    }

    public List<String> attractionTagsList(String touristAttractionName) {
        for (TouristAttraction touristAttraction : touristAttractionList) {
            if (touristAttraction.getName().contains(touristAttractionName)) {
                return touristAttraction.getTagsList();
            }
        }
        return null;
    }

    public List<TouristAttraction> addTouristAttraction(TouristAttraction touristAttraction) {
        touristAttractionList.add(touristAttraction);
        return touristAttractionList;
    }

    public List<TouristAttraction> deleteTouristAttraction(String name) {
        for (TouristAttraction attraction : touristAttractionList) {
            if (attraction.getName().contains(name)) {
                touristAttractionList.remove(attraction);
                return touristAttractionList;
            }
        }
        return null;
    }

    public TouristAttraction updateAttraction(String name, TouristAttraction updatedAttraction) {
        for (TouristAttraction attraction : touristAttractionList) {
            if (attraction.getName().contains(name)) {
                attraction.setDescription(updatedAttraction.getDescription());
                attraction.setCity(updatedAttraction.getCity());
                attraction.setTags(updatedAttraction.getTagsList());

                return attraction;
            }
        }
        return null;
    }

    public TouristAttraction getTouristAttractionByName(String name) {
        for (TouristAttraction touristAttraction : touristAttractionList) {
            if (touristAttraction.getName().contains(name)) {
                return touristAttraction;
            }
        }
        return null;
    }

}
