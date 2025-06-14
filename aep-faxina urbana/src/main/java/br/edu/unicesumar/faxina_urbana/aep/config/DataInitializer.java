package br.edu.unicesumar.faxina_urbana.aep.config;

import br.edu.unicesumar.faxina_urbana.aep.model.LocalColeta;
import br.edu.unicesumar.faxina_urbana.aep.repository.LocalColetaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner loadData(LocalColetaRepository repository) {
        return args -> {
            if (repository.count() == 0) {
                repository.saveAll(List.of(
                        new LocalColeta("Ecoponto Zona 7", "Av. Mandacaru, 1234", "Zona 7",
                                "Segunda a Sábado, 8h às 18h",
                                "Recicláveis, Eletrônicos, Óleo de Cozinha",
                                "Trazer os materiais separados e limpos"),
                        new LocalColeta("IAM - Instituto Ambiental", "Av. Cerro Azul, 544", "Zona 2",
                                "Segunda a Sexta, 9h às 17h",
                                "Eletrônicos, Pilhas, Baterias",
                                "Entrada pela portaria principal"),
                        new LocalColeta("Supermercado Cidade Canção", "Av. das Palmeiras, 356", "Pq. das Palmeiras",
                                "Todos os dias, 8h às 22h",
                                "Óleo de Cozinha, Lâmpadas",
                                "Caixa específico na entrada")
                ));
            }
        };
    }
}