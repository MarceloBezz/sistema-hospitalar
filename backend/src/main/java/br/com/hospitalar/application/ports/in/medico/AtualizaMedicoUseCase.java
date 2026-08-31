package br.com.hospitalar.application.ports.in.medico;

import br.com.hospitalar.application.usecase.medico.AtualizaMedicoCommand;
import br.com.hospitalar.domain.Medico;

public interface AtualizaMedicoUseCase {
    Medico execute(Long id, AtualizaMedicoCommand command);
}
