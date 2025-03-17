// qr-surprise/backend/src/main/java/com/qrsurprise/model/ImageContent.java
package com.qrsurprise.model;

import jakarta.persistence.Entity;

@Entity
public class ImageContent extends Content {
    private String imageUrl;
    
    // Getters e Setters
    // ...
}
