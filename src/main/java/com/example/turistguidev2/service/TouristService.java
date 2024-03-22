package com.example.turistguidev2.service;

import com.example.turistguidev2.model.TouristAttraction;
import com.example.turistguidev2.repository.RepositoryData;
import com.example.turistguidev2.repository.TouristRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TouristService {

    private final TouristRepository touristRepository;

    public TouristService(TouristRepository touristRepository) {
        this.touristRepository = touristRepository;
    }

    public List<TouristAttraction> getTouristAttractionList() {
        return touristRepository.getTouristAttractionList();
    }

    public List<String> attractionTagsList(String touristAttractionName) {
        return touristRepository.attractionTagsList(touristAttractionName);
    }

    public List<TouristAttraction> addTouristAttraction(TouristAttraction touristAttraction) {
        return touristRepository.addTouristAttraction(touristAttraction);
    }

    public List<String> getAttractionCities() {
        return touristRepository.getAttractionCities();
    }

    public List<String> getAttractionTags() {
        return touristRepository.getAttractionTags();
    }

    public List<TouristAttraction> deleteTouristAttraction(String name) {
        return touristRepository.deleteTouristAttraction(name);
    }

    public TouristAttraction updateAttraction(String name, TouristAttraction touristAttraction) {
        return touristRepository.updateAttraction(name, touristAttraction);
    }

    public TouristAttraction getTouristAttraction(String name) {
        return touristRepository.getTouristAttractionByName(name);
    }
    public List<TouristAttraction> getTouristAttractionDatabase() {
        return touristRepository.getTouristAttractionList();
    }

    public List<String> getTouristAttractionTags(String name) {
        return touristRepository.attractionTagsList(name);
    }
}

