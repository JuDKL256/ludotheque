package fr.chapte.ludotheque.bo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Membre {

    private int id;
    private String nom;
    private String prenom;
    private String telephone;
    private LocalDate dateAdhesion;

    public Membre() {
    }

    public Membre(int id, String nom, String prenom, String telephone, LocalDate dateAdhesion) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.dateAdhesion = dateAdhesion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public LocalDate getDateAdhesion() {
        return dateAdhesion;
    }

    public void setDateAdhesion(LocalDate dateAdhesion) {
        this.dateAdhesion = dateAdhesion;
    }

    @Override
    public String toString() {
        return "Membre { " + nom +
                " " + prenom +
                ", Inscrit depuis :" + dateAdhesion.format(DateTimeFormatter.ofPattern("dd MMMM YYYY")) +
                '}';
    }
}
