package com.prueba.examen.veterinaria.app.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "patients")
public class Patient implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Nombre requerida")
    @NotBlank(message = "Nombre no puede estar vacio")
    private String name;
    @NotNull(message = "Tipo de paciente requerid")
    @NotBlank(message = "Tipo de paciente no puede estar vacio")
    @Column(name = "type_patient")
    private String typePatient;
    @Column(name = "birth_date")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Temporal(TemporalType.DATE)
    private Date birthDate;
    @Column(name = "phone_number")
    private String phoneNumber;
    @OneToOne(cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name = "owner_id")
    private Owner owner;
    public Patient() {

    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypePatient() {
        return typePatient;
    }

    public void setTypePatient(String typePatient) {
        this.typePatient = typePatient;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    private static final long serialversionUID = 1L;
}
