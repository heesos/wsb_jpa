package com.jpacourse.service;

import com.jpacourse.dto.PatientTO;

import java.util.List;

public interface PatientService {

    PatientTO findById(final Long id);

    void removeById(final Long id);

    List<PatientTO> findPatientsWithMoreThanXFinishedVisits(final int visits);
}
