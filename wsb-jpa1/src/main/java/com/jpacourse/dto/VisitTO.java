package com.jpacourse.dto;

import com.jpacourse.persistance.entity.DoctorEntity;
import com.jpacourse.persistance.entity.MedicalTreatmentEntity;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class VisitTO {
    private Long id;

    private String description;

    private LocalDateTime time;

    private List<String> medicalTreatmentList;

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

    public List<String> getMedicalTreatmentList() {
        return medicalTreatmentList;
    }

    public void setMedicalTreatmentList(List<String> medicalTreatmentList) {
        this.medicalTreatmentList = medicalTreatmentList;
    }

    public DoctorTO getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorTO doctor) {
        this.doctor = doctor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VisitTO visitTO = (VisitTO) o;
        return Objects.equals(id, visitTO.id) && Objects.equals(description, visitTO.description) && Objects.equals(time, visitTO.time) && Objects.equals(medicalTreatmentList, visitTO.medicalTreatmentList) && Objects.equals(doctor, visitTO.doctor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, time, medicalTreatmentList, doctor);
    }
}
