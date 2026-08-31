package br.com.hospitalar.application.usecase.medico;

import br.com.hospitalar.application.ports.in.medico.DeletaMedicoUseCase;
import br.com.hospitalar.application.ports.out.MedicoRepository;

public class DeletaMedicoService implements DeletaMedicoUseCase {
    private final MedicoRepository medicoRepository;

    public DeletaMedicoService(MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }

    public void execute(Long id) {
        medicoRepository.remove(id);
    }
}
