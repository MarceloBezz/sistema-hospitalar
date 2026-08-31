package br.com.hospitalar.application.ports.out;

import java.util.List;
import java.util.Optional;

import br.com.hospitalar.domain.EtapaAtendimento;

public interface EtapaAtendimentoRepository {
    EtapaAtendimento salva(EtapaAtendimento etapaAtendimento);
    Optional<EtapaAtendimento> buscaPorId(Long id);
    List<EtapaAtendimento> buscaPorAtendimento(Long idAtendimento);
}
