package com.example.turistguidev2.service;

import com.example.turistguidev2.model.TouristAttraction;
import com.example.turistguidev2.repository.RepositoryData;
import com.example.turistguidev2.repository.TouristRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TouristService {

    private final TouristRepository touristRepository;
    private final RepositoryData repositoryData;

    public TouristService(TouristRepository touristRepository, RepositoryData repositoryData) {
        this.touristRepository = touristRepository;
        this.repositoryData = repositoryData;
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
        return repositoryData.getTouristAttractionList();
    }

    public List<String> getTouristAttractionTags(String name) {
        return repositoryData.getAttractionTags(name);
    }

    public void createTouristAttraction(TouristAttraction touristAttraction) {
        repositoryData.createTouristAttraction(touristAttraction);
    }

    public void deleteTouristAttractionFromRepositoryData(String name) {
        repositoryData.deleteTouristAttraction(name);
    }

    public void updateTouristAttractionFromRepositoryData(String name, TouristAttraction updatedAttraction) {
        repositoryData.updateAttraction(name, updatedAttraction);
    }

    public TouristAttraction getTouristAttractionByNameFromRepositoryData(String name) {
        return repositoryData.getTouristAttractionByName(name);
    }
}






