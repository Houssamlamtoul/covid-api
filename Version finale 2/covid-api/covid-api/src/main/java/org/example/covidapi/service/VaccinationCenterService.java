package org.example.covidapi.service;

import java.util.List;

import org.example.covidapi.VaccinationCentre;
import org.example.covidapi.repository.VaccinationCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VaccinationCenterService {
    @Autowired
    private VaccinationCenterRepository vaccinationCenterRepository;

    @Autowired
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

    public void saveVaccinationCenter(VaccinationCentre vaccinationCentre) {
        vaccinationCenterRepository.save(vaccinationCentre);
    }

    public void insertMultipleVaccinationCenters(List<VaccinationCentre> centers) {
        vaccinationCenterRepository.saveAll(centers);
    }
}