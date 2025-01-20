package fr.chapte.ludotheque.bll;

import fr.chapte.ludotheque.bo.TypeJouet;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TypeJouetService {
    void addTypeJouet(TypeJouet typeJouet);

    void removeTypeJouet(int id);

    List<TypeJouet> getTypeJouets();

    TypeJouet getTypeJouetbyID(int id);

    void updateTypeJouet(TypeJouet typeJouet);
}
