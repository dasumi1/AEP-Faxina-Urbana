package br.edu.unicesumar.faxina_urbana.aep.repository;

import br.edu.unicesumar.faxina_urbana.aep.model.LocalColeta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocalColetaRepository extends JpaRepository<LocalColeta, Long> {
    List<LocalColeta> findByBairroContainingIgnoreCase(String bairro);
}