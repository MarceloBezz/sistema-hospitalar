package br.com.hospitalar.application.usecase.paciente;

import java.time.LocalDate;

import br.com.hospitalar.domain.valueobjects.Endereco;

public record CriaPacienteCommand(
    String nome,
    String cpf,
    String telefone,
    String email,
    LocalDate dataNascimento,
    Endereco endereco
) {
    
}
