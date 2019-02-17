package ru.itpark.reportweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itpark.reportweb.domain.Incident;
import ru.itpark.reportweb.service.IncidentsService;

@Controller
@RequestMapping("/incidents")
public class IncidentsController {
    private final IncidentsService incidentsService;

    public IncidentsController(IncidentsService incidentsService) {
        this.incidentsService = incidentsService;
    }

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("incidents",incidentsService.findAll());
        return "incidents";
    }

    @GetMapping ("/{id}")
    public String get(@PathVariable int id, Model model) {
        model.addAttribute("incident", incidentsService.findById(id));
        return "incident";
    }

    @PostMapping("/{id}/remove")
    public String remove (@PathVariable int id) {
        incidentsService.removeById(id);
        return "redirect:/incidents";
    }

    @GetMapping ("/getClient")
    public String getClient(@PathVariable int clientId, Model model) {
        model.addAttribute("incidents", incidentsService.findClient(clientId));
        return "incidents";
    }
}
