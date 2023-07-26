package com.prueba.examen.veterinaria.app.repository;

import com.prueba.examen.veterinaria.app.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
}
