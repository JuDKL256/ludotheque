package fr.chapte.ludotheque.bo;

import java.time.LocalDate;

public class Emprunt {

    private int id;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private Jeu jeu;
    private Membre membre;

    public Emprunt() {
    }

    public Emprunt(int id, LocalDate dateDebut, LocalDate dateFin, Jeu jeu, Membre membre) {
        this.id = id;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.jeu = jeu;
        this.membre = membre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public Jeu getJeu() {
        return jeu;
    }

    public void setJeu(Jeu jeu) {
        this.jeu = jeu;
    }

    public Membre getMembre() {
        return membre;
    }

    public void setMembre(Membre membre) {
        this.membre = membre;
    }
}
