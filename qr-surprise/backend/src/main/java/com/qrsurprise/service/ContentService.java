package com.qrsurprise.service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.UUID;

@Service
public class ContentService {
    private final String bucketName;
    private final Bucket bucket; // Adicione esta linha


    public ContentService(@Value("${firebase.storage.bucket-name}") String bucketName) throws IOException {
        GoogleCredentials credentials = GoogleCredentials.fromStream(
            getClass().getResourceAsStream("/firebase-service-account.json")
        );
        Storage storage = StorageOptions.newBuilder().setCredentials(credentials).build().getService();
        this.bucket = storage.get(bucketName);
    }

    public String uploadFile(MultipartFile file) throws IOException {
        GoogleCredentials credentials = GoogleCredentials.getApplicationDefault();
        Storage storage = StorageOptions.newBuilder().setCredentials(credentials).build().getService();
        Bucket bucket = storage.get(bucketName);

        String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();
        Blob blob = bucket.create(fileName, file.getBytes(), file.getContentType());

        return String.format("https://storage.googleapis.com/%s/%s", bucketName, fileName);
    }
}