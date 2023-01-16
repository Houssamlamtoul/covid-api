package org.example.covidapi.controllers;

//import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.example.covidapi.ResourceNotFoundException;
import org.example.covidapi.VaccinationCentre;
import org.example.covidapi.repository.VaccinationCenterRepository;
import org.example.covidapi.service.IdGeneratorService;
import org.example.covidapi.service.VaccinationCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class PublicVaccinationCenterRestControler {

    @Autowired
    private VaccinationCenterRepository centerRepository;
    @Autowired
    private VaccinationCenterService centerService;

    @GetMapping(path = "api/public/center")
    public List<VaccinationCentre> getVaccinationCenter() {
        List<VaccinationCentre> centers = centerRepository.findAll();
        System.out.println(centers);
        return centers;
    }

    @PutMapping("/vaccinationcentre")
    public ResponseEntity<VaccinationCentre> updateVaccinationCentre(
            @Valid @RequestBody VaccinationCentre vaccinationCentreDetails) {

        VaccinationCentre vaccinationCentre = centerRepository.findById(vaccinationCentreDetails.getId());
        if (vaccinationCentre == null) {
            throw new ResourceNotFoundException("VaccinationCentre", "id", vaccinationCentreDetails.getId());
        }

        vaccinationCentre.setAddress(vaccinationCentreDetails.getAddress());
        vaccinationCentre.setCity(vaccinationCentreDetails.getCity());
        vaccinationCentre.setPostalCode(vaccinationCentreDetails.getPostalCode());
        vaccinationCentre.setName(vaccinationCentreDetails.getName());

        final VaccinationCentre updatedVaccinationCentre = centerRepository.save(vaccinationCentre);
        System.out.println("Data updated: " + updatedVaccinationCentre);
        return ResponseEntity.ok(updatedVaccinationCentre);
    }

    @DeleteMapping("/vaccinationcentre/{id}")
    public ResponseEntity<Void> deleteVaccinationCentre(@PathVariable(value = "id") int id) {
        VaccinationCentre vaccinationCentre = centerRepository.findById(id);
        if (vaccinationCentre == null) {
            throw new ResourceNotFoundException("VaccinationCentre", "id", id);
        }

        centerRepository.delete(vaccinationCentre);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/api/newcentre")
    public void receiveData(@RequestBody Map<String, Object> data) {
        System.out.println("Received data: " + data);

        String name = (String) data.get("nom");
        String address = (String) data.get("address");
        String city = (String) data.get("city");
        String postalcode = (String) data.get("codepostal");
        int maxId = centerRepository.findMaxId();

        VaccinationCentre vaccinationCentre = new VaccinationCentre();

        vaccinationCentre.setName(name);
        vaccinationCentre.setAddress(address);
        vaccinationCentre.setCity(city);
        vaccinationCentre.setPostalCode(postalcode);
        vaccinationCentre.setId(maxId + 1);
        centerService.saveVaccinationCenter(vaccinationCentre);
    }

}