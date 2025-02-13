package com.cmam.cmam.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "facilities")
public class Facility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String facilityName;

    @Column(nullable = false, length = 255)
    private String location;

    @Column
    private Integer capacity;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

    // Default Constructor
    public Facility() {}

    // Parameterized Constructor
    public Facility(String facilityName, String location, Integer capacity) {
        this.facilityName = facilityName;
        this.location = location;
        this.capacity = capacity;
    }

    // Automatically set timestamps
    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFacilityName() { return facilityName; }
    public void setFacilityName(String facilityName) { this.facilityName = facilityName; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public Integer getCapacity() { return capacity; }
    public void setCapacity(Integer capacity) { this.capacity = capacity; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }

    // toString method for debugging
    @Override
    public String toString() {
        return "Facility{" +
                "id=" + id +
                ", facilityName='" + facilityName + '\'' +
                ", location='" + location + '\'' +
                ", capacity=" + capacity +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
