package br.edu.unicesumar.faxina_urbana.aep.service;

import br.edu.unicesumar.faxina_urbana.aep.model.LocalColeta;
import br.edu.unicesumar.faxina_urbana.aep.repository.LocalColetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import org.springframework.context.annotation.Bean;
import java.util.List;
import java.util.Map;

@Service
public class LocalColetaService {
    @Autowired
    private LocalColetaRepository repository;

    public List<LocalColeta> buscarPorMaterial(String material) {
        return repository.findByMaterialContainingIgnoreCase(material);
    }

    public List<LocalColeta> listarTodos() {
        return repository.findAll();
    }

    public List<String> listarMateriaisUnicos() {
        return repository.findDistinctMaterials();
    }

    @Bean
    public CommandLineRunner initLocalColetaData() {
        return args -> {
            if (repository.count() == 0) {
                Map<String, List<String>> locaisPorMaterial = Map.of(
                        "Esponja de cozinha", List.of(
                                "CMEI Zeferino Mosato Krukoski - R. Pioneiro Olindo Alcini, 815. Conj. Hab. Sanenge",
                                "IAM - Instituto Ambiental de Maringá - Av. Cerro Azul, 544. Zona 02",
                                "Secretaria de Limpeza urbana - Av. das Indústrias, 700. Parque Industrial II",
                                "Teatro Calil Haddad. Av. Dr - Luiz Teixeira Mendes, 2500. Zona 05"
                        ),
                        "Óleo de Fritura pós-consumo", List.of(
                                "Supermercado Cidade Canção - Av. das Palmeiras, 356. Pq. das Palmeiras",
                                "Supermercado Cidade Canção - Av. Mandacaru, 2824. Jd Brasil.",
                                "Supermercado Cidade Canção - Av. Arq. Nildo Ribeiro da Rocha, 343. Zona 28",
                                "Supermercado Cidade Canção - Av. Tuiuti, 1672. Zona 37",
                                "Supermercado Cidade Canção - Av. Brasil, 4734. Zona 04"
                        ),
                        "Baterias, Pilhas ou Sucatas Eletrônicas", List.of(
                                "4ª Batalhão de Polícia Militar - Rua Mitsuzu Taguchi, 99. Vila Nova",
                                "Câmara Municipal de Maringá - Av. Papa João XXIII, 239. Zona 02",
                                "Faculdades Maringá - Av. Prudente de Morais, 815. Zona 09",
                                "Paço Municipal Silvio Magalhães Barros - Av. XV de Novembro, 701. Zona 01",
                                "Tiro de Guerra - Av. Mandacaru, 730. Zona 06"
                        ),
                        "Lâmpadas", List.of(
                                "Muffato Max - Av. Colombo, 2720. Vila Morangueira",
                                "Depósito Areião - Av.Senador Petrônio Portela,1075. Jd. Aclimação",
                                "SuperMuffato - Av. Colombo, 9161 (Catuaí). Zona 43",
                                "Supermercado Cidade Canção - Av. das Palmeiras, 356. Pq. das Palmeiras",
                                "Supermercado Cidade Canção - Av. Lucílio de Held, 1477. jd. Alvorada",
                                "Supermercado Cidade Canção - Av. Mandacaru, 277. Zona 21"
                        ),
                        "Resíduos de Vidros", List.of(
                                "Paróquia Menino Jesus de Praga - Rua Monsenhor Kimura, 36. Jd. Novo Horizonte",
                                "Tiro de Guerra - Av. Mandacaru, 730. Zona 06",
                                "Paróquia Santa Izabel de Portugal - R. Jalbas Rodrigues Alves, 188. Vila Santa Izabel"
                        ),
                        "Ecolix - (plástico, metal, vidro e papel)", List.of(
                                "Upa Zona Sul", "Eurogarden", "Parque Alfredo Nyffeler",
                                "Parque linear Gralha Azul", "Instituto Municipal",
                                "Parque Alfredo Nyffeler", "Upa Zona Norte", "Estádio Regional Willie Davids"
                        )
                );

                locaisPorMaterial.forEach((material, enderecos) -> {
                    enderecos.forEach(endereco -> {
                        repository.save(new LocalColeta(material, endereco));
                    });
                });
                System.out.println("Dados de locais de coleta inicializados!");
            }
        };
    }
}
