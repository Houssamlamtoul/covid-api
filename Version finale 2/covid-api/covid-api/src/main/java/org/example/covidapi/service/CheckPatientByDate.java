package org.example.covidapi.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.example.covidapi.entity.Booking;
import org.example.covidapi.entity.Patient;
import org.example.covidapi.exception.ResourceNotFoundException;

import org.example.covidapi.repository.BookingRepository;
import org.example.covidapi.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")

@RestController
public class CheckPatientByDate {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private PatientRepository patientRepository;

    @PostMapping("/api/checkpatientbydate")
    public Patient getPatientData(@RequestBody Map<String, Object> data) {
        String date = data.get("date").toString();
        System.out.println("Received date: " + date);

        Booking booking = bookingRepository.findByDate(date);
        if (booking == null) {
            throw new ResourceNotFoundException("Booking", "date", date);
        }

        Optional<Patient> patient = patientRepository.findById(booking.getId_patient());
        if (!patient.isPresent()) {
            throw new ResourceNotFoundException("Patient", "id", booking.getId_patient());
        }

        System.out.println("Patient found: " + patient.get());
        return patient.get();
    }
}