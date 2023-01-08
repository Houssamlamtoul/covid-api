package org.example.covidapi.controllers;

//import java.util.Arrays;
import java.util.List;

import org.example.covidapi.VaccinationCentre;
import org.example.covidapi.repesitory.VaccinationCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class PublicVaccinationCenterRestControler {
    @Autowired
    private VaccinationCenterRepository centerRepository;

    @GetMapping(path = "api/public/center")
    public List<VaccinationCentre> getVaccinationCenter() {
        List<VaccinationCentre> centers = centerRepository.findAll();
        System.out.println(centers);
        return centers;
    }
}
