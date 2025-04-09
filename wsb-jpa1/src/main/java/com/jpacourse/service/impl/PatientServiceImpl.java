package com.jpacourse.service.impl;

import com.jpacourse.dto.PatientTO;
import com.jpacourse.mapper.PatientMapper;
import com.jpacourse.persistance.dao.impl.PatientDaoImpl;
import com.jpacourse.persistance.entity.PatientEntity;
import com.jpacourse.service.PatientService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@Service
@Transactional
public class PatientServiceImpl implements PatientService {

    private final PatientDaoImpl patientDao;

    @Autowired
    public PatientServiceImpl(PatientDaoImpl patientDao) {
        this.patientDao = patientDao;
    }

    @Override
    public PatientTO findById(Long id) {
        PatientEntity patientEntity = patientDao.findOne(id);
        // filter out future visits
        patientEntity.setVisitList(patientEntity.getVisitList().stream()
                .filter(visitEntity -> visitEntity.getTime().isBefore(LocalDateTime.now()))
                .collect(Collectors.toList()));
        return PatientMapper.mapToTo(patientEntity);
    }
}
