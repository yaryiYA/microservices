package com.example.zooreactive.service.reactive;

import com.example.zooreactive.DTO.AnimalDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface AnimalService {
    Flux<AnimalDto> findAll();

    Mono<AnimalDto> findById(UUID id);

    Mono<AnimalDto> create(AnimalDto animalDto);

    Mono<Void> delete(UUID uuid);

}
