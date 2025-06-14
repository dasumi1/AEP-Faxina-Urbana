package br.edu.unicesumar.faxina_urbana.aep.controller;

import br.edu.unicesumar.faxina_urbana.aep.model.LocalColeta;
import br.edu.unicesumar.faxina_urbana.aep.service.LocalColetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/locais")
public class LocalColetaController {
    private final LocalColetaService localColetaService;

    @Autowired
    public LocalColetaController(LocalColetaService localColetaService) {
        this.localColetaService = localColetaService;
    }

    @GetMapping
    public String listarLocais(Model model, @RequestParam(required = false) String bairro) {
        List<LocalColeta> locais;
        if (bairro != null && !bairro.isEmpty()) {
            locais = localColetaService.buscarPorBairro(bairro);
            model.addAttribute("bairroPesquisado", bairro);
        } else {
            locais = localColetaService.listarTodosLocais();
        }
        model.addAttribute("locais", locais);
        return "locais";
    }
}