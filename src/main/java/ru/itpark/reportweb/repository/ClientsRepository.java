package ru.itpark.reportweb.repository;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.itpark.reportweb.domain.Client;
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
                "SELECT clientId, clientName FROM clients",
                (rs, i) -> new Client(
                        rs.getInt("clientId"),
                        rs.getString("clientName"))
                );
    }

    public Client findByClientId(int clientId) {
        return jdbcTemplate.queryForObject(
                "SELECT clientId, clientName FROM clients WHERE clientId = :clientId",
                Map.of("clientId", clientId),
                (resultSet, i) -> new Client(
                        resultSet.getInt("clientId"),
                        resultSet.getString("clientName")
                )
        );
    }
}
