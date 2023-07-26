package com.prueba.examen.veterinaria.app.repository;


import com.prueba.examen.veterinaria.app.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {
}
