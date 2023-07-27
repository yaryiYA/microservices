package com.example.junglereactive.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;


import java.util.UUID;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
public class Animal {
    @Id
    private UUID id;
    private String name;
    private String genus;


    public Animal(String name, String genus) {
        this.name = name;
        this.genus = genus;
    }
}

