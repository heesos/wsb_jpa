package com.jpacourse.dto;

import com.jpacourse.persistance.entity.DoctorEntity;
import com.jpacourse.persistance.entity.MedicalTreatmentEntity;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

public class VisitTO {
    private Long id;

    private String description;

    private LocalDateTime time;

    private List<MedicalTreatmentEntity> medicalTreatmentList;

    private DoctorTO doctor;

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

    public List<MedicalTreatmentEntity> getMedicalTreatmentList() {
        return medicalTreatmentList;
    }

    public void setMedicalTreatmentList(List<MedicalTreatmentEntity> medicalTreatmentList) {
        this.medicalTreatmentList = medicalTreatmentList;
    }

    public DoctorTO getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorTO doctor) {
        this.doctor = doctor;
    }
}
