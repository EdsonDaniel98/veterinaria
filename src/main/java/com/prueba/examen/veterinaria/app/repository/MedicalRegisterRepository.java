package com.prueba.examen.veterinaria.app.repository;

import com.prueba.examen.veterinaria.app.model.MedicalRegister;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalRegisterRepository extends JpaRepository<MedicalRegister, Long> {
}
