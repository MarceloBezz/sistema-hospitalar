package br.com.hospitalar.interfaces.rest.dto.paciente;

public record AtualizaPacienteRequest(
    String nome,
    String telefone,
    String email,
    AtualizaEnderecoRequest endereco
) {
    
}
