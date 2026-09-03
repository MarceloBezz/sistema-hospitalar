package br.com.hospitalar.interfaces.rest.dto.paciente;

import java.time.LocalDate;

import br.com.hospitalar.domain.Paciente;
import br.com.hospitalar.domain.valueobjects.Endereco;

public record PacienteResponse(
    Long id,
    Endereco endereco,
    String nome,
    String cpf,
    String telefone,
    LocalDate dataNascimento,
    String email
) {
    public PacienteResponse (Paciente paciente) {
        this(
            paciente.getId(),
            paciente.getEndereco(),
            paciente.getNome(),
            paciente.getCpf(),
            paciente.getTelefone(),
            paciente.getDataNascimento(),
            paciente.getEmail()
        );
    }
}
