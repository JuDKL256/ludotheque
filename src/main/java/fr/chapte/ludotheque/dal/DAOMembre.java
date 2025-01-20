package fr.chapte.ludotheque.dal;

import fr.chapte.ludotheque.bo.Membre;

import java.util.List;

public interface DAOMembre {
    int create(Membre membre);

    List<Membre> read();

    Membre read(int id);

    void update(Membre membre);

    void delete(Membre membre);

    void delete(int id);
}
