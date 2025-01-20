package fr.chapte.ludotheque.dal;

import fr.chapte.ludotheque.bo.JeuSociete;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DAOJeuSocieteSQLImpl implements DAOJeuSociete {

    static final String SELECT_ALL = "select * from JeuSociete";
    static final String SELECT_BY_ID = "select * from JeuSociete where id=?";
    static final String INSERT = "BEGIN TRANSACTION;" +
                                 "INSERT  INTO Jeu ([titre],[etat],[age],[description],[type]) VALUES (:titre,:etat,:age,:description,:type);" +
                                 "DECLARE @jeu_id INT;" +
                                 "SET @jeu_id = SCOPE_IDENTITY();" +
                                 "INSERT  INTO JeuSociete ([id],[difficulte],[interet]) VALUES (@jeu_id,:difficulte,:interet);COMMIT;";
    static final String DELETE = "DELETE FROM JeuSociete where id=?";
    static final String UPDATE = "UPDATE JeuSociete set titre=?,etat=?,age=?,description=?,difficulte=?,interet=? where id=?";

    JdbcTemplate jdbcTemplate;
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public DAOJeuSocieteSQLImpl(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public int create(JeuSociete jeuSociete) {
        var namedparameters = new MapSqlParameterSource();
        namedparameters.addValue("titre", jeuSociete.getTitre());
        namedparameters.addValue("etat", jeuSociete.getEtat().name());
        namedparameters.addValue("age", jeuSociete.getAge());
        namedparameters.addValue("type", jeuSociete.getClass().getSimpleName());
        namedparameters.addValue("description", jeuSociete.getDescription());
        namedparameters.addValue("difficulte", jeuSociete.getDifficulte());
        namedparameters.addValue("interet", jeuSociete.getInteret());
        var keyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(INSERT, namedparameters, keyHolder);
        return keyHolder.getKey().intValue();
    }

    @Override
    public List<JeuSociete> read() {
        return jdbcTemplate.query(SELECT_ALL, BeanPropertyRowMapper.newInstance(JeuSociete.class));
    }

    @Override
    public JeuSociete read(int id) {
        return jdbcTemplate.queryForObject(SELECT_BY_ID, BeanPropertyRowMapper.newInstance(JeuSociete.class), id);
    }

    @Override
    public void update(JeuSociete jeuSociete) {
        jdbcTemplate.update(UPDATE, jeuSociete.getTitre(), jeuSociete.getEtat(), jeuSociete.getAge(), jeuSociete.getDescription(), jeuSociete.getDifficulte(), jeuSociete.getInteret(),jeuSociete.getId());
    }

    @Override
    public void delete(JeuSociete jeuSociete) {
        delete(jeuSociete.getId());
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update(DELETE, id);
    }


}
