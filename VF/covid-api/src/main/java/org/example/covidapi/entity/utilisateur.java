package org.example.covidapi.entity;

import java.util.Collection;

import javax.persistence.*;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class utilisateur  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String login;
    @Column(nullable = false)
    private String password;
    private String nom;
    private String prenom;
    private String email;

    public utilisateur(String login, String password, String nom, String prenom, String email) {
        this.login = login;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;

    }

    public utilisateur() {
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getpassword() {
        return this.password;
    }

    public void setpassword(String password) {
        this.password = password;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    


    // @Override
    // public Collection<? extends GrantedAuthority> getAuthorities() {
    //     // TODO Auto-generated method stub
    //     return null;
    // }

    // @Override
    // public String getPassword() {
    //     // TODO Auto-generated method stub
    //     return this.password;
    // }

    // @Override
    // public String getUsername() {
    //     // TODO Auto-generated method stub
    //     return this.login;
    // }

    // @Override
    // public boolean isAccountNonExpired() {
    //     // TODO Auto-generated method stub
    //     return true;
    // }

    // @Override
    // public boolean isAccountNonLocked() {
    //     // TODO Auto-generated method stub
    //     return true;
    // }

    // @Override
    // public boolean isCredentialsNonExpired() {
    //     // TODO Auto-generated method stub
    //     return true;
    // }

    // @Override
    // public boolean isEnabled() {
    //     // TODO Auto-generated method stub
    //     return true;
    // }

}