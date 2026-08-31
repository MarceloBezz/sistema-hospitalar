package br.com.hospitalar.application.usecase.profissional;

import br.com.hospitalar.application.ports.in.profissional.AtualizaProfissionalUseCase;
import br.com.hospitalar.application.ports.out.ProfissionalRepository;
import br.com.hospitalar.domain.Profissional;
import br.com.hospitalar.domain.exception.RegraDeNegocioException;

public class AtualizaProfissionalService implements AtualizaProfissionalUseCase {
    private final ProfissionalRepository profissionalRepository;

    public AtualizaProfissionalService(ProfissionalRepository profissionalRepository) {
        this.profissionalRepository = profissionalRepository;
    }
    
    public Profissional execute(Long id, AtualizaProfissionalCommand command) {
        var profissional = profissionalRepository.buscaPorId(id)
                .orElseThrow(() -> new RegraDeNegocioException("Profissional não encontrado"));
        
        profissional.atualizaDados(command.nome(), command.tipoProfissional());
        
        return profissionalRepository.atualiza(profissional);
    }
}
