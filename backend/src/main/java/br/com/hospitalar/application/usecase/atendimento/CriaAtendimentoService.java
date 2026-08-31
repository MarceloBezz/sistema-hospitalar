package br.com.hospitalar.application.usecase.atendimento;

import br.com.hospitalar.application.ports.in.atendimento.CriaAtendimentoUseCase;
import br.com.hospitalar.application.ports.out.AtendimentoRepository;
import br.com.hospitalar.application.ports.out.PacienteRepository;
import br.com.hospitalar.domain.Atendimento;
import br.com.hospitalar.domain.exception.RegraDeNegocioException;

public class CriaAtendimentoService implements CriaAtendimentoUseCase{
    private final AtendimentoRepository atendimentoRepository;
    private final PacienteRepository pacienteRepository;

    public CriaAtendimentoService(AtendimentoRepository atendimentoRepository, PacienteRepository pacienteRepository) {
        this.atendimentoRepository = atendimentoRepository;
        this.pacienteRepository = pacienteRepository;
    }

    public Atendimento execute(CriaAtendimentoCommand command) {
        var paciente = pacienteRepository.buscaPorId(command.pacienteId())
                .orElseThrow(() -> new RegraDeNegocioException("Paciente com ID " + command.pacienteId() + " não encontrado."));

        var atendimento = new Atendimento(paciente);
        return atendimentoRepository.cadastra(atendimento);
    }
}
