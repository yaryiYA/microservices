package com.example.junglereactive.controller;

import com.example.junglereactive.entity.Animal;
import com.example.junglereactive.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping("/jungle")
public class AnimalController {

    private final AnimalRepository animalRepository;

    @Autowired
    public AnimalController(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @GetMapping("/all")
    public Flux<Animal> all() {
        return animalRepository.findAll();
    }

    @GetMapping("/get/{UUID}")
    public Mono<Animal> getEntity(@PathVariable("UUID") UUID id) {
        return animalRepository.findById(id);
    }

    @PostMapping ("/create")
    public Mono<Animal> createEntity(@RequestBody Animal animal) {
        return animalRepository.save(animal);
    }

    @DeleteMapping("/delete/{UUID}")
    public Mono<Void> deleteEntity(@PathVariable("UUID") UUID id) {
        return animalRepository.deleteById(id);
    }
}
