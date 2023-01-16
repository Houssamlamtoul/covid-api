package org.example.covidapi;

import java.util.ArrayList;
import java.util.List;

import org.example.covidapi.entity.utilisateur;
import org.example.covidapi.repository.UtilisateurRepository;
import org.example.covidapi.service.VaccinationCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInsertionRunner implements CommandLineRunner {

    @Autowired
    private VaccinationCenterService service;

    @Autowired
    private UtilisateurRepository utilisateurRepository;


    @Override
    public void run(String... args) throws Exception {
        List<VaccinationCentre> centers = new ArrayList<>();
        centers.add(
                new VaccinationCentre(0, "CH Narbonne", "Boulevard Dr Lacroix, 11100 Narbonne", "11100", "Narbonne"));
        centers.add(
                new VaccinationCentre(1, "Nancy - Tour Marcel Brot", "A, Rue Joseph Cugnot, 54500", "54500", "Nancy"));
        utilisateurRepository.save(
            new utilisateur("superadmin", "password", "Superadmin", null, null)
        );
        service.insertMultipleVaccinationCenters(centers);
    }
}