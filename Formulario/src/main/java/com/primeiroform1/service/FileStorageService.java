package com.primeiroform1.service;

import com.primeiroform1.model.Mensagem;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class FileStorageService {

    private static final String TXT_FILE_PATH = "dados/txt/dados_formulario.txt";
    private static final String CSV_FILE_PATH = "dados/csv/dados_formulario.csv";

    public void salvarEmArquivo(Mensagem mensagem) throws IOException {
        // Cria os diretórios se não existirem
        Files.createDirectories(Paths.get("dados/txt"));
        Files.createDirectories(Paths.get("dados/csv"));

        salvarEmTxt(mensagem);
        salvarEmCsv(mensagem);
    }

    private void salvarEmTxt(Mensagem mensagem) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(TXT_FILE_PATH, true))) {
            String dataHora = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
            writer.write(String.format(
                "[%s] Nome: %s | Email: %s | Mensagem: %s\n",
                dataHora,
                mensagem.getNome(),
                mensagem.getEmail(),
                mensagem.getMensagem()
            ));
        }
    }

    private void salvarEmCsv(Mensagem mensagem) throws IOException {
        File csvFile = new File(CSV_FILE_PATH);
        boolean arquivoExiste = csvFile.exists();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CSV_FILE_PATH, true))) {
            if (!arquivoExiste) {
                writer.write("DataHora,Nome,Email,Mensagem\n");
            }

            String dataHora = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
            writer.write(String.format(
                "%s,%s,%s,\"%s\"\n", // Use aspas para mensagens com vírgulas
                dataHora,
                mensagem.getNome(),
                mensagem.getEmail(),
                mensagem.getMensagem().replace("\"", "\"\"") // Escapa aspas no CSV
            ));
        }
    }
}