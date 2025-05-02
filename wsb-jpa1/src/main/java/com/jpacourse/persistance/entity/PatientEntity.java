package com.jpacourse.persistance.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "PATIENT")
public class PatientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String telephoneNumber;

    private String email;

    @Column(nullable = false)
    private String patientNumber;

    @Column(nullable = false)
    private LocalDate dateOfBirth;

    //unidirectional from parent's end
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "patient_id")
    private List<AddressEntity> addressList;

    //bidirectional
    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    @Fetch(FetchMode.JOIN)
    private List<VisitEntity> visitList;

    @Column
    private Double height;

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public List<VisitEntity> getVisitList() {
        return visitList;
    }

    public void setVisitList(List<VisitEntity> visitList) {
        this.visitList = visitList;
    }

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

    public String getPatientNumber() {
        return patientNumber;
    }

    public void setPatientNumber(String patientNumber) {
        this.patientNumber = patientNumber;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public List<AddressEntity> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<AddressEntity> addressList) {
        this.addressList = addressList;
    }
}
/**
 * Hibernate: select pe1_0.id,pe1_0.date_of_birth,pe1_0.email,pe1_0.first_name,pe1_0.height,pe1_0.last_name,pe1_0.patient_number,pe1_0.telephone_number from patient pe1_0 where (select count(ve1_0.id) from visit ve1_0 where ve1_0.time<? and ve1_0.patient_id=pe1_0.id)>?
 * Hibernate: select vl1_0.patient_id,vl1_0.id,vl1_0.description,vl1_0.doctor_id,vl1_0.time from visit vl1_0 where vl1_0.patient_id=?
 * Hibernate: select de1_0.id,de1_0.doctor_number,de1_0.email,de1_0.first_name,de1_0.last_name,de1_0.specialization,de1_0.telephone_number from doctor de1_0 where de1_0.id=?
 * Hibernate: select mtl1_0.visit_id,mtl1_0.id,mtl1_0.description,mtl1_0.type from medical_treatment mtl1_0 where mtl1_0.visit_id=?
 * Hibernate: select de1_0.id,de1_0.doctor_number,de1_0.email,de1_0.first_name,de1_0.last_name,de1_0.specialization,de1_0.telephone_number from doctor de1_0 where de1_0.id=?
 * Hibernate: select mtl1_0.visit_id,mtl1_0.id,mtl1_0.description,mtl1_0.type from medical_treatment mtl1_0 where mtl1_0.visit_id=?
 ^^ when using FetchMode.SELECT


 OpenJDK 64-Bit Server VM warning: Sharing is only supported for boot loader classes because bootstrap classpath has been appended
 Hibernate: select pe1_0.id,pe1_0.date_of_birth,pe1_0.email,pe1_0.first_name,pe1_0.height,pe1_0.last_name,pe1_0.patient_number,pe1_0.telephone_number from patient pe1_0 where (select count(ve1_0.id) from visit ve1_0 where ve1_0.time<? and ve1_0.patient_id=pe1_0.id)>?
 Hibernate: select vl1_0.patient_id,vl1_0.id,vl1_0.description,vl1_0.doctor_id,vl1_0.time from visit vl1_0 where vl1_0.patient_id=?
 Hibernate: select de1_0.id,de1_0.doctor_number,de1_0.email,de1_0.first_name,de1_0.last_name,de1_0.specialization,de1_0.telephone_number from doctor de1_0 where de1_0.id=?
 Hibernate: select mtl1_0.visit_id,mtl1_0.id,mtl1_0.description,mtl1_0.type from medical_treatment mtl1_0 where mtl1_0.visit_id=?
 Hibernate: select de1_0.id,de1_0.doctor_number,de1_0.email,de1_0.first_name,de1_0.last_name,de1_0.specialization,de1_0.telephone_number from doctor de1_0 where de1_0.id=?
 Hibernate: select mtl1_0.visit_id,mtl1_0.id,mtl1_0.description,mtl1_0.type from medical_treatment mtl1_0 where mtl1_0.visit_id=?

 ^^ when using FetchMode.JOIN

 SELECT mean that entities are queried in lazy mode. Each relation is subquered by another select query.
 Another visit for patient is another select in the hibernate.

 JOIN loads data eagerly. It's good for relations entities. Fewer queries. Better performance.
 */