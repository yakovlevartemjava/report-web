package ru.itpark.reportweb.service;

import org.springframework.stereotype.Service;
import ru.itpark.reportweb.domain.Incident;
import ru.itpark.reportweb.repository.IncidentsRepository;

import java.util.List;

@Service
public class IncidentsService {
    private final IncidentsRepository incidentsRepository;

    public IncidentsService(IncidentsRepository incidentsRepository) {
        this.incidentsRepository = incidentsRepository;
    }

    public List<Incident> findAll() {
        return incidentsRepository.findAll ();
    }

    public Incident findById(int id) {
        return incidentsRepository.findById(id);
    }

    public void removeById(int id) {
        incidentsRepository.removeById(id);
    }

    public Incident findClient(int clientId) {
        return incidentsRepository.findClient(clientId);
    }
}
