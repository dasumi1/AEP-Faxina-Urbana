package br.edu.unicesumar.faxina_urbana.aep.service;

import br.edu.unicesumar.faxina_urbana.aep.model.LocalColeta;
import br.edu.unicesumar.faxina_urbana.aep.repository.LocalColetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocalColetaService {
    private final LocalColetaRepository localColetaRepository;

    @Autowired
    public LocalColetaService(LocalColetaRepository localColetaRepository) {
        this.localColetaRepository = localColetaRepository;
    }

    public List<LocalColeta> listarTodosLocais() {
        return localColetaRepository.findAll();
    }

    public List<LocalColeta> buscarPorBairro(String bairro) {
        return localColetaRepository.findByBairroContainingIgnoreCase(bairro);
    }
}