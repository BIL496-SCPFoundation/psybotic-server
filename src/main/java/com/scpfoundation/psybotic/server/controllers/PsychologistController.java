package com.scpfoundation.psybotic.server.controllers;

import com.scpfoundation.psybotic.server.custom.GeneralResponse;
import com.scpfoundation.psybotic.server.models.Psychologist;
import com.scpfoundation.psybotic.server.serviceInterfaces.IPsychologistService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/psyhchologists")
public class PsychologistController {

    private final IPsychologistService psychologistService;

    public PsychologistController(IPsychologistService psychologistService) {this.psychologistService = psychologistService;}


    @PostMapping("/insert")
    public GeneralResponse insert(@RequestBody Psychologist psychologist) {
        return psychologistService.insert(psychologist);
    }

    @GetMapping("/findById")
    public Psychologist findById(@RequestParam("id") String id) {
        return psychologistService.findById(id);
    }
}
