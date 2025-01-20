package fr.chapte.ludotheque.bll;

import fr.chapte.ludotheque.bo.Membre;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MembreService {
    void addMembre(Membre membre);

    void removeMembre(int id);

    List<Membre> getMembres();

    Membre getMembrebyID(int id);

    void updateMembre(Membre membre);
}
