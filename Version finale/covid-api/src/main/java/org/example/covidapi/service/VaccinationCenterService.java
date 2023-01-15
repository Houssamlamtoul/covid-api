package org.example.covidapi.service;

import org.example.covidapi.VaccinationCentre;
import org.example.covidapi.repository.VaccinationCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import io.github.resilience4j.ratelimiter.RequestNotPermitted;






@Service
public class VaccinationCenterService {
    @Autowired
    private VaccinationCenterRepository vaccinationCenterRepository;

    public VaccinationCenterService(VaccinationCenterRepository vaccinationCenterRepository) {
        this.vaccinationCenterRepository = vaccinationCenterRepository;
    }

    public Integer getVaccinationCenterIdByName(String name) {
        VaccinationCentre center = vaccinationCenterRepository.findByNameIgnoreCaseLike(name);
        if (center != null) {
            return center.getId();
        } else {
            return null;
        }
    }
    //@RateLimiter(name = "default")
    public ResponseEntity<Void> saveVaccinationCenter(VaccinationCentre vaccinationCentre) {
        try {
            vaccinationCenterRepository.save(vaccinationCentre);
            return ResponseEntity.ok().build();
        } catch (RequestNotPermitted e) {
            return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS).build();
        }
    }
}