// qr-surprise/backend/src/main/java/com/qrsurprise/repository/ContentRepository.java
package com.qrsurprise.repository;

import com.qrsurprise.model.Content;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContentRepository extends JpaRepository<Content, Long> {
    // Métodos customizados, se necessário
}
