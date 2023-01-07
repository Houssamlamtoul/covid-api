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
    private LocalDateTime date;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_patient", nullable = false)
    private Patient patient;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_vaccination_center", nullable = false)
    private VaccinationCentre center;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public VaccinationCentre getCenter() {
        return center;
    }

    public void setCenter(VaccinationCentre center) {
        this.center = center;
    }

}
