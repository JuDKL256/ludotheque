package fr.chapte.ludotheque.dal;

import fr.chapte.ludotheque.bo.JeuSociete;

import java.util.List;

public interface DAOJeuSociete {
    int create(JeuSociete jeuSociete);

    List<JeuSociete> read();

    JeuSociete read(int id);

    void update(JeuSociete jeuSociete);

    void delete(JeuSociete jeuSociete);

    void delete(int id);
}
