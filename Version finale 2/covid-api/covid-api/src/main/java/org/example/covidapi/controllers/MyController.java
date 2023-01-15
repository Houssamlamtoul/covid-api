package org.example.covidapi.controllers;

import java.time.LocalDateTime;

import org.example.covidapi.dto.BookingDto;
import org.example.covidapi.entity.Booking;
import org.example.covidapi.entity.Patient;
import org.example.covidapi.service.BookingService;
import org.example.covidapi.service.IdGeneratorService;
import org.example.covidapi.service.PatientService;
import org.example.covidapi.service.VaccinationCenterService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MyController {

  private final BookingService bookingService;
  private final PatientService patientService;
  private final IdGeneratorService idGeneratorService;
  private final VaccinationCenterService vaccinationCenterService;

  public MyController(BookingService bookingService, PatientService patientService,
      IdGeneratorService idGeneratorService, VaccinationCenterService vaccinationCenterService) {
    this.bookingService = bookingService;
    this.patientService = patientService;
    this.idGeneratorService = idGeneratorService;
    this.vaccinationCenterService = vaccinationCenterService;
  }

  @PostMapping("/api/endpoint")
  public void receiveData(@RequestBody Map<String, Object> data) {
    System.out.println("Received data: " + data);

    String nom = (String) data.get("nom");
    String prenom = (String) data.get("prenom");
    String email = (String) data.get("email");
    String date = (String) data.get("date");
    String centerName = (String) data.get("centerName");

    // Check if patient already exists
    Patient existingPatient = patientService.findByNomAndPrenomAndEmail(nom, prenom, email);
    if (existingPatient != null) {
      // Use existing patient's id
      Integer patientId = existingPatient.getId();
      // Create a new booking
      Integer bookingId = idGeneratorService.generateId1();
      Integer vaccinationCenterId = vaccinationCenterService.getVaccinationCenterIdByName(centerName);
      Booking booking = new Booking();
      booking.setId(bookingId);
      booking.setDate(date);
      booking.setId_patient(patientId);
      booking.setId_vaccination_center(vaccinationCenterId);

      booking.setEmail(email);
      bookingService.saveBooking(booking);
    } else {
      // Create a new patient
      Integer patientId = idGeneratorService.generateId2();
      Patient newPatient = new Patient();
      newPatient.setId(patientId);
      newPatient.setNom(nom);
      newPatient.setPrenom(prenom);
      newPatient.setEmail(email);
      patientService.savePatient(newPatient);

      // Create a new booking
      Integer bookingId = idGeneratorService.generateId1();
      Integer vaccinationCenterId = vaccinationCenterService.getVaccinationCenterIdByName(centerName);
      Booking booking = new Booking();

      booking.setEmail(email);
      booking.setId(bookingId);
      booking.setDate(date);
      booking.setId_patient(patientId);
      booking.setId_vaccination_center(vaccinationCenterId);
      bookingService.saveBooking(booking);
    }

  }

}