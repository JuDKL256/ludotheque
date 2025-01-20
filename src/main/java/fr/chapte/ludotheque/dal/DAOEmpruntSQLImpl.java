package fr.chapte.ludotheque.dal;

import fr.chapte.ludotheque.bo.Emprunt;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DAOEmpruntSQLImpl implements DAOEmprunt {

    static final String SELECT_ALL = "select * from Emprunt";
    static final String SELECT_BY_ID = "select * from Emprunt where id=?";
    static final String INSERT = "INSERT  INTO Emprunt ([dateDebut],[dateFin],[membre_id],[jeu_id]) VALUES (:dateDebut,:dateFin,:membre_id,:jeu_id)";
    static final String DELETE = "DELETE FROM Emprunt where id=?";
    static final String UPDATE = "UPDATE Emprunt set dateDebut=?,dateFin=?,membre_id=?,jeu_id=? where id=?";

    JdbcTemplate jdbcTemplate;
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public DAOEmpruntSQLImpl(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public int create(Emprunt emprunt) {
        var namedparameters = new MapSqlParameterSource();
        namedparameters.addValue("dateDebut", emprunt.getDateDebut());
        namedparameters.addValue("dateFin", emprunt.getDateFin());
        namedparameters.addValue("membre_id", emprunt.getMembre().getId());
        namedparameters.addValue("jeu_id", emprunt.getJeu().getId());
        var keyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(INSERT, namedparameters, keyHolder);
        return keyHolder.getKey().intValue();
    }

    @Override
    public List<Emprunt> read() {
        return jdbcTemplate.query(SELECT_ALL, BeanPropertyRowMapper.newInstance(Emprunt.class));
    }

    @Override
    public Emprunt read(int id) {
        return jdbcTemplate.queryForObject(SELECT_BY_ID, BeanPropertyRowMapper.newInstance(Emprunt.class), id);
    }

    @Override
    public void update(Emprunt emprunt) {
        jdbcTemplate.update(UPDATE, emprunt.getDateDebut(), emprunt.getDateFin(), emprunt.getMembre().getId(), emprunt.getJeu().getId(),emprunt.getId());
    }

    @Override
    public void delete(Emprunt emprunt) {
        delete(emprunt.getId());
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update(DELETE, id);
    }






}
