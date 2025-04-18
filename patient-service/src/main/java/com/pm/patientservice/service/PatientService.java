package com.pm.patientservice.service;


import com.pm.patientservice.Repository.PatientRepository;
import com.pm.patientservice.dto.PatientRequestDTO;
import com.pm.patientservice.dto.PatientResponseDTO;
import com.pm.patientservice.mapper.PatientMapper;
import com.pm.patientservice.model.Patient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    //get all patients
    public List<PatientResponseDTO> getPatients(){

        List<Patient> patients = patientRepository.findAll();

        return patients.stream()
                .map(PatientMapper::toDTO).toList();
    }

    // create new patient
    public PatientResponseDTO createPatient(PatientRequestDTO patientRequestDTO){

//        if (patientRepository.existsByEmail(patientRequestDTO.getEmail())){
//            throw new
//        }
        Patient patient = patientRepository.save(PatientMapper.toModel(patientRequestDTO));
        return PatientMapper.toDTO(patient);
    }


}
