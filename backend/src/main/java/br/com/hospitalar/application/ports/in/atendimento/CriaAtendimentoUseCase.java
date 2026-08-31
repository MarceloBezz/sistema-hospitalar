package br.com.hospitalar.application.ports.in.atendimento;

import br.com.hospitalar.application.usecase.atendimento.CriaAtendimentoCommand;
import br.com.hospitalar.domain.Atendimento;

public interface CriaAtendimentoUseCase {
    Atendimento execute(CriaAtendimentoCommand command);
}
