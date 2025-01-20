package fr.chapte.ludotheque.dal;

import fr.chapte.ludotheque.bo.TypeJouet;

import java.util.List;

public interface DAOTypeJouet {
    int create(TypeJouet typeJouet);

    List<TypeJouet> read();

    TypeJouet read(int id);

    void update(TypeJouet typeJouet);

    void delete(TypeJouet typeJouet);

    void delete(int id);
}
