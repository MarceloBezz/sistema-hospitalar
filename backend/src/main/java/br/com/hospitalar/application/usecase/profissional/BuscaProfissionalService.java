package br.com.hospitalar.application.usecase.profissional;

import br.com.hospitalar.application.ports.in.profissional.BuscaProfissionalUseCase;
import br.com.hospitalar.application.ports.out.ProfissionalRepository;
import br.com.hospitalar.domain.Profissional;
import br.com.hospitalar.domain.exception.RegraDeNegocioException;

public class BuscaProfissionalService implements BuscaProfissionalUseCase {
    private final ProfissionalRepository profissionalRepository;

    public BuscaProfissionalService(ProfissionalRepository profissionalRepository) {
        this.profissionalRepository = profissionalRepository;
    }

    
    public Profissional execute(Long id) {
        return profissionalRepository.buscaPorId(id)
                .orElseThrow(() -> new RegraDeNegocioException("Profissional não encontrado"));
    }
    
}
