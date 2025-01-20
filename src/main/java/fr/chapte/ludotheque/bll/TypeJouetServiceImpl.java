package fr.chapte.ludotheque.bll;

import fr.chapte.ludotheque.bo.TypeJouet;
import fr.chapte.ludotheque.dal.DAOTypeJouet;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TypeJouetServiceImpl implements TypeJouetService {

private DAOTypeJouet daoTypeJouet;

    public TypeJouetServiceImpl(DAOTypeJouet daoTypeJouet) {
        this.daoTypeJouet = daoTypeJouet;
    }

    @Override
    public void addTypeJouet(TypeJouet typeJouet) {
        daoTypeJouet.create(typeJouet);
    }

    @Override
    public void removeTypeJouet(int id) {
        daoTypeJouet.delete(id);
    }

    @Override
    public List<TypeJouet> getTypeJouets() {
        return daoTypeJouet.read();
    }

    @Override
    public TypeJouet getTypeJouetbyID(int id) {
        return daoTypeJouet.read(id);
    }

    @Override
    public void updateTypeJouet(TypeJouet typeJouet) {
        daoTypeJouet.update(typeJouet);
    }

}
