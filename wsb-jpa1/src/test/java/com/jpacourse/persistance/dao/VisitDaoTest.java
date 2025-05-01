package com.jpacourse.persistance.dao;

import com.jpacourse.persistance.entity.VisitEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class VisitDaoTest {
    @Autowired
    VisitDao visitDao;

    @Transactional
    @Test
    void findVisitByPatientId() {
        long patientId = 1L;
        List<VisitEntity> visitEntityList = visitDao.getAllPatientVisits(patientId);
        assertThat(visitEntityList.size()).isEqualTo(2);
    }
}
