package ru.itpark.reportweb.repository;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.itpark.reportweb.domain.Incident;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Repository
public class IncidentsRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public IncidentsRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Incident> findAll() {
        return jdbcTemplate.query(
                "SELECT id, name, content FROM incidents",
                (rs, i) -> new Incident(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("content")
                )
        );
    }

    public Incident findById(int id) {
        return jdbcTemplate.queryForObject(
                "SELECT id, name, content FROM incidents WHERE id = :id",
                Map.of("id", id),
                (rs, i) -> new Incident(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("content")
                )
        );
    }
}
