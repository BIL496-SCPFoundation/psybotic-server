package com.scpfoundation.psybotic.server.controllers;

import com.scpfoundation.psybotic.server.custom.GeneralResponse;
import com.scpfoundation.psybotic.server.models.MentalState;
import com.scpfoundation.psybotic.server.models.Psychologist;
import com.scpfoundation.psybotic.server.serviceInterfaces.IPsychologistService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/psychologists")
@CrossOrigin("*")
public class PsychologistController {

    private final IPsychologistService psychologistService;

    public PsychologistController(IPsychologistService psychologistService) {this.psychologistService = psychologistService;}


    @PostMapping("/insert")
    public ResponseEntity<GeneralResponse> insert(@RequestBody Psychologist psychologist) {
        return psychologistService.insert(psychologist);
    }

    @GetMapping("/findById")
    public Psychologist findById(@RequestParam("id") String id) {
        return psychologistService.findById(id);
    }

    @PostMapping("/update")
    public ResponseEntity<GeneralResponse> update(@RequestBody Psychologist psychologist) {
        return psychologistService.update(psychologist);
    }

    @DeleteMapping("/deleteById")
    public ResponseEntity<GeneralResponse> deleteById(@RequestParam("id") String id) {
        return psychologistService.deleteById(id);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<GeneralResponse> deleteById(@RequestBody Psychologist psychologist) {
        return psychologistService.delete(psychologist);
    }
}
