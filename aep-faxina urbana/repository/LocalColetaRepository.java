package br.edu.unicesumar.faxina_urbana.aep.repository;

import br.edu.unicesumar.faxina_urbana.aep.model.LocalColeta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocalColetaRepository extends JpaRepository<LocalColeta, Long> {
    List<LocalColeta> findByMaterialContainingIgnoreCase(String material);

    @Query("SELECT DISTINCT l.material FROM LocalColeta l")
    List<String> findDistinctMaterials();
}