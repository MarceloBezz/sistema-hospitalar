package br.com.hospitalar.application.usecase.etapaAtendimento;

import br.com.hospitalar.application.ports.in.etapaAtendimento.BuscaEtapaAtendimentoUseCase;
import br.com.hospitalar.application.ports.out.EtapaAtendimentoRepository;
import br.com.hospitalar.domain.EtapaAtendimento;
import br.com.hospitalar.domain.exception.RegraDeNegocioException;

public class BuscaEtapaAtendimentoService implements BuscaEtapaAtendimentoUseCase {
    private final EtapaAtendimentoRepository etapaAtendimentoRepository;

    public BuscaEtapaAtendimentoService(EtapaAtendimentoRepository etapaAtendimentoRepository) {
        this.etapaAtendimentoRepository = etapaAtendimentoRepository;
    }

    public EtapaAtendimento execute(Long id) {
        return etapaAtendimentoRepository.buscaPorId(id)
                .orElseThrow(() -> new RegraDeNegocioException("Etapa de atendimento não encontrada"));
    }
    
}
