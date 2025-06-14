package br.edu.unicesumar.faxina_urbana.aep.controller;

import br.edu.unicesumar.faxina_urbana.aep.model.Denuncia;
import br.edu.unicesumar.faxina_urbana.aep.service.DenunciaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/denuncias")
public class DenunciaController {
    private final DenunciaService denunciaService;

    @Autowired
    public DenunciaController(DenunciaService denunciaService) {
        this.denunciaService = denunciaService;
    }

    @GetMapping("/formulario")
    public String mostrarFormulario(Model model) {
        if (!model.containsAttribute("denuncia")) {
            model.addAttribute("denuncia", new Denuncia());
        }
        return "formulario";
    }

    @PostMapping("/enviar")
    public String enviarDenuncia(@Valid @ModelAttribute("denuncia") Denuncia denuncia,
                                 BindingResult result,
                                 @RequestParam("imagem") MultipartFile imagem,
                                 RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.denuncia", result);
            redirectAttributes.addFlashAttribute("denuncia", denuncia);
            return "redirect:/denuncias/formulario";
        }

        try {
            denunciaService.salvarDenuncia(denuncia, imagem);
            redirectAttributes.addFlashAttribute("sucesso", "Denúncia enviada com sucesso!");
        } catch (IllegalArgumentException e) {
            redirectAttributes.addFlashAttribute("erro", e.getMessage());
            redirectAttributes.addFlashAttribute("denuncia", denuncia);
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("erro", "Erro ao enviar a denúncia. Por favor, tente novamente.");
            redirectAttributes.addFlashAttribute("denuncia", denuncia);
        }

        return "redirect:/denuncias/formulario";
    }
}