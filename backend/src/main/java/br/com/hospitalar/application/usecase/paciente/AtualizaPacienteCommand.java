package br.com.hospitalar.application.usecase.paciente;

import br.com.hospitalar.domain.valueobjects.Endereco;

public record AtualizaPacienteCommand(
    String nome,
    String telefone,
    String email,
    Endereco endereco
) {
    
}
