// qr-surprise/backend/src/main/java/com/qrsurprise/service/QrCodeService.java
package com.qrsurprise.service;

import org.springframework.stereotype.Service;

@Service
public class QrCodeService {
    // Métodos para gerar e gerenciar QR Codes
    public String generateQrCode(String data) {
        // Aqui você integraria com a biblioteca ZXing para gerar o QR Code
        return "QRCodeBase64Dummy";
    }
}
