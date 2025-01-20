package fr.chapte.ludotheque.bo;

public class Jouet extends Jeu{

    private TypeJouet typeJouet;

    public Jouet() {
        super();
    }

    public Jouet(int id, String titre,
                 Etat etat, int age, String description
                 , TypeJouet typeJouet) {
        super(id, titre, etat, age, description);
        this.typeJouet = typeJouet;
    }

    public TypeJouet getTypeJouet() {
        return typeJouet;
    }

    public void setTypeJouet(TypeJouet typeJouet) {
        this.typeJouet = typeJouet;
    }
}
