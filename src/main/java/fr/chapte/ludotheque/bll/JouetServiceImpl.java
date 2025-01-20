package fr.chapte.ludotheque.bll;

import fr.chapte.ludotheque.bo.Jouet;
import fr.chapte.ludotheque.dal.DAOJouet;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JouetServiceImpl implements JouetService {

private DAOJouet daoJouet;

    public JouetServiceImpl(DAOJouet daoJouet) {
        this.daoJouet = daoJouet;
    }

    @Override
    public void addJouet(Jouet jouet) {
        daoJouet.create(jouet);
    }

    @Override
    public void removeJouet(int id) {
        daoJouet.delete(id);
    }

    @Override
    public List<Jouet> getJouets() {
        return daoJouet.read();
    }

    @Override
    public Jouet getJouetbyID(int id) {
        return daoJouet.read(id);
    }

    @Override
    public void updateJouet(Jouet jouet) {
        daoJouet.update(jouet);
    }

}
