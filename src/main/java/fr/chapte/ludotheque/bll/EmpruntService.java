package fr.chapte.ludotheque.bll;

import fr.chapte.ludotheque.bo.Emprunt;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmpruntService {
    void addEmprunt(Emprunt emprunt);

    void removeEmprunt(int id);

    List<Emprunt> getEmprunts();

    Emprunt getEmpruntbyID(int id);

    void updateEmprunt(Emprunt emprunt);
}
