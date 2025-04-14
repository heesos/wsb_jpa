package com.jpacourse.persistance.service;

import com.jpacourse.dto.DoctorTO;
import com.jpacourse.dto.PatientTO;
import com.jpacourse.dto.VisitTO;
import com.jpacourse.persistance.dao.DoctorDao;
import com.jpacourse.persistance.dao.VisitDao;
import com.jpacourse.persistance.enums.Specialization;
import com.jpacourse.persistance.enums.TreatmentType;
import com.jpacourse.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class PatientServiceTest {

    @Autowired
    private PatientService patientService;

    @Autowired
    private VisitDao visitDao;

    @Autowired
    private DoctorDao doctorDao;

    @Transactional
    @Test
    public void findPatientById() {
        //given
        long patientID = 2;

        //Creating TO from scratch as there is no certainty that DoctorDao works fine. No tests for this Dao has been created.
        //No such task criteria
        DoctorTO doctor = new DoctorTO();
        doctor.setTelephoneNumber("987654321");
        doctor.setSpecialization(Specialization.DERMATOLOGIST);
        doctor.setEmail("doc2@example.com");
        doctor.setFirstName("Anna");
        doctor.setLastName("Nowak");
        doctor.setId(2L);
        doctor.setDoctorNumber("D10002");

        //The same goes for VisitTO
        List<VisitTO> visitTOList = new ArrayList<>();
        VisitTO visit = new VisitTO();
        visit.setTime(LocalDateTime.of(2024, 2,21,14,30, 0));
        visit.setDoctor(doctor);
        visit.setDescription("Konsultacja dermatologiczna");
        visit.setMedicalTreatmentList(List.of(String.valueOf(TreatmentType.USG)));
        visit.setId(3L);

        visitTOList.add(visit);

        PatientTO patientTO = new PatientTO();
        patientTO.setId(patientID);
        patientTO.setHeight(184.2);
        patientTO.setPatientNumber("P1002");
        patientTO.setVisitList(visitTOList);
        patientTO.setEmail("patient2@example.com");
        patientTO.setTelephoneNumber("444555666");
        patientTO.setDateOfBirth(LocalDate.of(1992,9,23));
        patientTO.setLastName("Kaczmarek");
        patientTO.setFirstName("Ewa");

        //when
        PatientTO patient = patientService.findById(patientID);

        //then
        assertThat(patient).isEqualTo(patientTO);
    }
    @Transactional
    @Test
    public void removingPatientAndVisits() {
        //given
        long patientID = 1;

        //when
        PatientTO patientTO = patientService.findById(patientID);
        assertThat(patientTO).isNotNull(); //checking that there is a patient before removing one

        long visitCounter = visitDao.count();
        assertThat(visitCounter).isEqualTo(9); //since the test is transactional
        // I will check whether the value will decrease by 2 once I remove the patient

        patientService.removeById(patientID);

        //then
        patientTO = patientService.findById(patientID);
        assertThat(patientTO).isNull();

        long patientVisits = 2;
        long visitCounterAfterDelete = visitDao.count(); //should be 7
        assertThat(visitCounterAfterDelete).isEqualTo(visitCounter - patientVisits);

        //check if Doctors remain in the database
        assertThat(doctorDao.exists(1L)).isTrue();
        assertThat(doctorDao.exists(3L)).isTrue();
    }
}
