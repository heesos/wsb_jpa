package com.jpacourse.mapper;

import com.jpacourse.dto.DoctorTO;
import com.jpacourse.persistance.entity.DoctorEntity;

public class DoctorMapper {

    public static DoctorTO mapToTO(DoctorEntity doctor) {
        if (doctor==null) {
            return null;
        }
        DoctorTO doctorTO = new DoctorTO();
        doctorTO.setId(doctor.getId());
        doctorTO.setDoctorNumber(doctor.getDoctorNumber());
        doctorTO.setEmail(doctor.getEmail());
        doctorTO.setFirstName(doctor.getFirstName());
        doctorTO.setLastName(doctor.getLastName());
        doctorTO.setSpecialization(doctor.getSpecialization());
        doctorTO.setTelephoneNumber(doctor.getTelephoneNumber());

        return doctorTO;
    }
}
