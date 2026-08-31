package br.com.hospitalar.application.usecase.paciente;

import br.com.hospitalar.application.ports.in.paciente.AtualizaPacienteUseCase;
import br.com.hospitalar.application.ports.out.PacienteRepository;
import br.com.hospitalar.domain.Paciente;
import br.com.hospitalar.domain.exception.RegraDeNegocioException;

public class AtualizaPacienteService implements AtualizaPacienteUseCase {
    private final PacienteRepository pacienteRepository;

    public AtualizaPacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    @Override
    public Paciente execute(Long id, AtualizaPacienteCommand command) {
        Paciente paciente = pacienteRepository.buscaPorId(id)
                .orElseThrow(() -> new RegraDeNegocioException("Paciente não encontrado"));

        paciente.atualizaInformacoes(command.nome(), command.telefone(), command.email(), command.endereco());

        return pacienteRepository.atualiza(paciente);
    }
    
}
