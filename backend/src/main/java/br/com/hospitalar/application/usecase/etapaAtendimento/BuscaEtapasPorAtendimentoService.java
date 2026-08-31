package br.com.hospitalar.application.usecase.etapaAtendimento;

import java.util.List;

import br.com.hospitalar.application.ports.in.etapaAtendimento.BuscaEtapasPorAtendimentoUseCase;
import br.com.hospitalar.application.ports.out.AtendimentoRepository;
import br.com.hospitalar.application.ports.out.EtapaAtendimentoRepository;
import br.com.hospitalar.domain.EtapaAtendimento;
import br.com.hospitalar.domain.exception.RegraDeNegocioException;

public class BuscaEtapasPorAtendimentoService implements BuscaEtapasPorAtendimentoUseCase {
    private final EtapaAtendimentoRepository etapaAtendimentoRepository;
    private final AtendimentoRepository atendimentoRepository;

    public BuscaEtapasPorAtendimentoService(EtapaAtendimentoRepository etapaAtendimentoRepository, AtendimentoRepository atendimentoRepository) {
        this.etapaAtendimentoRepository = etapaAtendimentoRepository;
        this.atendimentoRepository = atendimentoRepository;
    }

    @Override
    public List<EtapaAtendimento> execute(Long idAtendimento) {
        if (!atendimentoRepository.existePorId(idAtendimento)) {
            throw new RegraDeNegocioException("Atendimento não encontrado");
        }

        return etapaAtendimentoRepository.buscaPorAtendimento(idAtendimento);
    }
    
}
