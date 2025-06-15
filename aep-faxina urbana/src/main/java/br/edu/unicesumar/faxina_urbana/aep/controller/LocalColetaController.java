package br.edu.unicesumar.faxina_urbana.aep.controller;

import br.edu.unicesumar.faxina_urbana.aep.model.LocalColeta;
import br.edu.unicesumar.faxina_urbana.aep.service.LocalColetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/locais")
public class LocalColetaController {
    @Autowired
    private LocalColetaService service;

    @GetMapping
    public String listarLocais(Model model, @RequestParam(required = false) String material) {
        List<LocalColeta> locais;
        if (material != null && !material.isEmpty()) {
            locais = service.buscarPorMaterial(material);
        } else {
            locais = service.listarTodos();
        }

        List<String> materiaisUnicos = service.listarMateriaisUnicos();

        model.addAttribute("locais", locais);
        model.addAttribute("materiaisUnicos", materiaisUnicos);
        return "locais";
    }
}