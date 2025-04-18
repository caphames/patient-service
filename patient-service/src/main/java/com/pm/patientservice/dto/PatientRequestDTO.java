package com.pm.patientservice.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class PatientRequestDTO {

    @NotBlank(message = "Patient name is mandatory")
    @Size(max = 100, message = "name size can be up to 100")
    private String name;

    @NotBlank(message = "email is mandatory")
    @Email
    @Column(unique = true)
    private String email;

    @NotBlank
    private String address;

    @NotBlank
    private String dateOfBirth;

    @NotBlank
    private String registeredDate;

    public @NotBlank(message = "Patient name is mandatory") @Size(max = 100, message = "name size can be up to 100") String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "Patient name is mandatory") @Size(max = 100, message = "name size can be up to 100") String name) {
        this.name = name;
    }

    public @NotBlank(message = "email is mandatory") @Email String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "email is mandatory") @Email String email) {
        this.email = email;
    }

    public @NotBlank String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(@NotBlank String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public @NotBlank String getAddress() {
        return address;
    }

    public void setAddress(@NotBlank String address) {
        this.address = address;
    }

    public @NotBlank String getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(@NotBlank String registeredDate) {
        this.registeredDate = registeredDate;
    }
}
