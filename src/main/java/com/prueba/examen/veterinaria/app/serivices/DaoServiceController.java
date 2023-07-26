package com.prueba.examen.veterinaria.app.serivices;

import com.prueba.examen.veterinaria.app.model.MedicalRegister;
import com.prueba.examen.veterinaria.app.model.Owner;
import com.prueba.examen.veterinaria.app.model.Patient;
import com.prueba.examen.veterinaria.app.model.Veterinary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Component
public class DaoServiceController {

    @Autowired
    private  DaoService daoService;

    // Listar registros medicos
    public ResponseEntity<?> findAllMedicalRegister() {
        List<MedicalRegister> list = null;
        HashMap<String, Object> message = new HashMap<>();

        try {
            list = daoService.findAllMedicalRegister();
            if (!list.isEmpty()) {
                message.put("List", list);
                message.put("Message", "Lista mostrada con exito");
            } else{
                message.put("Empty", "Lista vacia");
                return new ResponseEntity<HashMap<String, Object>>(message, HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {
            e.printStackTrace();
            message.put("Error", e.toString());
            return new ResponseEntity<HashMap<String, Object>>(message, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<HashMap<String, Object>>(message, HttpStatus.OK);
    }

    // Crear un registro
    public ResponseEntity<?> createMedicalRegister(MedicalRegister medicalRegister) {
        MedicalRegister newRegister = null;
        HashMap<String, Object> message = new HashMap<>();

        try {
            newRegister = daoService.findByIdMedicalRegister(medicalRegister.getId());
            if (newRegister == null) {
                newRegister = daoService.createMedicalRegister(medicalRegister);
                message.put("Registro Medico", newRegister);
                message.put("Message", "Creado con exito");
            } else {
                message.put("Error", "Error al crear");
                return new ResponseEntity<HashMap<String, Object>>(message, HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {
            e.printStackTrace();
            message.put("Error", e.toString());
            return new ResponseEntity<HashMap<String, Object>>(message, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<HashMap<String, Object>>(message, HttpStatus.CREATED);
    }

    // Editar registro medico
    public ResponseEntity<?> updateMedicalRegister(MedicalRegister medicalRegister){
        MedicalRegister updateRegister = null;
        HashMap<String, Object> message = new HashMap<>();

        try {
            updateRegister = daoService.findByIdMedicalRegister(medicalRegister.getId());
            if (!(updateRegister == null)){

                updateRegister.setOwner(medicalRegister.saveOwner());
                updateRegister.setPatient(medicalRegister.getPatient());
                updateRegister.setVeterinary(medicalRegister.getVeterinary());
                updateRegister.setCreateAt(medicalRegister.getCreateAt());
                updateRegister.setHour(medicalRegister.getHour());
                daoService.createMedicalRegister(updateRegister);
                message.put("Registro", updateRegister);
                message.put("Message", "Actualizado con exito");
            }else {
                message.put("Error", "Error al editar");
                return new ResponseEntity<HashMap<String, Object>>(message, HttpStatus.NOT_FOUND);
            }

        }catch (Exception e){
            e.printStackTrace();
            message.put("Error", e.toString());
            return new ResponseEntity<HashMap<String, Object>>(message, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<HashMap<String, Object>>(message, HttpStatus.CREATED);
    }

    // Eliminar registro medico
    public ResponseEntity<?> deleteMedicalRegister(Long id){
        HashMap<String, Object> message = new HashMap<>();

        try {
            if (!(id == null)){
                daoService.deletByIdMedicalRegister(id);
                message.put("Message", "Eliminado con exito");
            }else {
                message.put("Error", "El id no existe");
                return new ResponseEntity<HashMap<String, Object>>(message, HttpStatus.NOT_FOUND);
            }

        }catch (Exception e){
            e.printStackTrace();
            message.put("Error", e.toString());
            return new ResponseEntity<HashMap<String, Object>>(message, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<HashMap<String, Object>>(message, HttpStatus.OK);
    }
    // Listar pacientes
    public ResponseEntity<?> findAllPatients() {
        List<Patient> list = null;
        HashMap<String, Object> message = new HashMap<>();

        try {
            list = daoService.findAllPatient();
            if (!list.isEmpty()) {
                message.put("List", list);
                message.put("Message", "Lista mostrada con exito");
            } else{
                message.put("Empty", "Lista vacia");
                return new ResponseEntity<HashMap<String, Object>>(message, HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {
            e.printStackTrace();
            message.put("Error", e.toString());
            return new ResponseEntity<HashMap<String, Object>>(message, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<HashMap<String, Object>>(message, HttpStatus.OK);
    }

    // Crear un paciente
    public ResponseEntity<?> createPatient(Patient patient) {
        Patient newPatient = null;
        HashMap<String, Object> message = new HashMap<>();

        try {
            newPatient = daoService.findByIdPatient(patient.getId());
            if (newPatient == null) {
                newPatient = daoService.createPatient(patient);
                message.put("Paciente", newPatient);
                message.put("Message", "Creado con exito");
            } else {
                message.put("Error", "Error al crear");
                return new ResponseEntity<HashMap<String, Object>>(message, HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {
            e.printStackTrace();
            message.put("Error", e.toString());
            return new ResponseEntity<HashMap<String, Object>>(message, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<HashMap<String, Object>>(message, HttpStatus.CREATED);
    }

    // Editar paciente
    public ResponseEntity<?> updatePatient(Patient patient){
        Patient updatePatient = null;
        HashMap<String, Object> message = new HashMap<>();

        try {
            updatePatient = daoService.findByIdPatient(patient.getId());
            if (!(updatePatient == null)){

                updatePatient.setName(patient.getName());
                updatePatient.setTypePatient(patient.getTypePatient());
                updatePatient.setBirthDate(patient.getBirthDate());;
                updatePatient.setPhoneNumber(patient.getPhoneNumber());
                updatePatient.setOwner(patient.getOwner());
                daoService.createPatient(updatePatient);
                message.put("Paciente", updatePatient);
                message.put("Message", "Actualizado con exito");
            }else {
                message.put("Error", "Error al editar");
                return new ResponseEntity<HashMap<String, Object>>(message, HttpStatus.NOT_FOUND);
            }

        }catch (Exception e){
            e.printStackTrace();
            message.put("Error", e.toString());
            return new ResponseEntity<HashMap<String, Object>>(message, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<HashMap<String, Object>>(message, HttpStatus.CREATED);
    }

    // Eliminar paciente
    public ResponseEntity<?> deletePatient(Long id){
        HashMap<String, Object> message = new HashMap<>();

        try {
            if (!(id == null)){
                daoService.deletByIdPatient(id);
                message.put("Message", "Eliminado con exito");
            }else {
                message.put("Error", "El id no existe");
                return new ResponseEntity<HashMap<String, Object>>(message, HttpStatus.NOT_FOUND);
            }

        }catch (Exception e){
            e.printStackTrace();
            message.put("Error", e.toString());
            return new ResponseEntity<HashMap<String, Object>>(message, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<HashMap<String, Object>>(message, HttpStatus.OK);
    }
    // Listar propietarios
    public ResponseEntity<?> findAllOwner() {
        List<Owner> list = null;
        HashMap<String, Object> message = new HashMap<>();

        try {
            list = daoService.findAllOwner();
            if (!list.isEmpty()) {
                message.put("List", list);
                message.put("Message", "Lista mostrada con exito");
            } else{
                message.put("Empty", "Lista vacia");
                return new ResponseEntity<HashMap<String, Object>>(message, HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {
            e.printStackTrace();
            message.put("Error", e.toString());
            return new ResponseEntity<HashMap<String, Object>>(message, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<HashMap<String, Object>>(message, HttpStatus.OK);
    }

    // Crear un propietario
    public ResponseEntity<?> createOwner(Owner owner) {
        Owner newOwner = null;
        HashMap<String, Object> message = new HashMap<>();

        try {
            newOwner = daoService.findByIdOwner(owner.getId());
            if (!(newOwner == null)) {
                newOwner = daoService.createOwner(owner);
                message.put("Propietario", newOwner);
                message.put("Message", "Creado con exito");
            } else {
                message.put("Error", "Error al crear");
                return new ResponseEntity<HashMap<String, Object>>(message, HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {
            e.printStackTrace();
            message.put("Error", e.toString());
            return new ResponseEntity<HashMap<String, Object>>(message, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<HashMap<String, Object>>(message, HttpStatus.CREATED);
    }

    // Editar propietario
    public ResponseEntity<?> updateOwner(Owner owner){
        Owner updateOwner = null;
        HashMap<String, Object> message = new HashMap<>();

        try {
            updateOwner = daoService.findByIdOwner(owner.getId());
            if (!(updateOwner == null)){

                updateOwner.setName(owner.getName());
                updateOwner.setLastName(owner.getLastName());
                updateOwner.setSecondLastName(owner.getSecondLastName());
                daoService.createOwner(updateOwner);
                message.put("Propietario", updateOwner);
                message.put("Message", "Actualizado con exito");
            }else {
                message.put("Error", "Error al editar");
                return new ResponseEntity<HashMap<String, Object>>(message, HttpStatus.NOT_FOUND);
            }

        }catch (Exception e){
            e.printStackTrace();
            message.put("Error", e.toString());
            return new ResponseEntity<HashMap<String, Object>>(message, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<HashMap<String, Object>>(message, HttpStatus.CREATED);
    }

    // Eliminar propietario
    public ResponseEntity<?> deleteOwner(Long id){
        HashMap<String, Object> message = new HashMap<>();

        try {
            if (!(id == null)){
                daoService.deletByIdOwner(id);
                message.put("Message", "Eliminado con exito");
            }else {
                message.put("Error", "El id no existe");
                return new ResponseEntity<HashMap<String, Object>>(message, HttpStatus.NOT_FOUND);
            }

        }catch (Exception e){
            e.printStackTrace();
            message.put("Error", e.toString());
            return new ResponseEntity<HashMap<String, Object>>(message, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<HashMap<String, Object>>(message, HttpStatus.OK);
    }

    //Listar veterinarios
    public ResponseEntity<?> findAllVeterinary() {
        List<Veterinary> list = null;
        HashMap<String, Object> message = new HashMap<>();

        try {
            list = daoService.findAllVeterinary();
            if (!list.isEmpty()) {
                message.put("List", list);
                message.put("Message", "Lista mostrada con exito");
            } else{
                message.put("Empty", "Lista vacia");
                return new ResponseEntity<HashMap<String, Object>>(message, HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {
            e.printStackTrace();
            message.put("Error", e.toString());
            return new ResponseEntity<HashMap<String, Object>>(message, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<HashMap<String, Object>>(message, HttpStatus.OK);
    }

    // Crear un veterinario
    public ResponseEntity<?> createVeterinary(Veterinary veterinary) {
        Veterinary newVeterinary = null;
        HashMap<String, Object> message = new HashMap<>();

        try {
            newVeterinary = daoService.findByIdVeterinary(veterinary.getId());
            if (newVeterinary == null) {
                newVeterinary = daoService.createVeterinary(veterinary);
                message.put("Veterinario", newVeterinary);
                message.put("Message", "Creado con exito");
            } else {
                message.put("Error", "Registro con ID existente");
                message.put("Message", "Ingrese un nuevo ID");
                return new ResponseEntity<HashMap<String, Object>>(message, HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {
            e.printStackTrace();
            message.put("Error", e.toString());
            return new ResponseEntity<HashMap<String, Object>>(message, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<HashMap<String, Object>>(message, HttpStatus.CREATED);
    }

    // Editar veterinario
    public ResponseEntity<?> updateVeterinary(Veterinary veterinary){
        Veterinary updateVeterinary = null;
        HashMap<String, Object> message = new HashMap<>();

        try {
            updateVeterinary = daoService.findByIdVeterinary(veterinary.getId());
            if (!(updateVeterinary == null)){

                updateVeterinary.setName(veterinary.getName());
                updateVeterinary.setLastName(veterinary.getLastName());
                updateVeterinary.setSecondLastName(veterinary.getSecondLastName());;
                updateVeterinary.setLicense(veterinary.getLicense());
                daoService.createVeterinary(updateVeterinary);
                message.put("Veterinario", updateVeterinary);
                message.put("Message", "Actualizado con exito");
            }else {
                message.put("Error", "Error al editar");
                return new ResponseEntity<HashMap<String, Object>>(message, HttpStatus.NOT_FOUND);
            }

        }catch (Exception e){
            e.printStackTrace();
            message.put("Error", e.toString());
            return new ResponseEntity<HashMap<String, Object>>(message, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<HashMap<String, Object>>(message, HttpStatus.CREATED);
    }

    // Eliminar veterinario
    public ResponseEntity<?> deleteVeterinary(Long id){
        HashMap<String, Object> message = new HashMap<>();

        try {
            if (!(id == null)){
                daoService.deletByIdVeterinary(id);
                message.put("Message", "Eliminado con exito");
            }else {
                message.put("Error", "El id no existe");
                return new ResponseEntity<HashMap<String, Object>>(message, HttpStatus.NOT_FOUND);
            }

        }catch (Exception e){
            e.printStackTrace();
            message.put("Error", e.toString());
            return new ResponseEntity<HashMap<String, Object>>(message, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<HashMap<String, Object>>(message, HttpStatus.OK);
    }

}
