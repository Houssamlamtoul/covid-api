package org.example.covidapi.service;

import org.example.covidapi.entity.Patient;
import org.example.covidapi.repository.PatientRepository;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Patient findByNomAndPrenomAndEmail(String nom, String prenom, String email) {
        return patientRepository.findByNomAndPrenomAndEmail(nom, prenom, email);
    }

    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }
}
