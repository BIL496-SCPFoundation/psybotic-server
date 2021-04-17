package com.scpfoundation.psybotic.server.controllers;

import com.scpfoundation.psybotic.server.custom.GeneralResponse;
import com.scpfoundation.psybotic.server.models.BasicModel;
import com.scpfoundation.psybotic.server.models.ChatMessage;
import com.scpfoundation.psybotic.server.serviceInterfaces.ICRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

public class CRUDController<S extends ICRUDService<E, String>, E extends BasicModel<String>>{
    @Autowired
    private S service;

    @PostMapping("/insert")
    public ResponseEntity<GeneralResponse> insert(@Valid @RequestBody E entity) {
        return service.insert(entity);
    }

    @GetMapping("/findById")
    public E findById(@RequestParam("id") String id) {
        return service.findById(id);
    }

    @PostMapping("/update")
    public ResponseEntity<GeneralResponse> update(@Valid @RequestBody E entity) {
        return service.update(entity);
    }

    @DeleteMapping("/deleteById")
    public ResponseEntity<GeneralResponse> deleteById(@RequestParam("id") String id) {
        return service.deleteById(id);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<GeneralResponse> delete(@RequestBody E entity) {
        return service.delete(entity);
    }
}
