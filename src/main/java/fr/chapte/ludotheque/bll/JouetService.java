package fr.chapte.ludotheque.bll;

import fr.chapte.ludotheque.bo.Jouet;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface JouetService {
    void addJouet(Jouet jouet);

    void removeJouet(int id);

    List<Jouet> getJouets();

    Jouet getJouetbyID(int id);

    void updateJouet(Jouet jouet);
}
