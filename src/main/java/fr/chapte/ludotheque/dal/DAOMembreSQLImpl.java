package fr.chapte.ludotheque.dal;

import fr.chapte.ludotheque.bo.Membre;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DAOMembreSQLImpl implements DAOMembre {


    static final String SELECT_ALL = "select * from Membre";
    static final String SELECT_BY_ID = "select * from Membre where id=?";
    static final String INSERT = "INSERT  INTO Membre ([nom],[prenom],[telephone],[dateAdhesion]) VALUES (:nom,:prenom,:telephone,:dateAdhesion)";
    static final String DELETE = "DELETE FROM Membre where id=?";
    static final String UPDATE = "UPDATE Membre set nom=?,prenom=?,telephone=?,dateAdhesion=? where id=?";

    JdbcTemplate jdbcTemplate;
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public DAOMembreSQLImpl(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public int create(Membre membre) {
        var namedparameters = new MapSqlParameterSource();
        namedparameters.addValue("nom", membre.getNom());
        namedparameters.addValue("prenom", membre.getPrenom());
        namedparameters.addValue("telephone", membre.getTelephone());
        namedparameters.addValue("dateAdhesion", membre.getDateAdhesion());
        var keyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(INSERT, namedparameters, keyHolder);
        return keyHolder.getKey().intValue();
    }

    @Override
    public List<Membre> read() {
        return jdbcTemplate.query(SELECT_ALL, BeanPropertyRowMapper.newInstance(Membre.class));
    }

    @Override
    public Membre read(int id) {
        return jdbcTemplate.queryForObject(SELECT_BY_ID, BeanPropertyRowMapper.newInstance(Membre.class), id);
    }

    @Override
    public void update(Membre membre) {
        jdbcTemplate.update(UPDATE, membre.getNom(), membre.getPrenom(), membre.getTelephone(), membre.getDateAdhesion(),membre.getId());
    }

    @Override
    public void delete(Membre membre) {
        delete(membre.getId());
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update(DELETE, id);
    }

}
