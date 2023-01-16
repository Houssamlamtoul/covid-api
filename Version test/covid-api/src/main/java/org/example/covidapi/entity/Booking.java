package org.example.covidapi.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.example.covidapi.VaccinationCentre;

@Entity
public class Booking {
    @Id
    private Integer id;
    private String date;
    private String nom;
    private String prenom;
    private String email;
    private Integer id_vaccination_center;
    private Integer id_patient;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String string) {
        this.date = string;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId_vaccination_center() {
        return id_vaccination_center;
    }

    public void setId_vaccination_center(Integer id_vaccination_center) {
        this.id_vaccination_center = id_vaccination_center;
    }

    public Integer getId_patient() {
        return id_patient;
    }

    public void setId_patient(Integer id_patient) {
        this.id_patient = id_patient;
    }

}