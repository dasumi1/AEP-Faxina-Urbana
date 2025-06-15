package br.edu.unicesumar.faxina_urbana.aep.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "locais_coleta")
public class LocalColeta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Tipo de material é obrigatório")
    private String material;

    @NotBlank(message = "Endereço é obrigatório")
    private String endereco;

    public LocalColeta() {
    }

    public LocalColeta(String material, String endereco) {
        this.material = material;
        this.endereco = endereco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}