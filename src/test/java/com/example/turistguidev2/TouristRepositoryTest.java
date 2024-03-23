package com.example.turistguidev2;
import com.example.turistguidev2.model.TouristAttraction;
import com.example.turistguidev2.repository.TouristRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TouristRepositoryTest {
    private TouristRepository touristRepository;
    @BeforeEach
    void setUp() {
        touristRepository = new TouristRepository();
    }

    @Test
    void testAddTouristAttraction() {
        // Arrange
        TouristAttraction attraction = new TouristAttraction("The Little Mermaid", "A stone figure of a mermaid", "Copenhagen, Denmark", List.of("Test"));
        // Act
        List<TouristAttraction> result = touristRepository.addTouristAttraction(attraction);
        // Assert
        assertNotNull(result);
        assertTrue(result.contains(attraction));
    }

    @Test
    void testDeleteTouristAttraction() {
        // Arrange
        String name = "Statue Of Liberty";
        TouristAttraction attractionToRemove = new TouristAttraction(name, "Tall figure, that is holding a torch on her right hand", "New York City", List.of("Test"));
        touristRepository.addTouristAttraction(attractionToRemove);
        // Act
        List<TouristAttraction> result = touristRepository.deleteTouristAttraction(name);
        // Assert
        assertNotNull(result);
        assertFalse(result.contains(attractionToRemove));
    }

    @Test
    void testUpdateAttraction() {
        // Arrange
        String name = "Champs Elysees";
        TouristAttraction existingAttraction = new TouristAttraction(name, "A street of 2km filled with cute cafes and shops", "Paris, France", List.of("Test"));
        TouristAttraction updatedAttraction = new TouristAttraction(name, "Updated description", "Updated City", List.of("Updated"));
        touristRepository.addTouristAttraction(existingAttraction);
        // Act
        TouristAttraction result = touristRepository.updateAttraction(name, updatedAttraction);
        // Assert
        assertNotNull(result);
        assertEquals(updatedAttraction.getDescription(), result.getDescription());
        assertEquals(updatedAttraction.getCity(), result.getCity());
        assertEquals(updatedAttraction.getTagsList(), result.getTagsList());
    }
}
