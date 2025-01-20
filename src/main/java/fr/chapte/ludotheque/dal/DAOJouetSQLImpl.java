package fr.chapte.ludotheque.dal;

import fr.chapte.ludotheque.bo.Jouet;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DAOJouetSQLImpl implements DAOJouet {

    static final String SELECT_ALL = "select * from Jouet";
    static final String SELECT_BY_ID = "select * from Jouet where id=?";
    static final String INSERT = "INSERT  INTO Jouet ([titre],[etat],[age],[description],[typeJouet_id]) VALUES (:titre,:etat,:age,:description,:typeJouet_id)";
    static final String DELETE = "DELETE FROM Jouet where id=?";
    static final String UPDATE = "UPDATE Jouet set titre=?,etat=?,age=?,description=?,typeJouet_id=? where id=?";

    JdbcTemplate jdbcTemplate;
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public DAOJouetSQLImpl(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public int create(Jouet jouet) {
        var namedparameters = new MapSqlParameterSource();
        namedparameters.addValue("titre", jouet.getTitre());
        namedparameters.addValue("etat", jouet.getEtat());
        namedparameters.addValue("age", jouet.getAge());
        namedparameters.addValue("description", jouet.getDescription());
        namedparameters.addValue("typeJouet_id", jouet.getTypeJouet().getId());
        var keyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(INSERT, namedparameters, keyHolder);
        return keyHolder.getKey().intValue();
    }

    @Override
    public List<Jouet> read() {
        return jdbcTemplate.query(SELECT_ALL, BeanPropertyRowMapper.newInstance(Jouet.class));
    }

    @Override
    public Jouet read(int id) {
        return jdbcTemplate.queryForObject(SELECT_BY_ID, BeanPropertyRowMapper.newInstance(Jouet.class), id);
    }

    @Override
    public void update(Jouet jouet) {
        jdbcTemplate.update(UPDATE, jouet.getTitre(), jouet.getEtat(), jouet.getAge(), jouet.getDescription(), jouet.getTypeJouet().getId(), jouet.getId());
    }

    @Override
    public void delete(Jouet jouet) {
        delete(jouet.getId());
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update(DELETE, id);
    }


}
