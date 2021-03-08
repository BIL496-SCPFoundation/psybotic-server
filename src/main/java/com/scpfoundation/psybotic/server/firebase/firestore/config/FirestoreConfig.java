package com.scpfoundation.psybotic.server.firebase.firestore.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreOptions;
import jdk.incubator.jpackage.internal.Log;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@Configuration
public class FirestoreConfig {


    @Value("${app.firebase-configuration-file}")
    String configPath;


    @Bean
    public Firestore getFirestore(@Value("${app.firebase-configuration-file}") String credentialPath) throws IOException {
        InputStream in = ClassLoader.getSystemResourceAsStream(configPath);
        GoogleCredentials credentials = GoogleCredentials.fromStream(in);
        Log.info("Deneme");

        FirestoreOptions options = FirestoreOptions.newBuilder()
                .setCredentials(credentials).build();

        return options.getService();
    }

}
