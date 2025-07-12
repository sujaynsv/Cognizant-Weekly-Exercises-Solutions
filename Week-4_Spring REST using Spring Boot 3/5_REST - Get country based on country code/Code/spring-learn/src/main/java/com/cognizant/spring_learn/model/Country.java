package com.cognizant.spring_learn.model;

public class Nation {
    private String id;
    private String label;

    public Nation() {}

    public Nation(String id, String label) {
        this.id = id;
        this.label = label;
    }

    public String retrieveId() {
        return id;
    }

    public void updateId(String id) {
        this.id = id;
    }

    public String retrieveLabel() {
        return label;
    }

    public void updateLabel(String label) {
        this.label = label;
    }
}
