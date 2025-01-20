package fr.chapte.ludotheque.dal;

import fr.chapte.ludotheque.bo.Jouet;

import java.util.List;

public interface DAOJouet {
    int create(Jouet jouet);

    List<Jouet> read();

    Jouet read(int id);

    void update(Jouet jouet);

    void delete(Jouet jouet);

    void delete(int id);
}
