package com.qrsurprise.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class QrCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    
    @ManyToOne
    private User user;
}