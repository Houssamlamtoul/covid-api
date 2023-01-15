package org.example.covidapi.repository;

import java.util.Optional;

import org.example.covidapi.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {
    Patient findByNomAndPrenomAndEmail(String nom, String prenom, String email);

    public Optional<Patient> findById(int id);
}