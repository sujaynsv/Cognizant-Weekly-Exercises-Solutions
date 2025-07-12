package com.cognizant.spring_learn.service;

import com.cognizant.spring_learn.model.Nation;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class NationService {

    private final List<Nation> nationCollection = Arrays.asList(
            new Nation("IN", "India"),
            new Nation("US", "United States"),
            new Nation("FR", "France")
    );

    public Nation fetchNationById(String id) {
        return nationCollection.stream()
                .filter(n -> n.retrieveId().equalsIgnoreCase(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Country not found"));
    }
}