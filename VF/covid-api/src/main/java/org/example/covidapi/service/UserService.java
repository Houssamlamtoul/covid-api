package org.example.covidapi.service;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.example.covidapi.entity.utilisateur;
import org.example.covidapi.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService{

   @Autowired
    private  UtilisateurRepository utilisateurRepository;
    
    @Autowired
    private  PasswordEncoder passwordEncoder;

    public void UserService (UtilisateurRepository rep, PasswordEncoder pass){

        this.passwordEncoder = pass;
        this.utilisateurRepository = rep;
    }

    @PostConstruct
  public void createUserDefault(){
      utilisateur utilisateur = new utilisateur();
      utilisateur.setLogin("user");
      utilisateur.setpassword(passwordEncoder.encode("password"));
      this.utilisateurRepository.save(utilisateur);
  }

  @Override
  public UserDetails loadUserByUsername(final String login)
          throws UsernameNotFoundException {

      Optional<utilisateur> optionalUtilisateur = utilisateurRepository.findByLogin(login);
      if (optionalUtilisateur.isPresent()) {
        utilisateur user = optionalUtilisateur.get();
        return new User(user.getLogin(),user.getpassword(),List.of());
        
      } else {
        throw new UsernameNotFoundException("L'utilisateur" + login + " n'existe pas");
      }
  }
    
}
