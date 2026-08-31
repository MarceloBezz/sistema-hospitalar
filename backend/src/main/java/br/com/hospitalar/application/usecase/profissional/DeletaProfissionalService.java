package br.com.hospitalar.application.usecase.profissional;

import br.com.hospitalar.application.ports.in.profissional.DeletaProfissionalUseCase;
import br.com.hospitalar.application.ports.out.ProfissionalRepository;

public class DeletaProfissionalService implements DeletaProfissionalUseCase {
    private final ProfissionalRepository profissionalRepository;

    public DeletaProfissionalService(ProfissionalRepository profissionalRepository) {
        this.profissionalRepository = profissionalRepository;
    }

    public void execute(Long id) {
        profissionalRepository.remove(id);
    }
    
}
