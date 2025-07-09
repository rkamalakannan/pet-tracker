package com.pettracker.pettracker.model;

import jakarta.persistence.Entity;


@Entity
public class Cat extends Pet {

    private Boolean lostTracker;

    public Boolean getLostTracker() { return lostTracker; }
    public void setLostTracker(Boolean lostTracker) { this.lostTracker = lostTracker; }
}