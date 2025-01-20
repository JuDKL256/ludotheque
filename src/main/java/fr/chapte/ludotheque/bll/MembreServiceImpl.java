package fr.chapte.ludotheque.bll;

import fr.chapte.ludotheque.bo.Membre;
import fr.chapte.ludotheque.dal.DAOMembre;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class MembreServiceImpl implements MembreService {

private DAOMembre daoMembre;

    public MembreServiceImpl(DAOMembre daoMembre) {
        this.daoMembre = daoMembre;
    }

    @Override
    public void addMembre(Membre membre) {
        daoMembre.create(membre);
    }

    @Override
    public void removeMembre(int id) {
        daoMembre.delete(id);
    }

    @Override
    public List<Membre> getMembres() {
        return daoMembre.read();
    }

    @Override
    public Membre getMembrebyID(int id) {
        return daoMembre.read(id);
    }

    @Override
    public void updateMembre(Membre membre) {
        daoMembre.update(membre);
    }

}
