package com.prueba.examen.veterinaria.app.repository;

import com.prueba.examen.veterinaria.app.model.Veterinary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeterinaryRepository extends JpaRepository<Veterinary, Long> {
}
