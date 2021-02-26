package com.scpfoundation.psybotic.server.controllers;

import com.scpfoundation.psybotic.server.custom.GeneralResponse;
import com.scpfoundation.psybotic.server.models.Disaster;

import com.scpfoundation.psybotic.server.serviceInterfaces.IDisasterService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/disasters")
public class DisasterController {

    private final IDisasterService disasterService;

    public DisasterController(IDisasterService disasterService) {
        this.disasterService = disasterService;
    }


    @PostMapping("/insert")
    public ResponseEntity<GeneralResponse> insert(@RequestBody Disaster disaster) {
        return disasterService.insert(disaster);
    }

    @GetMapping("/findById")
    public Disaster findById(@RequestParam("id") String id) {
        return disasterService.findById(id);
    }

    @PostMapping("/update")
    public ResponseEntity<GeneralResponse> update(@RequestBody Disaster disaster) {
        return disasterService.update(disaster);
    }

    @DeleteMapping("/deleteById")
    public ResponseEntity<GeneralResponse> deleteById(@RequestParam("id") String id) {
        return disasterService.deleteById(id);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<GeneralResponse> deleteById(@RequestBody Disaster disaster) {
        return disasterService.delete(disaster);
    }

}
