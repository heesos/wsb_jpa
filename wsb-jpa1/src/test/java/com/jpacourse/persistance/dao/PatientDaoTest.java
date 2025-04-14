package com.jpacourse.persistance.dao;

import com.jpacourse.persistance.entity.MedicalTreatmentEntity;
import com.jpacourse.persistance.enums.TreatmentType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class PatientDaoTest {

    @Autowired
    PatientDao patientDao;

    @Autowired
    VisitDao visitDao;

    @Transactional
    @Test
    public void addVisitTest() {
        //given
        String description = "This is a test description";
        MedicalTreatmentEntity medicalTreatmentEntity = new MedicalTreatmentEntity();
        medicalTreatmentEntity.setDescription(description);
        medicalTreatmentEntity.setType(TreatmentType.RTG);

        //when
        long numberOfVisits = visitDao.count(); //should return 9
        assertThat(numberOfVisits).isEqualTo(9);

        patientDao.addVisit(1, 5, LocalDateTime.of(2025, 10, 10, 15, 30, 0), List.of(medicalTreatmentEntity), description);

        //then
        long newNumberOfVisits = visitDao.count(); //should return 10
        assertThat(newNumberOfVisits).isEqualTo(numberOfVisits + 1);
    }
}
