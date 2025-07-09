package com.pettracker.pettracker;

import com.pettracker.pettracker.model.Pet;
import com.pettracker.pettracker.service.PetService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

import static com.pettracker.pettracker.model.PetType.DOG;
import static com.pettracker.pettracker.model.TrackerType.SMALL;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PetServiceTest {

    @Autowired
    private PetService petService;

    @Test
    public void testSaveAndCountOutsideZone() {
        Pet pet = new Pet();
        pet.setPetType(DOG);
        pet.setTrackerType(SMALL);
        pet.setOwnerId(1001);
        pet.setInZone(false);

        petService.savePet(pet);

        Map<String, Long> result = petService.countPetsOutsideZone();
        assertEquals(1L, result.get("DOG-SMALL"));
    }
}
