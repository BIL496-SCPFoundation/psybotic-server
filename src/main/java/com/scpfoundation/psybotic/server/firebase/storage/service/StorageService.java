package com.scpfoundation.psybotic.server.firebase.storage.service;

import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.scpfoundation.psybotic.server.custom.GeneralResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class StorageService implements IStorageService{

    private final String BUCKET_NAME = "psybotic.appspot.com";
    private final Storage storage;

    public StorageService(Storage storage) {
        this.storage = storage;
    }

    @Override
    public ResponseEntity<GeneralResponse> upload(MultipartFile file, String fileName) {
        GeneralResponse res = new GeneralResponse();
        try {
            if (file != null && !file.isEmpty()) {
                BlobId blobId = BlobId.of(BUCKET_NAME, fileName);
                BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType("application/pdf").build();
                storage.create(blobInfo, file.getBytes());
                res.setMessage("Successfully uploaded file to Firebase Storage");
                res.setStatus(HttpStatus.OK.value());
            } else {
                res.setMessage("Uploading not successful");
                res.setWarning("Please provide a file to upload in form-data with parameter key 'file'");
                res.setStatus(HttpStatus.BAD_REQUEST.value());
            }
        } catch (Exception e) {
            res.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            res.setMessage("Could not upload file to Firebase");
            res.setError(e.getMessage());
        }
        HttpStatus status = HttpStatus.resolve(res.getStatus());
        if (status != null) {
            return new ResponseEntity<>(res, status);
        } else {
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
