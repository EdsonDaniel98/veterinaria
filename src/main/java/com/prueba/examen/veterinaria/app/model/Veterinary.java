package com.prueba.examen.veterinaria.app.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "veterinarians")
public class Veterinary implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "second_last_Name")
    private String secondLastName;
    @NotNull(message = "Licenia requerida")
    @NotBlank(message = "Licencia no puede estar vacia")
    @Size(min= 10, max = 10, message = "10 Caracteres obligatorios")
    private String license;
    public Veterinary() {

    }
    public Veterinary(Long id, String name, String lastName, String secondLastName, String license) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.secondLastName = secondLastName;
        this.license = license;
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSecondLastName() {
        return secondLastName;
    }

    public void setSecondLastName(String secondLastName) {
        this.secondLastName = secondLastName;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    private static final long serialversionUID = 1L;
}
