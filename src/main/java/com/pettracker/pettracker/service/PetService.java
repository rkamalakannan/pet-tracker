package com.pettracker.pettracker.service;

import com.pettracker.pettracker.model.Pet;
import com.pettracker.pettracker.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PetService {

    private final PetRepository petRepository;

    @Autowired
    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public Pet savePet(Pet pet) {
        return petRepository.save(pet);
    }

    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    public Map<String, Long> countPetsOutsideZone() {
        return petRepository.findByInZoneFalse().stream()
                .collect(Collectors.groupingBy(
                        pet -> pet.getPetType() + "-" + pet.getTrackerType(),
                        Collectors.counting()
                ));
    }
}