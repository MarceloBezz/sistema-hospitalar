package br.com.hospitalar.application.ports.in.etapaAtendimento;

import br.com.hospitalar.domain.EtapaAtendimento;

public interface BuscaEtapaAtendimentoUseCase {
    EtapaAtendimento execute(Long id);
}
