package br.com.hospitalar.application.ports.in.paciente;

import br.com.hospitalar.domain.Paciente;

public interface ConsultaPacienteUseCase {
    Paciente execute(String cpf);
}
