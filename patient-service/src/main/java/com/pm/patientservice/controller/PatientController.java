package com.pm.patientservice.controller;


import com.pm.patientservice.dto.PatientRequestDTO;
import com.pm.patientservice.dto.PatientResponseDTO;
import com.pm.patientservice.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/patients")
    public ResponseEntity<List<PatientResponseDTO>> getPatients(){

        return ResponseEntity.ok().body(patientService.getPatients());
    }

    @GetMapping
    public String getApp(){

        return "Your server is up and running";
    }

    @PostMapping("/patients")
    public ResponseEntity<PatientResponseDTO> createNewPatient(
            @Valid @RequestBody PatientRequestDTO patientRequestDTO){
        PatientResponseDTO patientResponseDTO =
                patientService.createPatient(patientRequestDTO);
        return ResponseEntity.status(201).body(patientResponseDTO);

    }

}
