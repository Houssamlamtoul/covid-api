package org.example.covidapi.controllers;

import org.example.covidapi.entity.Booking;
import org.example.covidapi.entity.Patient;
import org.example.covidapi.exception.ResourceNotFoundException;

import org.example.covidapi.repository.PatientRepository;
import org.example.covidapi.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController

@RequestMapping("/api")
public class PatientController {
    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @PostMapping("/getpatientdata")
    public Patient getPatientData(@RequestBody Map<String, Object> data) {
        String date = data.get("date").toString();
        System.out.println("Received date: " + date);

        Booking booking = bookingRepository.findByDate(date);
        if (booking == null) {
            throw new ResourceNotFoundException("Booking", "date", date);
        }

        Patient patient = patientRepository.findById(booking.getId_patient())
                .orElseThrow(() -> new ResourceNotFoundException("Patient", "id", booking.getId_patient()));

        System.out.println("Patient found: " + patient);
        return patient;
    }
}