package br.com.hospitalar.interfaces.rest.dto.paciente;

import java.time.LocalDate;

import br.com.hospitalar.domain.valueobjects.Endereco;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

public record CriarPacienteRequest(
        @NotNull Endereco endereco,
        @NotBlank String nome,
        @NotBlank String cpf,
        @NotBlank String telefone,
        @Past @NotNull LocalDate dataNascimento,
        @NotBlank @Email String email) {
}
