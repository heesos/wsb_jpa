package com.jpacourse.persistance.dao.impl;

import com.jpacourse.persistance.dao.PatientDao;
import com.jpacourse.persistance.entity.DoctorEntity;
import com.jpacourse.persistance.entity.MedicalTreatmentEntity;
import com.jpacourse.persistance.entity.PatientEntity;
import com.jpacourse.persistance.entity.VisitEntity;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class PatientDaoImpl extends AbstractDao<PatientEntity, Long> implements PatientDao {

    @Override
    public PatientEntity addVisit(long patientId, long doctorId, LocalDateTime visitTime, List<MedicalTreatmentEntity> medicalTreatmentEntityList, String description) {
        PatientEntity patient = entityManager.getReference(PatientEntity.class, patientId);
        DoctorEntity doctor = entityManager.getReference(DoctorEntity.class, doctorId);

        VisitEntity visit = new VisitEntity();
        visit.setPatient(patient);
        visit.setDescription(description);
        visit.setMedicalTreatmentList(medicalTreatmentEntityList);
        visit.setTime(visitTime);
        visit.setDoctor(doctor);

        patient.getVisitList().add(visit);

        return entityManager.merge(patient);
    }
}
