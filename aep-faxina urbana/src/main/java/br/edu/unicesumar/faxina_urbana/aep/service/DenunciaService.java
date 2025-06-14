package br.edu.unicesumar.faxina_urbana.aep.service;

import br.edu.unicesumar.faxina_urbana.aep.model.Denuncia;
import br.edu.unicesumar.faxina_urbana.aep.repository.DenunciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;

@Service
public class DenunciaService {
    private final DenunciaRepository denunciaRepository;
    private final Path rootLocation;

    @Autowired
    public DenunciaService(DenunciaRepository denunciaRepository) {
        this.denunciaRepository = denunciaRepository;
        this.rootLocation = Paths.get("uploads");
        try {
            Files.createDirectories(rootLocation);
        } catch (IOException e) {
            throw new RuntimeException("Não foi possível criar o diretório para uploads", e);
        }
    }

    public Denuncia salvarDenuncia(Denuncia denuncia, MultipartFile imagem) throws IOException {
        if (imagem != null && !imagem.isEmpty()) {
            if (!imagem.getContentType().startsWith("image/")) {
                throw new IllegalArgumentException("Apenas imagens são permitidas");
            }

            String nomeArquivo = UUID.randomUUID() + "_" + imagem.getOriginalFilename();
            Path destino = this.rootLocation.resolve(nomeArquivo);

            Files.createDirectories(destino.getParent());
            Files.copy(imagem.getInputStream(), destino, StandardCopyOption.REPLACE_EXISTING);

            denuncia.setImagemPath(nomeArquivo);
        }
        return denunciaRepository.save(denuncia);
    }

    public List<Denuncia> listarDenunciasNaoAtendidas() {
        return denunciaRepository.findByAtendida(false);
    }
}