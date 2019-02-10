package ru.itpark.reportweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/incidents")
public class IncidentsController {

    @GetMapping
    public String getAll(){
        return "incidents";
    }
}
