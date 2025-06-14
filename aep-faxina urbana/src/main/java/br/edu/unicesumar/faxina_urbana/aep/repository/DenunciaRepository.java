package br.edu.unicesumar.faxina_urbana.aep.repository;

import br.edu.unicesumar.faxina_urbana.aep.model.Denuncia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DenunciaRepository extends JpaRepository<Denuncia, Long> {
    List<Denuncia> findByAtendida(boolean atendida);
}