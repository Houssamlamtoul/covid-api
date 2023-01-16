package org.example.covidapi.repository;
import org.example.covidapi.entity.utilisateur;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepository extends JpaRepository<utilisateur, Integer>{
    utilisateur findByLogin(String login);

}
