package com.scpfoundation.psybotic.server.firebase.storage;

import com.scpfoundation.psybotic.server.custom.GeneralResponse;
import com.scpfoundation.psybotic.server.firebase.storage.service.IStorageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/storage")
@CrossOrigin("*")
public class StorageController {

    private final IStorageService storageService;

    public StorageController(IStorageService storageService) {
        this.storageService = storageService;
    }

    @PostMapping("/upload")
    public ResponseEntity<GeneralResponse> uploadPDF(@RequestParam("file") MultipartFile file,
                                                     @RequestParam("fileName") String fileName) {
        return storageService.upload(file, fileName);
    }
}
