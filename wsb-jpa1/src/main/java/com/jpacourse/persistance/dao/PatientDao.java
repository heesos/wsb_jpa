package com.jpacourse.persistance.dao;

import com.jpacourse.persistance.entity.MedicalTreatmentEntity;
import com.jpacourse.persistance.entity.PatientEntity;

import java.time.LocalDateTime;
import java.util.List;

public interface PatientDao extends Dao<PatientEntity, Long> {
    PatientEntity addVisit(long patientId, long doctorId, LocalDateTime visitTime, List<MedicalTreatmentEntity> medicalTreatmentEntityList, String description);

    List<PatientEntity> findPatientsBySurname(String surname);

    List<PatientEntity> findPatientsWithMoreThanXFinishedVisits(int numberOfVisits);

    List<PatientEntity> findPatientsWithMoreThanXHeight(double height);
}
