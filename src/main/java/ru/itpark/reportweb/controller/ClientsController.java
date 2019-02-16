package ru.itpark.reportweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itpark.reportweb.domain.Client;
import ru.itpark.reportweb.service.ClientsService;



@Controller
@RequestMapping("/clients")
public class ClientsController {
    private final ClientsService clientsService;

    public ClientsController(ClientsService clientsService) {
        this.clientsService = clientsService;
    }

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("clients", clientsService.findAllClient());
        return "clients";
    }

    @GetMapping("/addclient")
    public String addForm() {
        return "client-add";
    }

    @PostMapping("/addclient")
    public String add(@ModelAttribute Client client) {
        clientsService.addclient(client);
        return "redirect:/clients";
    }

    @GetMapping ("/{clientId}")
    public String get(@PathVariable int clientId, Model model) {
        model.addAttribute("client", clientsService.findByClientId(clientId));
        return "client";
    }
}