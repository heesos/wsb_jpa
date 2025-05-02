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
import java.util.List;
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
        if (patientEntity == null) {
            return null;
        }
        PatientTO patientTO = PatientMapper.mapToTo(patientEntity);

        //Filtering out values on the DTO level rather than Entity level so visits are not removed from the DB
        patientTO.setVisitList(patientTO.getVisitList().stream()
                .filter(visitTO -> visitTO.getTime().isBefore(LocalDateTime.now()))
                .collect(Collectors.toList()));
        return patientTO;
    }

    @Override
    public void removeById(Long id) {
        if (!patientDao.exists(id)) {
            return;
        }
        patientDao.delete(id);
    }

    @Override
    public List<PatientTO> findPatientsWithMoreThanXFinishedVisits(int visits) {
        List<PatientTO> patientTOList = patientDao.findPatientsWithMoreThanXFinishedVisits(visits)
                .stream().map(PatientMapper::mapToTo).toList();
        if (patientTOList.size()==0) {
            return null;
        }
        return patientTOList;
    }
}
