package com.jpacourse.dto;

import com.jpacourse.persistance.enums.Specialization;

import java.util.Objects;

public class DoctorTO {
    private Long id;
    private String firstName;
    private String lastName;


    private String telephoneNumber;
    private String email;

    private String doctorNumber;

    private Specialization specialization;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDoctorNumber() {
        return doctorNumber;
    }

    public void setDoctorNumber(String doctorNumber) {
        this.doctorNumber = doctorNumber;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DoctorTO doctorTO = (DoctorTO) o;
        return Objects.equals(id, doctorTO.id) && Objects.equals(firstName, doctorTO.firstName) && Objects.equals(lastName, doctorTO.lastName) && Objects.equals(telephoneNumber, doctorTO.telephoneNumber) && Objects.equals(email, doctorTO.email) && Objects.equals(doctorNumber, doctorTO.doctorNumber) && specialization == doctorTO.specialization;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, telephoneNumber, email, doctorNumber, specialization);
    }
}
