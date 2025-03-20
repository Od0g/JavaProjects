package com.primeiroform1;

import com.primeiroform1.model.Mensagem;
import com.primeiroform1.repository.MensagemRepository;
import com.primeiroform1.service.FileStorageService;
import jakarta.validation.Valid;
import java.io.IOException; // Import adicionado
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FormController {

    private final MensagemRepository mensagemRepository;
    private final FileStorageService fileStorageService;

    // Construtor corrigido (único)
    public FormController(
        MensagemRepository mensagemRepository,
        FileStorageService fileStorageService
    ) {
        this.mensagemRepository = mensagemRepository;
        this.fileStorageService = fileStorageService;
    }

    @GetMapping("/")
    public String mostrarFormulario(Model model) {
        model.addAttribute("mensagem", new Mensagem());
        return "form";
    }

    @PostMapping("/submit")
    public String processarFormulario(
        @Valid Mensagem mensagem,
        BindingResult result,
        Model model
    ) throws IOException { // Método único
        if (result.hasErrors()) {
            return "form";
        }

        mensagemRepository.save(mensagem);
        fileStorageService.salvarEmArquivo(mensagem); // Salva em arquivos

        model.addAttribute("mensagem", mensagem);
        return "resultado";
    }
}