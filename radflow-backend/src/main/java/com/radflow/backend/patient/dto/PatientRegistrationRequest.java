
package com.radflow.backend.patient.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record PatientRegistrationRequest(

        @NotBlank
        @Size(max = 100)
        String firstName,

        @NotBlank
        @Size(max = 100)
        String lastName,

        @NotBlank
        String gender,

        @Past
        LocalDate dateOfBirth,

        @Pattern(regexp = "^[0-9]{10}$")
        String phone

) {}
