package br.com.hospitalar.application.ports.in.paciente;

import br.com.hospitalar.application.usecase.paciente.AtualizaPacienteCommand;
import br.com.hospitalar.domain.Paciente;

public interface AtualizaPacienteUseCase {
    Paciente execute(Long id, AtualizaPacienteCommand command);
}
