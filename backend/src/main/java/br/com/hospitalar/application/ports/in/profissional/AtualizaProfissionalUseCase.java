package br.com.hospitalar.application.ports.in.profissional;

import br.com.hospitalar.application.usecase.profissional.AtualizaProfissionalCommand;
import br.com.hospitalar.domain.Profissional;

public interface AtualizaProfissionalUseCase {
    Profissional execute(Long id, AtualizaProfissionalCommand command);
}
