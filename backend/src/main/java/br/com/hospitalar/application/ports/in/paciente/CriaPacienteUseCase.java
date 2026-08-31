package br.com.hospitalar.application.ports.in.paciente;

import br.com.hospitalar.application.usecase.paciente.CriaPacienteCommand;
import br.com.hospitalar.domain.Paciente;

public interface CriaPacienteUseCase {
    Paciente execute(CriaPacienteCommand command);
}
