package br.edu.unicesumar.faxina_urbana.aep.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "locais_coleta")
public class LocalColeta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotBlank(message = "Endereço é obrigatório")
    private String endereco;

    @NotBlank(message = "Bairro é obrigatório")
    private String bairro;

    @NotBlank(message = "Horário de funcionamento é obrigatório")
    private String horarioFuncionamento;

    @NotBlank(message = "Tipos de resíduos aceitos é obrigatório")
    private String tiposResiduosAceitos;

    @Column(columnDefinition = "TEXT")
    private String observacoes;

    // Construtores
    public LocalColeta() {
    }

    public LocalColeta(String nome, String endereco, String bairro,
                       String horarioFuncionamento, String tiposResiduosAceitos,
                       String observacoes) {
        this.nome = nome;
        this.endereco = endereco;
        this.bairro = bairro;
        this.horarioFuncionamento = horarioFuncionamento;
        this.tiposResiduosAceitos = tiposResiduosAceitos;
        this.observacoes = observacoes;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getHorarioFuncionamento() {
        return horarioFuncionamento;
    }

    public void setHorarioFuncionamento(String horarioFuncionamento) {
        this.horarioFuncionamento = horarioFuncionamento;
    }

    public String getTiposResiduosAceitos() {
        return tiposResiduosAceitos;
    }

    public void setTiposResiduosAceitos(String tiposResiduosAceitos) {
        this.tiposResiduosAceitos = tiposResiduosAceitos;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
}