package fr.chapte.ludotheque.bll;

import fr.chapte.ludotheque.bo.Emprunt;
import fr.chapte.ludotheque.dal.DAOEmprunt;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class EmpruntServiceImpl implements EmpruntService {

private DAOEmprunt daoEmprunt;

    public EmpruntServiceImpl(DAOEmprunt daoEmprunt) {
        this.daoEmprunt = daoEmprunt;
    }

    @Override
    public void addEmprunt(Emprunt emprunt) {
        daoEmprunt.create(emprunt);
    }

    @Override
    public void removeEmprunt(int id) {
        daoEmprunt.delete(id);
    }

    @Override
    public List<Emprunt> getEmprunts() {
        return daoEmprunt.read();
    }

    @Override
    public Emprunt getEmpruntbyID(int id) {
        return daoEmprunt.read(id);
    }

    @Override
    public void updateEmprunt(Emprunt emprunt) {
        daoEmprunt.update(emprunt);
    }

}
