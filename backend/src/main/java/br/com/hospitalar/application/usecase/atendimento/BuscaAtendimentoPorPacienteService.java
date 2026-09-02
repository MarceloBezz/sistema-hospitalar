package br.com.hospitalar.application.usecase.atendimento;

import java.util.List;

import br.com.hospitalar.application.ports.in.atendimento.BuscaAtendimentosPorPacienteUseCase;
import br.com.hospitalar.application.ports.out.AtendimentoRepository;
import br.com.hospitalar.application.ports.out.PacienteRepository;
import br.com.hospitalar.domain.Atendimento;
import br.com.hospitalar.domain.exception.RegraDeNegocioException;

public class BuscaAtendimentoPorPacienteService implements BuscaAtendimentosPorPacienteUseCase{
    private final AtendimentoRepository atendimentoRepository;
    private final PacienteRepository pacienteRepository;
    
    public BuscaAtendimentoPorPacienteService(AtendimentoRepository atendimentoRepository, PacienteRepository pacienteRepository) {
        this.atendimentoRepository = atendimentoRepository;
        this.pacienteRepository = pacienteRepository;
    }

    public List<Atendimento> execute(Long pacienteId) {
        var paciente = pacienteRepository.buscaPorId(pacienteId)
                .orElseThrow(() -> new RegraDeNegocioException("Paciente com ID " + pacienteId + " não encontrado."));

        return atendimentoRepository.buscaPorPaciente(paciente);
    }
}
