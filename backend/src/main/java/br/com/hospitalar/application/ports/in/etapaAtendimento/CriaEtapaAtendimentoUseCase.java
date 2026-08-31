package br.com.hospitalar.application.ports.in.etapaAtendimento;

import br.com.hospitalar.application.usecase.etapaAtendimento.CriaEtapaAtendimentoCommand;
import br.com.hospitalar.domain.EtapaAtendimento;

public interface CriaEtapaAtendimentoUseCase {
    EtapaAtendimento execute(CriaEtapaAtendimentoCommand command);
}
