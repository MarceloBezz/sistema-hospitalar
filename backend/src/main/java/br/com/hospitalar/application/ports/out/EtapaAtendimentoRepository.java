package br.com.hospitalar.application.ports.out;

import java.util.Optional;

import br.com.hospitalar.domain.EtapaAtendimento;

public interface EtapaAtendimentoRepository {
    EtapaAtendimento salva(EtapaAtendimento etapaAtendimento);
    Optional<EtapaAtendimento> buscaPorId(Long id);
}
