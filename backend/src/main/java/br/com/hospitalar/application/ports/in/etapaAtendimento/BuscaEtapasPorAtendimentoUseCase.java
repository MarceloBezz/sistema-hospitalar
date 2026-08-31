package br.com.hospitalar.application.ports.in.etapaAtendimento;

import java.util.List;

import br.com.hospitalar.domain.EtapaAtendimento;

public interface BuscaEtapasPorAtendimentoUseCase {
    List<EtapaAtendimento> execute(Long idAtendimento);
}
