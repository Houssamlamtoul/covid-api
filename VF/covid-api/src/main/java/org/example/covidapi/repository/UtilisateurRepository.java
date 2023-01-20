package org.example.covidapi.repository;
import java.util.Optional;

import org.example.covidapi.entity.utilisateur;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepository extends JpaRepository<utilisateur, Integer>{
    Optional<utilisateur> findByLogin(String login);

}
