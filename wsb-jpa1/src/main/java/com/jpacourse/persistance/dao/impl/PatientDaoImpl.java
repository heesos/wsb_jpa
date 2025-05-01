package com.jpacourse.persistance.dao.impl;

import com.jpacourse.persistance.dao.DoctorDao;
import com.jpacourse.persistance.dao.PatientDao;
import com.jpacourse.persistance.entity.DoctorEntity;
import com.jpacourse.persistance.entity.MedicalTreatmentEntity;
import com.jpacourse.persistance.entity.PatientEntity;
import com.jpacourse.persistance.entity.VisitEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class PatientDaoImpl extends AbstractDao<PatientEntity, Long> implements PatientDao {

    @Autowired
    private DoctorDao doctorDao;

    @Override
    public PatientEntity addVisit(long patientId, long doctorId, LocalDateTime visitTime, List<MedicalTreatmentEntity> medicalTreatmentEntityList, String description) {
        PatientEntity patient = getOne(patientId);
        DoctorEntity doctor = doctorDao.findOne(doctorId);

        VisitEntity visit = new VisitEntity();
        visit.setPatient(patient);
        visit.setDescription(description);
        visit.setMedicalTreatmentList(medicalTreatmentEntityList);
        visit.setTime(visitTime);
        visit.setDoctor(doctor);

        patient.getVisitList().add(visit);

        return update(patient);
    }

    @Override
    public List<PatientEntity> findPatientsBySurname(String lastName) {
        return entityManager.createQuery(
                        "SELECT p FROM PatientEntity p WHERE p.lastName = :lastName", PatientEntity.class)
                .setParameter("lastName", lastName)
                .getResultList();
    }

    @Override
    public List<PatientEntity> findPatientsWithMoreThanXFinishedVisits(int numberOfVisits) {
        LocalDateTime timeNow = LocalDateTime.now();
        return entityManager.createQuery("SELECT p FROM PatientEntity p" +
                        " WHERE (SELECT count(v) FROM VisitEntity v WHERE v.time < :time and v.patient.id=p.id)" +
                        ">:numberOfVisits", PatientEntity.class)
                .setParameter("numberOfVisits", numberOfVisits)
                .setParameter("time",timeNow)
                .getResultList();
    }
}
