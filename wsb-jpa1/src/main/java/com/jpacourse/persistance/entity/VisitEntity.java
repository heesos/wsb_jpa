package com.jpacourse.persistance.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "VISIT")
public class VisitEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @Column(nullable = false)
    private LocalDateTime time;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "visit_id", nullable = false)
    private List<MedicalTreatmentEntity> medicalTreatmentList;

    //bidirectional
    @ManyToOne(optional = false)
    private DoctorEntity doctor;

    //bidirectional
    @ManyToOne(optional = false)
    private PatientEntity patient;

    public List<MedicalTreatmentEntity> getMedicalTreatmentList() {
        return medicalTreatmentList;
    }

    public void setMedicalTreatmentList(List<MedicalTreatmentEntity> medicalTreatmentList) {
        this.medicalTreatmentList = medicalTreatmentList;
    }

    public DoctorEntity getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorEntity doctor) {
        this.doctor = doctor;
    }

    public PatientEntity getPatient() {
        return patient;
    }

    public void setPatient(PatientEntity patient) {
        this.patient = patient;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

}
