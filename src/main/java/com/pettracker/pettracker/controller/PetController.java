package com.pettracker.pettracker.controller;

import com.pettracker.pettracker.model.Pet;
import com.pettracker.pettracker.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/pets")
public class PetController {

    private final PetService petService;

    @Autowired
    public PetController(PetService petService) {
        this.petService = petService;
    }

    @PostMapping("/save")
    public ResponseEntity<Pet> createPet(@RequestBody Pet pet) {
        return ResponseEntity.ok(petService.savePet(pet));
    }

    @GetMapping("/all-pets")
    public List<Pet> getAllPets() {
        return petService.getAllPets();
    }

    @GetMapping("/outside-zone")
    public Map<String, Long> getPetsOutsideZone() {
        return petService.countPetsOutsideZone();
    }
}