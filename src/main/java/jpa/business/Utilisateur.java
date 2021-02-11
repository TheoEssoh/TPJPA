package jpa.business;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Utilisateur implements Serializable {

    String nom;
    String mail;

    @Id
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }


   public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
