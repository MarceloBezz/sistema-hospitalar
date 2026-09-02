package br.com.hospitalar.domain;

import static br.com.hospitalar.domain.utils.ValidacoesRegex.validarCPF;
import static br.com.hospitalar.domain.utils.ValidacoesRegex.validarEmail;
import static br.com.hospitalar.domain.utils.ValidacoesRegex.validarNome;
import static br.com.hospitalar.domain.utils.ValidacoesRegex.validarTelefone;

import java.time.LocalDate;
import java.util.Objects;

import br.com.hospitalar.domain.exception.RegraDeNegocioException;
import br.com.hospitalar.domain.valueobjects.Endereco;

public class Paciente {
    private Long id;
    private Endereco endereco;
    private String nome;
    private String cpf;
    private String telefone;
    private LocalDate dataNascimento;
    private String email;

    public Paciente(Endereco endereco, String nome, String cpf, String telefone,
            LocalDate dataNascimento, String email) {
        validaDados(endereco, nome, cpf, telefone, dataNascimento, email);

        this.endereco = endereco;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.email = email;
    }

    public Paciente(Long id, Endereco endereco, String nome, String cpf, String telefone,
            LocalDate dataNascimento, String email) {
        this(endereco, nome, cpf, telefone, dataNascimento, email);
        this.id = id;
    }

    private void validaDados(Endereco endereco, String nome, String cpf, String telefone, LocalDate dataNascimento,
            String email) {
        if (endereco == null || nome == null || !validarNome(nome) || cpf == null || !validarCPF(cpf)
                || telefone == null || !validarTelefone(telefone) || dataNascimento == null
                || email == null || !validarEmail(email)) {
            throw new RegraDeNegocioException("Dados inválidos");
        }
    }

    public Long getId() {
        return id;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = Objects.requireNonNull(endereco, "Endereco inválido");
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void atualizaInformacoes(String nome, String telefone, String email, Endereco endereco) {
        if (nome != null && validarNome(nome)) {
            this.nome = nome;
        }
        if (telefone != null && validarTelefone(telefone)) {
            this.telefone = telefone;
        }
        if (email != null && validarEmail(email)) {
            this.email = email;
        }
        if (endereco != null) {
            this.endereco = endereco;
        }
    }
}
