package com.prueba.examen.veterinaria.app.controller;

import com.prueba.examen.veterinaria.app.exception.CustomException;
import com.prueba.examen.veterinaria.app.exception.ErrorMensaje;
import com.prueba.examen.veterinaria.app.model.MedicalRegister;
import com.prueba.examen.veterinaria.app.model.Owner;
import com.prueba.examen.veterinaria.app.model.Patient;
import com.prueba.examen.veterinaria.app.model.Veterinary;
import com.prueba.examen.veterinaria.app.serivices.DaoServiceController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("veterinary")
public class VeterinaryController {
    @Autowired
    private DaoServiceController daoServiceController;

    // Apis para registros medicos
    // lista de registros medicos
    @GetMapping("/medical/registers/list")
    public ResponseEntity<?> findAllMedicalRegister(){
        return daoServiceController.findAllMedicalRegister();
    }

    // Crear un registro medico
    @PostMapping("/medical/register/create")
    public ResponseEntity<?> createMedicalRegister(@Validated @RequestBody MedicalRegister medicalRegister, Errors errors){
        if (errors.hasErrors()){
            ErrorMensaje.throwError(errors);
        }
        return daoServiceController.createMedicalRegister(medicalRegister);
    }

    // Editar registro medico
    @PostMapping("/medical/register/update")
    public ResponseEntity<?> updateUser(@RequestBody MedicalRegister medicalRegister){
        return daoServiceController.updateMedicalRegister(medicalRegister);
    }

    // Eliminar registro medico
    @PostMapping("/medical/register/delete")
    public ResponseEntity<?> deleteUser(@RequestBody MedicalRegister medicalRegister){
        return daoServiceController.deleteMedicalRegister(medicalRegister.getId());
    }

    // Apis para pacientes
    // Lista de pacientes
    @GetMapping("/patients/list")
    public ResponseEntity<?> findAllPatient(){
        return daoServiceController.findAllPatients();
    }

    // Crear paciente
    @PostMapping("/patients/create")
    public ResponseEntity<?> createPatient(@Validated @RequestBody Patient patient, Errors errors){
        if (errors.hasErrors()){
            ErrorMensaje.throwError(errors);
        }
        return daoServiceController.createPatient(patient);
    }

    // Editar paciente
    @PostMapping("/patients/update")
    public ResponseEntity<?> updatePatient(@RequestBody Patient patient){
        return daoServiceController.updatePatient(patient);
    }

    // Eliminar paciente
    @PostMapping("/patients/delete")
    public ResponseEntity<?> deletePatient(@RequestBody Patient patient){
        return daoServiceController.deletePatient(patient.getId());
    }
    // Apis para propietarios
    // Lista de propietarios
    @GetMapping("/owners/list")
    public ResponseEntity<?> findAllOwner(){
        return daoServiceController.findAllOwner();
    }

    // Crear propietario
    @PostMapping("/owners/create")
    public ResponseEntity<?> createOwner(@RequestBody Owner owner){
        return daoServiceController.createOwner(owner);
    }

    // Editar propietario
    @PostMapping("/owners/update")
    public ResponseEntity<?> updateOwner(@RequestBody Owner owner){
        return daoServiceController.updateOwner(owner);
    }

    // Eliminar propietario
    @PostMapping("/owners/delete")
    public ResponseEntity<?> deleteOwner(@RequestBody Owner owner){
        return daoServiceController.deleteOwner(owner.getId());
    }
    // Apis para veterinarios
    // Lista de veterinarios
    @GetMapping("/veterinarians/list")
    public ResponseEntity<?> findAllVeterinary(){
        return daoServiceController.findAllVeterinary();
    }
    // Crear veterinario
    @PostMapping("/veterinarians/create")
    public ResponseEntity<?> createVeterinary(@Validated @RequestBody Veterinary veterinary, Errors errors){
        if (errors.hasErrors()){
            ErrorMensaje.throwError(errors);
        }
        return daoServiceController.createVeterinary(veterinary);
    }

    // Editar veterinario
    @PostMapping("/veterinarians/update")
    public ResponseEntity<?> updateVeterinary(@RequestBody Veterinary veterinary){
        return daoServiceController.updateVeterinary(veterinary);
    }

    // Eliminar veterinario
    @PostMapping("/veterinarians/delete")
    public ResponseEntity<?> deleteVeterinary(@RequestBody Veterinary veterinary){
        return daoServiceController.deleteVeterinary(veterinary.getId());
    }


}


