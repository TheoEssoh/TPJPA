package jpa.business;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Fiche implements Serializable {
     Long id;
     String nom;
     int dureeEnMinute;

     @Id
     @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getDureeEnMinute() {
        return dureeEnMinute;
    }

    public void setDureeEnMinute(int dureeEnMinute) {
        this.dureeEnMinute = dureeEnMinute;
    }
}
