package com.example.spring_boot_dockerized_enry_level.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class DockerEntryLevelContainer {

    @GetMapping("/docker")
    public Map<String, Person> getDockerInfo() {
        return Map.of(
                "person1", new Person(1, "Bharati"),
                "person2", new Person(2, "Swopna")
        );
    }
}

class Person {
    private int id;
    private String name;

    // Constructor
    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
