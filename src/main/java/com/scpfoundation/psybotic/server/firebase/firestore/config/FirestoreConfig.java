package com.scpfoundation.psybotic.server.firebase.firestore.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Configuration
public class FirestoreConfig {


    @Value("classpath:${app.firebase-configuration-file}")
    Resource resourceFile;


    @Bean
    public Firestore getFirestore(@Value("${app.firebase-configuration-file}") String credentialPath) throws IOException {
        FileInputStream serviceAccount = new FileInputStream(resourceFile.getFile());
        GoogleCredentials credentials = GoogleCredentials.fromStream(serviceAccount);

        FirestoreOptions options = FirestoreOptions.newBuilder()
                .setCredentials(credentials).build();

        return options.getService();
    }

}
