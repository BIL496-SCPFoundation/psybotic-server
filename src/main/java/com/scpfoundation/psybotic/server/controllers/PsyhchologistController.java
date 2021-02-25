package com.scpfoundation.psybotic.server.controllers;

import com.scpfoundation.psybotic.server.custom.GeneralResponse;
import com.scpfoundation.psybotic.server.models.Psyhchologist;
import com.scpfoundation.psybotic.server.serviceInterfaces.IPsyhchologistService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/psyhchologists")
public class PsyhchologistController {

    private final IPsyhchologistService psyhchologistService;

    public PsyhchologistController(IPsyhchologistService psyhchologistService) {this.psyhchologistService=psyhchologistService}


    @PostMapping("/insert")
    public GeneralResponse insert(@RequestBody Psyhchologist psyhchologist) {
        return psyhchologistService.insert(psyhchologist);
    }

    @GetMapping("/findById")
    public Psyhchologist findById(@RequestParam("id") String id) {
        return psyhchologistService.findById(id);
    }
}
