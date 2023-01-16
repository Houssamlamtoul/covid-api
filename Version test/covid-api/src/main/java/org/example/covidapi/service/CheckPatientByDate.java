package org.example.covidapi.service;

import java.util.Map;
import java.util.Optional;

import org.example.covidapi.entity.Patient;
import org.example.covidapi.repository.BookingRepository;
import org.example.covidapi.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.example.covidapi.exception.ResourceNotFoundException;
import java.time.LocalDate;

@RestController
public class CheckPatientByDate {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private PatientRepository patientRepository;

    @PostMapping("/api/getpatientdata")
    public Patient getPatientData(@RequestBody Map<String, Object> data) {
        LocalDate date = (LocalDate) data.get("date");

        int patientId = bookingRepository.findByDate(date).getId_patient();
        Optional<Patient> patient = patientRepository.findById(patientId);

        if (patient.isPresent()) {
            return patient.get();
        } else {
            throw new ResourceNotFoundException("Patient", "id", patientId);
        }
    }
}
