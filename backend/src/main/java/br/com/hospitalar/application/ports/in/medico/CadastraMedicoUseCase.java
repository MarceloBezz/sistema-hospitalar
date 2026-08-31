package br.com.hospitalar.application.ports.in.medico;

import br.com.hospitalar.application.usecase.medico.CadastraMedicoCommand;
import br.com.hospitalar.domain.Medico;

public interface CadastraMedicoUseCase {
    Medico execute(CadastraMedicoCommand command);
}
