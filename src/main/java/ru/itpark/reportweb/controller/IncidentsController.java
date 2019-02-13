package ru.itpark.reportweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
