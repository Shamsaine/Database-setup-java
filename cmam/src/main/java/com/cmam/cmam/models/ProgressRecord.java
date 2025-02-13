package com.cmam.cmam.models;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "progress_records")
public class ProgressRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @Column(nullable = false)
    private LocalDate date;

    @Column
    private Double weight;  // Precision is automatically handled

    @Column
    private Double muac;    // No need for precision in @Column

    @Column
    private Double whzScore;

    @Column(columnDefinition = "TEXT")
    private String comments;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

    // Default Constructor
    public ProgressRecord() {}

    // Constructor with parameters
    public ProgressRecord(Patient patient, LocalDate date, Double weight, Double muac, Double whzScore, String comments) {
        this.patient = patient;
        this.date = date;
        this.weight = weight;
        this.muac = muac;
        this.whzScore = whzScore;
        this.comments = comments;
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

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Patient getPatient() { return patient; }
    public void setPatient(Patient patient) { this.patient = patient; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public Double getWeight() { return weight; }
    public void setWeight(Double weight) { this.weight = weight; }

    public Double getMuac() { return muac; }
    public void setMuac(Double muac) { this.muac = muac; }

    public Double getWhzScore() { return whzScore; }
    public void setWhzScore(Double whzScore) { this.whzScore = whzScore; }

    public String getComments() { return comments; }
    public void setComments(String comments) { this.comments = comments; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
}
