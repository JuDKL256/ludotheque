package fr.chapte.ludotheque.bll;

import fr.chapte.ludotheque.bo.JeuSociete;
import fr.chapte.ludotheque.dal.DAOJeuSociete;
import fr.chapte.ludotheque.dal.DAOJeuSociete;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JeuSocieteServiceImpl implements JeuSocieteService {

    private DAOJeuSociete daoJeuSociete;

    public JeuSocieteServiceImpl(DAOJeuSociete daoJeuSociete) {
        this.daoJeuSociete = daoJeuSociete;
    }

    @Override
    public void addJeuSociete(JeuSociete jeuSociete) {
        daoJeuSociete.create(jeuSociete);
    }

    @Override
    public void removeJeuSociete(int id) {
        daoJeuSociete.delete(id);
    }

    @Override
    public List<JeuSociete> getJeuSocietes() {
        return daoJeuSociete.read();
    }

    @Override
    public JeuSociete getJeuSocietebyID(int id) {
        return daoJeuSociete.read(id);
    }

    @Override
    public void updateJeuSociete(JeuSociete jeuSociete) {
        daoJeuSociete.update(jeuSociete);
    }
}
