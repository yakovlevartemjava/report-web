package ru.itpark.reportweb.service;

import org.springframework.stereotype.Service;
import ru.itpark.reportweb.domain.Client;
import ru.itpark.reportweb.domain.Incident;
import ru.itpark.reportweb.repository.ClientsRepository;
import java.util.List;

@Service
public class ClientsService {
    private final ClientsRepository clientsRepository;

    public ClientsService(ClientsRepository clientsRepository) {
        this.clientsRepository = clientsRepository;
    }

    public List<Client> findAllClient() {
        return clientsRepository.findAllClient();
    }

    public void addclient(Client client) {
        clientsRepository.addclient(client);
    }

    public void removeByClientId(int clientId) {
        clientsRepository.removeByClientId(clientId);
    }

    public List<Incident> findByClientId(int clientId) {
        return clientsRepository.findByClientId(clientId);
    }

    public void addincident(Incident id) {
        clientsRepository.addincident(id);
    }

    public void removeIncidentById(int id) {
        clientsRepository.removeIncidentById(id);
    }
}
