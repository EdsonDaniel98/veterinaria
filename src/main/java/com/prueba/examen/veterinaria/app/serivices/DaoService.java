package com.prueba.examen.veterinaria.app.serivices;


import com.prueba.examen.veterinaria.app.model.MedicalRegister;
import com.prueba.examen.veterinaria.app.model.Owner;
import com.prueba.examen.veterinaria.app.model.Patient;
import com.prueba.examen.veterinaria.app.model.Veterinary;
import com.prueba.examen.veterinaria.app.repository.MedicalRegisterRepository;
import com.prueba.examen.veterinaria.app.repository.OwnerRepository;
import com.prueba.examen.veterinaria.app.repository.PatientRepository;
import com.prueba.examen.veterinaria.app.repository.VeterinaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DaoService {

    // Inyectando repositorios
    @Autowired
    private MedicalRegisterRepository medicalRegisterRepository;
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private OwnerRepository ownerRepository;
    @Autowired
    private VeterinaryRepository veterinaryRepository;

    // Servicios para Registro
    public List<MedicalRegister> findAllMedicalRegister() {
        return medicalRegisterRepository.findAll();
    }

    public MedicalRegister createMedicalRegister(MedicalRegister register) {
        return medicalRegisterRepository.save(register);
    }

    public MedicalRegister findByIdMedicalRegister(Long id) {
        return medicalRegisterRepository.findById(id).orElse(null);
    }

    public void deletByIdMedicalRegister(Long id) {medicalRegisterRepository.deleteById(id);
    }

    // Servicios para pacientes
    public List<Patient> findAllPatient() {
        return patientRepository.findAll();
    }

    public Patient createPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public Patient findByIdPatient(Long id) {
        return patientRepository.findById(id).orElse(null);
    }

    public void deletByIdPatient(Long id) {
        patientRepository.deleteById(id);
    }

    // Servicios para propietarios
    public List<Owner> findAllOwner() {
        return ownerRepository.findAll();
    }

    public Owner createOwner(Owner owner) {
        return ownerRepository.save(owner);
    }

    public Owner findByIdOwner(Long id) {
        return ownerRepository.findById(id).orElse(null);
    }

    public void deletByIdOwner(Long id) {
        ownerRepository.deleteById(id);
    }

    // Servicios para veterinario
    public List<Veterinary> findAllVeterinary() {
        return veterinaryRepository.findAll();
    }

    public Veterinary createVeterinary(Veterinary veterinary) {
        return veterinaryRepository.save(veterinary);
    }

    public Veterinary findByIdVeterinary(Long id) {
        return veterinaryRepository.findById(id).orElse(null);
    }

    public void deletByIdVeterinary(Long id) {
        veterinaryRepository.deleteById(id);
    }
}
