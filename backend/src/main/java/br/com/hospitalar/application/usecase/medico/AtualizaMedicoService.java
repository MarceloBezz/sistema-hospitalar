package br.com.hospitalar.application.usecase.medico;

import br.com.hospitalar.application.ports.in.medico.AtualizaMedicoUseCase;
import br.com.hospitalar.application.ports.out.MedicoRepository;
import br.com.hospitalar.domain.Medico;

public class AtualizaMedicoService implements AtualizaMedicoUseCase {
    private final MedicoRepository medicoRepository;

    public AtualizaMedicoService(MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }
    
    public Medico execute(Long id, AtualizaMedicoCommand command) {
        var medico = medicoRepository.buscaPorId(id)
            .orElseThrow(() -> new RuntimeException("Médico não encontrado"));

        medico.atualizaDados(command.nome(), command.especialidade());

        return medicoRepository.atualiza(medico);
    }    
}
