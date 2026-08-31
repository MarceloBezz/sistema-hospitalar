package br.com.hospitalar.application.usecase.etapaAtendimento;

import br.com.hospitalar.application.ports.in.etapaAtendimento.CriaEtapaAtendimentoUseCase;
import br.com.hospitalar.application.ports.out.AtendimentoRepository;
import br.com.hospitalar.application.ports.out.EtapaAtendimentoRepository;
import br.com.hospitalar.application.ports.out.ProfissionalRepository;
import br.com.hospitalar.domain.EtapaAtendimento;
import br.com.hospitalar.domain.exception.RegraDeNegocioException;

public class CriaEtapaAtendimentoService implements CriaEtapaAtendimentoUseCase {
    private final EtapaAtendimentoRepository etapaAtendimentoRepository;
    private final ProfissionalRepository profissionalRepository;
    private final AtendimentoRepository atendimentoRepository;

    public CriaEtapaAtendimentoService(EtapaAtendimentoRepository etapaAtendimentoRepository,
        ProfissionalRepository profissionalRepository, AtendimentoRepository atendimentoRepository) {
        this.etapaAtendimentoRepository = etapaAtendimentoRepository;
        this.profissionalRepository = profissionalRepository;
        this.atendimentoRepository = atendimentoRepository;
    }

    public EtapaAtendimento execute(CriaEtapaAtendimentoCommand command) {
        var profissional = profissionalRepository.buscaPorId(command.profissionalId())
            .orElseThrow(() -> new RegraDeNegocioException("Profissional não encontrado"));
        var atendimento = atendimentoRepository.buscaPorId(command.atendimentoId())
            .orElseThrow(() -> new RegraDeNegocioException("Atendimento não encontrado"));
        if (atendimento.isEncerrado()) {
            throw new RegraDeNegocioException("Não é possível criar uma etapa para um atendimento encerrado.");
        }

        var etapaAtendimento = new EtapaAtendimento(atendimento, profissional, command.tipo());
        return etapaAtendimentoRepository.salva(etapaAtendimento);
    }
    
}
