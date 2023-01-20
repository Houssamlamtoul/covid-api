package org.example.covidapi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.filter.CorsFilter;
import org.example.covidapi.entity.utilisateur;
import org.example.covidapi.repository.UtilisateurRepository;
import org.example.covidapi.service.VaccinationCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Component
public class DataInsertionRunner implements CommandLineRunner {

   @Autowired
    private VaccinationCenterService service;

   @Autowired
    private UtilisateurRepository utilisateurRepository;

   @Autowired
    private PasswordEncoder encoder;


    @Override
    public void run(String... args) throws Exception {
        List<VaccinationCentre> centers = new ArrayList<>();
        centers.add(
                new VaccinationCentre(0, "CH Narbonne", "Boulevard Dr Lacroix, 11100 Narbonne", "11100", "Narbonne"));
        centers.add(
                new VaccinationCentre(1, "Nancy - Tour Marcel Brot", "A, Rue Joseph Cugnot, 54500", "54500", "Nancy"));
        utilisateur user = new utilisateur("superadmin", "password", "Superadmin", null, null);
        user.setpassword(encoder.encode("password"));
        utilisateurRepository.save(user );

        service.insertMultipleVaccinationCenters(centers);
    }





 
    @Bean	
    public org.springframework.web.filter.CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
      CorsConfiguration corsConfiguration = new CorsConfiguration();
      corsConfiguration.setAllowCredentials(true);
      //corsConfiguration.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
      corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200","http://13.37.112.147","http://www.tosucceed.site" ,"http://tosucceed.site"));
      corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
            "Accept", "Jwt-Token", "Authorization", "Origin, Accept", "X-Requested-With",
            "Access-Control-Request-Method", "Access-Control-Request-Headers", "application/x-www-form-urlencoded"));
      corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Jwt-Token", "Authorization",
            "Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));
      corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
      urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
      return new CorsFilter(urlBasedCorsConfigurationSource);
    }

}