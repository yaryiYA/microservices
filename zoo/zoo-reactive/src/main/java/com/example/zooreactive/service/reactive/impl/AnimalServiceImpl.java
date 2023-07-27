package com.example.zooreactive.service.reactive.impl;

import com.example.zooreactive.DTO.AnimalDto;
import com.example.zooreactive.service.reactive.AnimalService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;

import java.util.UUID;
@Service
public class AnimalServiceImpl implements AnimalService {
    @Value("${webClient.baseUrl}")
    protected  String baseUrl;

    private final WebClient webClient;

    public AnimalServiceImpl() {
        this.webClient = WebClient.builder()
                .baseUrl("http://localhost:8765/jungle/jungle")
                .build();
    }

    @Override
    public Flux<AnimalDto> findAll() {
        return webClient.get()
                .uri("/all")
                .retrieve()
                .bodyToFlux(AnimalDto.class)
                .log();
    }

    @Override
    public Mono<AnimalDto> findById(UUID id) {
        return webClient.get()
                .uri("/get/"+id)
                .retrieve()
                .bodyToMono(AnimalDto.class);
    }

    @Override
    public Mono<AnimalDto> create(AnimalDto animalDto) {
        return webClient.post()
                .uri("/create")
                .body(Mono.just(animalDto), AnimalDto.class)
                .retrieve()
                .bodyToMono(AnimalDto.class);
    }

    @Override
    public Mono<Void> delete(UUID id) {
        return webClient.delete()
                .uri(String.join("","/delete/"+id))
                .retrieve()
                .bodyToMono(Void.class);
    }
}
