package com.cmam.cmam.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "staff_id", nullable = false)
    private Staffs staff; // Fixed incorrect reference to `User` (should be `Staffs`)

    @ManyToOne
    @JoinColumn(name = "facility_id", nullable = true)
    private Facility facility;

    @Column(nullable = false)
    private LocalDateTime appointmentDate;

    @Column(columnDefinition = "TEXT")
    private String notes;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

    // Default Constructor
    public Appointment() {}

    // Parameterized Constructor
    public Appointment(Patient patient, Staffs staff, Facility facility, LocalDateTime appointmentDate, String notes) {
        this.patient = patient;
        this.staff = staff;
        this.facility = facility;
        this.appointmentDate = appointmentDate;
        this.notes = notes;
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

    public Patient getPatient() { return patient; }
    public void setPatient(Patient patient) { this.patient = patient; }

    public Staffs getStaff() { return staff; }
    public void setStaff(Staffs staff) { this.staff = staff; }

    public Facility getFacility() { return facility; }
    public void setFacility(Facility facility) { this.facility = facility; }

    public LocalDateTime getAppointmentDate() { return appointmentDate; }
    public void setAppointmentDate(LocalDateTime appointmentDate) { this.appointmentDate = appointmentDate; }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }

    // toString method for debugging
    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", patient=" + patient +
                ", staff=" + staff +
                ", facility=" + facility +
                ", appointmentDate=" + appointmentDate +
                ", notes='" + notes + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
