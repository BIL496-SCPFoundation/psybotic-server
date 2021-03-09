package com.scpfoundation.psybotic.server.firebase.firestore.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import java.io.IOException;

@Configuration
public class FirestoreConfig {


    @Value("${app.firebase-configuration-file}")
    String firebaseConfigPath;


    @Bean
    public Firestore getFirestore() throws IOException {
        GoogleCredentials credentials = GoogleCredentials
                .fromStream(new ClassPathResource(firebaseConfigPath).getInputStream());

        FirestoreOptions options = FirestoreOptions.newBuilder()
                .setCredentials(credentials).build();

        return options.getService();
    }

}
