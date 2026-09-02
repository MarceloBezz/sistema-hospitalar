package br.com.hospitalar.domain;

import static br.com.hospitalar.domain.utils.ValidacoesRegex.validarNome;

import java.util.Objects;

import br.com.hospitalar.domain.enums.TipoProfissional;
import br.com.hospitalar.domain.exception.RegraDeNegocioException;

public class Profissional {
    private Long id;
    private String nome;
    private TipoProfissional tipo;

    public Profissional(String nome, TipoProfissional tipo) {
        if (nome == null || !validarNome(nome) || tipo == null) {
            throw new RegraDeNegocioException("Dados inválidos");
        }
        this.nome = nome;
        this.tipo = tipo;
    }

    public Profissional(Long id, String nome, TipoProfissional tipo) {
        this(nome, tipo);
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public TipoProfissional getTipo() {
        return tipo;
    }

    public void setTipo(TipoProfissional tipo) {
        this.tipo = Objects.requireNonNull(tipo, "Tipo é obrigatório");
    }

    public void atualizaDados(String nome, TipoProfissional tipo) {
        if (nome != null && validarNome(nome)) {
            this.nome = nome;
        }

        if (tipo != null) {
            this.tipo = tipo;
        }
    }
}
