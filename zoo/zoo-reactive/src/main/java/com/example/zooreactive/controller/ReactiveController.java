package com.example.zooreactive.controller;

import com.example.zooreactive.DTO.AnimalDto;
import com.example.zooreactive.service.reactive.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping("/zoo")
public class ReactiveController {
    private  final AnimalService animalService;
    @Autowired
    public ReactiveController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping("/all")
    public Flux<AnimalDto> all() {
        return animalService.findAll();
    }

    @GetMapping("/get/{UUID}")
    public Mono<AnimalDto> getEntity(@PathVariable("UUID") UUID id) {
        return animalService.findById(id);
    }

    @PostMapping("/create")
    public Mono<AnimalDto> createEntity(@RequestBody AnimalDto animalDto) {
        return animalService.create(animalDto);
    }

    @DeleteMapping("/delete/{UUID}")
    public Mono<Void> deleteEntity(@PathVariable("UUID") UUID id) {
        return animalService.delete(id);
    }


}
