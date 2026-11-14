
package com.radflow.backend.patient;

import org.springframework.stereotype.Component;

@Component
public class MrnGenerator {

    public String generate(Long patientId) {
        if (patientId == null || patientId <= 0) {
            throw new IllegalArgumentException(
                    "Patient ID must be positive"
            );
        }

        return "RF-%06d".formatted(patientId);
    }
}
