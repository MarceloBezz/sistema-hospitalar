package br.com.hospitalar.application.usecase.atendimento;

import br.com.hospitalar.application.ports.in.atendimento.BuscaAtendimentoPorIdUseCase;
import br.com.hospitalar.application.ports.out.AtendimentoRepository;
import br.com.hospitalar.domain.Atendimento;
import br.com.hospitalar.domain.exception.RegraDeNegocioException;

public class BuscaAtendimentoPorIdService implements BuscaAtendimentoPorIdUseCase {
    private final AtendimentoRepository atendimentoRepository;

    public BuscaAtendimentoPorIdService(AtendimentoRepository atendimentoRepository) {
        this.atendimentoRepository = atendimentoRepository;
    }

    @Override
    public Atendimento execute(Long id) {
        return atendimentoRepository.buscaPorId(id)
                .orElseThrow(() -> new RegraDeNegocioException("Atendimento não encontrado"));
    }
    
}
