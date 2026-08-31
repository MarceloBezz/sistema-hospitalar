package br.com.hospitalar.application.usecase.paciente;

import br.com.hospitalar.application.ports.in.paciente.CriaPacienteUseCase;
import br.com.hospitalar.application.ports.out.PacienteRepository;
import br.com.hospitalar.domain.Paciente;
import br.com.hospitalar.domain.exception.RegraDeNegocioException;

public class CriaPacienteService implements CriaPacienteUseCase {
    private final PacienteRepository pacienteRepository;

    public CriaPacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public Paciente execute(CriaPacienteCommand command) {
        if (pacienteRepository.existePorCpf(command.cpf())) {
            throw new RegraDeNegocioException("Paciente com CPF " + command.cpf() + " já existe.");
        }

        var paciente = new Paciente(
            command.endereco(),
            command.nome(),
            command.cpf(),
            command.telefone(),
            command.dataNascimento(),
            command.email()
        );

        var pacienteCadastrado = pacienteRepository.cadastra(paciente);
        return pacienteCadastrado;
    }
}
