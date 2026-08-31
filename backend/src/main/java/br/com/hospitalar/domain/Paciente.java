package br.com.hospitalar.domain;

import static br.com.hospitalar.domain.utils.ValidacoesRegex.validarCPF;
import static br.com.hospitalar.domain.utils.ValidacoesRegex.validarEmail;
import static br.com.hospitalar.domain.utils.ValidacoesRegex.validarNome;
import static br.com.hospitalar.domain.utils.ValidacoesRegex.validarTelefone;

import java.time.LocalDate;
import java.util.Objects;

import br.com.hospitalar.domain.exception.RegraDeNegocioException;
import br.com.hospitalar.domain.object_values.Endereco;

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

    public void setNome(String nome) {
        if (nome == null || !validarNome(nome)) {
            throw new RegraDeNegocioException("Nome inválido");
        }
        this.nome = Objects.requireNonNull(nome, "Nome inválido");
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        if (telefone == null || !validarTelefone(telefone)) {
            throw new RegraDeNegocioException("Telefone inválido");
        }
        this.telefone = Objects.requireNonNull(telefone, "Telefone inválido");
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email == null || !validarEmail(email)) {
            throw new RegraDeNegocioException("Email inválido");
        }
        this.email = email;
    }
}
