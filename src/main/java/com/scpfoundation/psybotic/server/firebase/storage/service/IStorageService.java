package com.scpfoundation.psybotic.server.firebase.storage.service;

import com.scpfoundation.psybotic.server.custom.GeneralResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface IStorageService {
    ResponseEntity<GeneralResponse> upload(MultipartFile file);
}
