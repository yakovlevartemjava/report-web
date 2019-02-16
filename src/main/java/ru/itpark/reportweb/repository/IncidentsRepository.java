package ru.itpark.reportweb.repository;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.itpark.reportweb.domain.Incident;

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
                "SELECT id, clientId, data, starttimehh, stattimess, finishtimehh, finishtimess, duration, description, subject, transactions, type, component FROM incidents",
                (rs, i) -> new Incident(
                        rs.getInt("id"),
                        rs.getInt("clientId"),
                        rs.getString("data"),
                        rs.getInt("starttimehh"),
                        rs.getInt("stattimess"),
                        rs.getInt("finishtimehh"),
                        rs.getInt("finishtimess"),
                        rs.getInt("duration"),
                        rs.getString("description"),
                        rs.getString("subject"),
                        rs.getInt("transactions"),
                        rs.getString("type"),
                        rs.getString("component")
                )
        );
    }

    public Incident findById(int id) {
        return jdbcTemplate.queryForObject(
                "SELECT id, clientId, data, starttimehh, stattimess, finishtimehh, finishtimess, duration, description, subject, transactions, type, component FROM incidents WHERE id = :id",
                Map.of("id", id),
                (rs, i) -> new Incident(
                        rs.getInt("id"),
                        rs.getInt("clientId"),
                        rs.getString("data"),
                        rs.getInt("starttimehh"),
                        rs.getInt("stattimess"),
                        rs.getInt("finishtimehh"),
                        rs.getInt("finishtimess"),
                        rs.getInt("duration"),
                        rs.getString("description"),
                        rs.getString("subject"),
                        rs.getInt("transactions"),
                        rs.getString("type"),
                        rs.getString("component")
                )
        );
    }

    public void removeById(int id) {
        jdbcTemplate.update(
                "DELETE FROM incidents WHERE id = :id",
                Map.of("id", id)
        );
    }

    public void add(Incident incident) {
        jdbcTemplate.update(
                "INSERT INTO incidents (id,data) VALUES (:id, :data)",
                Map.of("name", incident.getId(), "content", incident.getData())
        );
    }
}

