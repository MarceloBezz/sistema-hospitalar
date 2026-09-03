package br.com.hospitalar.interfaces.rest.mapper;

import br.com.hospitalar.application.usecase.paciente.AtualizaPacienteCommand;
import br.com.hospitalar.application.usecase.paciente.CriaPacienteCommand;
import br.com.hospitalar.domain.valueobjects.Endereco;
import br.com.hospitalar.interfaces.rest.dto.paciente.AtualizaPacienteRequest;
import br.com.hospitalar.interfaces.rest.dto.paciente.CriarPacienteRequest;

public class PacienteRestMapper {
    public static CriaPacienteCommand toCriaPacienteCommand(CriarPacienteRequest request) {
        return new CriaPacienteCommand(
                request.nome(),
                request.cpf(),
                request.telefone(),
                request.email(),
                request.dataNascimento(),
                request.endereco());
    }

    public static AtualizaPacienteCommand toAtualizaPacienteCommand(AtualizaPacienteRequest request) {
        Endereco endereco = null;
        if (request.endereco() != null) {
            endereco = new Endereco(
                request.endereco().logradouro(),
                request.endereco().numero(),
                request.endereco().complemento(),
                request.endereco().bairro(),
                request.endereco().cidade(),
                request.endereco().estado(),
                request.endereco().cep()
            );
        }

        return new AtualizaPacienteCommand(
            request.nome(),
            request.telefone(),
            request.email(),
            endereco
        );
    }
}
