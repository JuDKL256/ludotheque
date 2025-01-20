package fr.chapte.ludotheque.bll;

import fr.chapte.ludotheque.bo.JeuSociete;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface JeuSocieteService {
    void addJeuSociete(JeuSociete jeuSociete);

    void removeJeuSociete(int id);

    List<JeuSociete> getJeuSocietes();

    JeuSociete getJeuSocietebyID(int id);

    void updateJeuSociete(JeuSociete jeuSociete);
}
