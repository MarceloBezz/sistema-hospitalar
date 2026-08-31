package br.com.hospitalar.application.ports.in.profissional;

import br.com.hospitalar.domain.Profissional;

public interface BuscaProfissionalUseCase {
    Profissional execute(Long id);
}
