package fr.chapte.ludotheque.bo;

public class JeuSociete extends Jeu{

    private float difficulte;
    private float interet;

    public JeuSociete() {
        super();
    }

    public JeuSociete(int id, String titre, Etat etat, int age, String description, float difficulte, float interet) {
        super(id, titre,  etat, age, description);
        this.difficulte = difficulte;
        this.interet = interet;
    }

    public float getDifficulte() {
        return difficulte;
    }

    public void setDifficulte(float difficulte) {
        this.difficulte = difficulte;
    }

    public float getInteret() {
        return interet;
    }

    public void setInteret(float interet) {
        this.interet = interet;
    }
}
