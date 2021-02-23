package com.scpfoundation.psybotic.server.controllers;

import com.scpfoundation.psybotic.server.custom.GeneralResponse;
import com.scpfoundation.psybotic.server.models.Disaster;

import com.scpfoundation.psybotic.server.serviceInterfaces.IDisasterService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/disasters")
public class DisasterController {

    private final IDisasterService disasterService;

    public DisasterController(IDisasterService disasterService){this.disasterService=disasterService;}


    @PostMapping("/insert")
    public GeneralResponse insert(@RequestBody Disaster disaster) {
        return disasterService.insert(disaster);
    }

    @GetMapping("/findById")
    public Disaster findById(@RequestParam("id") String id) {
        return disasterService.findById(id);
    }


    p
}
