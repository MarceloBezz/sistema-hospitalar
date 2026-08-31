package br.com.hospitalar.application.usecase.atendimento;

import br.com.hospitalar.application.ports.in.atendimento.EncerraAtendimentoUseCase;
import br.com.hospitalar.application.ports.out.AtendimentoRepository;
import br.com.hospitalar.domain.exception.RegraDeNegocioException;

public class EncerraAtendimentoService implements EncerraAtendimentoUseCase {
    private final AtendimentoRepository atendimentoRepository;

    public EncerraAtendimentoService(AtendimentoRepository atendimentoRepository) {
        this.atendimentoRepository = atendimentoRepository;
    }

    public void execute(Long atendimentoId) {
        var atendimento = atendimentoRepository.buscaPorId(atendimentoId)
                .orElseThrow(() -> new RegraDeNegocioException("Atendimento não encontrado com ID: " + atendimentoId));
        
        if (atendimento.isEncerrado()) {
            throw new RegraDeNegocioException("Atendimento já está encerrado.");
        }

        atendimento.concluirAtendimento();
        atendimentoRepository.salva(atendimento);
    }
    
}
