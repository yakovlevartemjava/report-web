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
                "SELECT id, clientId, data, starttimehh, starttimemm, finishtimehh, finishtimemm, duration, description, subject, transactions FROM incidents ORDER BY id DESC",
                (rs, i) -> new Incident(
                        rs.getInt("id"),
                        rs.getInt("clientId"),
                        rs.getString("data"),
                        rs.getInt("starttimehh"),
                        rs.getInt("starttimemm"),
                        rs.getInt("finishtimehh"),
                        rs.getInt("finishtimemm"),
                        rs.getInt("duration"),
                        rs.getString("description"),
                        rs.getString("subject"),
                        rs.getInt("transactions")
                )
        );
    }

    public Incident findById(int id) {
        return jdbcTemplate.queryForObject(
                "SELECT id, clientId, data, starttimehh, starttimemm, finishtimehh, finishtimemm, duration, description, subject, transactions FROM incidents WHERE id = :id ORDER BY id DESC",
                Map.of("id", id),
                (rs, i) -> new Incident(
                        rs.getInt("id"),
                        rs.getInt("clientId"),
                        rs.getString("data"),
                        rs.getInt("starttimehh"),
                        rs.getInt("starttimemm"),
                        rs.getInt("finishtimehh"),
                        rs.getInt("finishtimemm"),
                        rs.getInt("duration"),
                        rs.getString("description"),
                        rs.getString("subject"),
                        rs.getInt("transactions")
                )
        );
    }

    public void removeById(int id) {
        jdbcTemplate.update(
                "DELETE FROM incidents WHERE id = :id",
                Map.of("id", id)
        );
    }

    public Incident findClient(int clientId) {
        return jdbcTemplate.queryForObject(
                "SELECT id, clientId, data, starttimehh, starttimemm, finishtimehh, finishtimemm, duration, description, subject, transactions FROM incidents WHERE clientId = :clientId",
                Map.of("clientId", clientId),
                (rs, i) -> new Incident(
                        rs.getInt("id"),
                        rs.getInt("clientId"),
                        rs.getString("data"),
                        rs.getInt("starttimehh"),
                        rs.getInt("starttimemm"),
                        rs.getInt("finishtimehh"),
                        rs.getInt("finishtimemm"),
                        rs.getInt("duration"),
                        rs.getString("description"),
                        rs.getString("subject"),
                        rs.getInt("transactions")
                )
        );
    }
}

