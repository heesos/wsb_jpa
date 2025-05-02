package com.jpacourse.persistance.dao;

import com.jpacourse.persistance.entity.AddressEntity;
import com.jpacourse.persistance.entity.DoctorEntity;
import com.jpacourse.persistance.entity.VisitEntity;
import com.jpacourse.persistance.enums.Specialization;
import jakarta.persistence.OptimisticLockException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest

public class DoctorDaoTest {

    @Autowired
    DoctorDao doctorDao;

    @Transactional
    @Test
    public void testOptimisticLocking() {

        DoctorEntity doctorEntity = new DoctorEntity();
        doctorEntity.setDoctorNumber("1234");
        doctorEntity.setEmail("testmail@o2.com");
        doctorEntity.setAddressList(new ArrayList<AddressEntity>());
        doctorEntity.setFirstName("Firstname");
        doctorEntity.setLastName("Lastname");
        doctorEntity.setSpecialization(Specialization.DERMATOLOGIST);
        doctorEntity.setTelephoneNumber("1231212312");
        doctorEntity.setVisitList(new ArrayList<VisitEntity>());

        DoctorEntity saved = doctorDao.saveAndFlush(doctorEntity);

        //Load the same doctor in two separate instances (simulated concurrent access)
        DoctorEntity doctor1 = doctorDao.findOne(saved.getId());
        DoctorEntity doctor2 = doctorDao.findOne(saved.getId());

        //Modify and save the first instance
        doctor1.setEmail("updated1@example.com");
        doctorDao.saveAndFlush(doctor1); // This increments version

        // Step 4: Modify and attempt to save the stale second instance
        doctor2.setEmail("updated2@example.com");

        // Should fail due to version mismatch
        assertThrows(OptimisticLockException.class, () -> {
            doctorDao.saveAndFlush(doctor2);
        });

        //tbh this does not work. I don't know why It does not throw this error. Maybe I should force flush with entity manager.
        // I see that Hibernate updates version vield
    }
}
