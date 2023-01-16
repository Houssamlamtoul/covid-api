package org.example.covidapi.controllers;

import org.example.covidapi.dto.UtilisateurDto;
import org.example.covidapi.entity.utilisateur;
import org.example.covidapi.service.AuthentificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/user")
public class utilisateurController {

    @Autowired
    AuthentificationService authentificationService;

    @PostMapping("/login")
    public UserDetails login(@RequestBody UtilisateurDto utilisateur){
        return authentificationService.loadUserByUsername(utilisateur.getLogin());
    }

}