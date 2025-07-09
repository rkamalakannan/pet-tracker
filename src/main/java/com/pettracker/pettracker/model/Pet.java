package com.pettracker.pettracker.model;


import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private PetType petType;

    @Enumerated(EnumType.STRING)
    private TrackerType trackerType;

    private Integer ownerId;
    private Boolean inZone;

    public Long getId() { return id; }
    public PetType getPetType() { return petType; }
    public void setPetType(PetType petType) { this.petType = petType; }
    public TrackerType getTrackerType() { return trackerType; }
    public void setTrackerType(TrackerType trackerType) { this.trackerType = trackerType; }
    public Integer getOwnerId() { return ownerId; }
    public void setOwnerId(Integer ownerId) { this.ownerId = ownerId; }
    public Boolean getInZone() { return inZone; }
    public void setInZone(Boolean inZone) { this.inZone = inZone; }
}