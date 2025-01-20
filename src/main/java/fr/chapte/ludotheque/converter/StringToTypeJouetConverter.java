package fr.chapte.ludotheque.converter;

import fr.chapte.ludotheque.bll.TypeJouetService;
import fr.chapte.ludotheque.bo.TypeJouet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToTypeJouetConverter implements Converter<String, TypeJouet> {

    @Autowired
    private TypeJouetService typeJouetService;

    @Override
    public TypeJouet convert(String source) {
        return typeJouetService.getTypeJouetbyID(Integer.parseInt(source));
    }

    @Override
    public <U> Converter<String, U> andThen(Converter<? super TypeJouet, ? extends U> after) {
        return Converter.super.andThen(after);
    }
}
