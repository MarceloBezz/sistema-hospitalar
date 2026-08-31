package br.com.hospitalar.application.usecase.profissional;

import br.com.hospitalar.application.ports.in.profissional.CriaProfissionalUseCase;
import br.com.hospitalar.application.ports.out.ProfissionalRepository;
import br.com.hospitalar.domain.Profissional;

public class CriaProfissionalService implements CriaProfissionalUseCase {
    private final ProfissionalRepository profissionalRepository;

    public CriaProfissionalService(ProfissionalRepository profissionalRepository) {
        this.profissionalRepository = profissionalRepository;
    }

    public Profissional execute(CriaProfissionalCommand command) {
        Profissional profissional = new Profissional(command.nome(), command.tipoProfissional());
        return profissionalRepository.cadastra(profissional);
    }
    
}
