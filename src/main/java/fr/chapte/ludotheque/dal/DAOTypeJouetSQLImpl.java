package fr.chapte.ludotheque.dal;

import fr.chapte.ludotheque.bo.TypeJouet;
import fr.chapte.ludotheque.bo.TypeJouet;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DAOTypeJouetSQLImpl implements DAOTypeJouet {

    static final String SELECT_ALL = "select * from TypeJouet";
    static final String SELECT_BY_ID = "select * from TypeJouet where id=?";
    static final String INSERT = "INSERT  INTO TypeJouet ([libelle]) VALUES (:libelle)";
    static final String DELETE = "DELETE FROM TypeJouet where id=?";
    static final String UPDATE = "UPDATE TypeJouet set libelle=? where id=?";

    JdbcTemplate jdbcTemplate;
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public DAOTypeJouetSQLImpl(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public int create(TypeJouet typeJouet) {
        var namedparameters = new MapSqlParameterSource();
        namedparameters.addValue("libelle", typeJouet.getLibelle());
        var keyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(INSERT, namedparameters, keyHolder);
        return keyHolder.getKey().intValue();
    }

    @Override
    public List<TypeJouet> read() {
        return jdbcTemplate.query(SELECT_ALL, BeanPropertyRowMapper.newInstance(TypeJouet.class));
    }

    @Override
    public TypeJouet read(int id) {
        return jdbcTemplate.queryForObject(SELECT_BY_ID, BeanPropertyRowMapper.newInstance(TypeJouet.class), id);
    }

    @Override
    public void update(TypeJouet typeJouet) {
        jdbcTemplate.update(UPDATE, typeJouet.getLibelle(),typeJouet.getId());
    }

    @Override
    public void delete(TypeJouet typeJouet) {
        delete(typeJouet.getId());
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update(DELETE, id);
    }

}
