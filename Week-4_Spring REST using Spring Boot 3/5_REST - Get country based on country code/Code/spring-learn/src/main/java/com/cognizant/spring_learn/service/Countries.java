package com.cognizant.spring_learn.service;

import com.cognizant.spring_learn.model.Nation;
import java.util.List;

public class NationsList {

    private List<Nation> nations;

    public List<Nation> fetchNations() {
        return nations;
    }

    public void assignNations(List<Nation> nations) {
        this.nations = nations;
    }
}
