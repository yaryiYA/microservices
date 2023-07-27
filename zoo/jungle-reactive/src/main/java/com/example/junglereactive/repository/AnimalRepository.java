package com.example.junglereactive.repository;

import com.example.junglereactive.entity.Animal;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface AnimalRepository extends ReactiveCrudRepository<Animal, UUID> {
}
