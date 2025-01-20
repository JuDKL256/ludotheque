package fr.chapte.ludotheque.dal;

import fr.chapte.ludotheque.bo.Emprunt;

import java.util.List;

public interface DAOEmprunt {
    int create(Emprunt emprunt);

    List<Emprunt> read();

    Emprunt read(int id);

    void update(Emprunt emprunt);

    void delete(Emprunt emprunt);

    void delete(int id);
}
