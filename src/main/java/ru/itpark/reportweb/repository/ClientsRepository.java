package ru.itpark.reportweb.repository;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.itpark.reportweb.domain.Client;
import ru.itpark.reportweb.domain.Incident;

import java.util.List;
import java.util.Map;

@Repository
public class ClientsRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public ClientsRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

     public void addclient(Client client) {
        jdbcTemplate.update(
                "INSERT INTO clients(clientId,clientName) VALUES (:clientId, :clientName)",
                Map.of ("clientId",client.getClientId(),"clientName",client.getClientName())
        );
    }

    public List<Client> findAllClient() {
        return jdbcTemplate.query(
                "SELECT clientId, clientName FROM clients ORDER BY clientId ASC",
                (rs, i) -> new Client(
                        rs.getInt("clientId"),
                        rs.getString("clientName"))
                );
    }

    public void removeByClientId(int clientId) {
        jdbcTemplate.update(
                "DELETE  FROM clients WHERE clientId = :clientId",
                Map.of("clientId",clientId));
        jdbcTemplate.update(
                "DELETE  FROM incidents WHERE clientId = :clientId",
                 Map.of("clientId",clientId)
        );
    }

    public List<Incident> findByClientId(int clientId) {
        return jdbcTemplate.query(
                "SELECT * FROM incidents WHERE clientId = :clientId ORDER BY id DESC",
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

    public void addincident(Incident incident) {
        jdbcTemplate.update(
                "INSERT INTO incidents(clientId,data,starttimehh,starttimemm,finishtimehh,finishtimemm,duration,description,subject,transactions) VALUES (:clientId,:data,:starttimehh,:starttimemm,:finishtimehh,:finishtimemm,:duration,:description,:subject,:transactions)",
                Map.of ("clientId", incident.getClientId(),
                        "data", incident.getData(),
                        "starttimehh",incident.getStartTimeHH(),
                        "starttimemm",incident.getStartTimeMM(),
                        "finishtimehh",incident.getFinishTimeHH(),
                        "finishtimemm",incident.getFinishTimeMM(),
                        "duration",incident.getDuration(),
                        "description",incident.getDescription(),
                        "subject",incident.getSubject(),
                        "transactions",incident.getTransactions()
                        )
        );
    }

    public void removeIncidentById(int id) {
        jdbcTemplate.update(
                "DELETE  FROM incidents WHERE id = :id",
                Map.of("id",id)
        );
    }
}
