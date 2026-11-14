
package com.radflow.backend.patient.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record PatientRegistrationResponse(
        Long id,
        String mrn,
        String fullName,
        String gender,
        LocalDate dateOfBirth,
        String phone,
        LocalDateTime createdAt
) {}
