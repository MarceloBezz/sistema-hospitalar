package br.com.hospitalar.application.ports.in.medico;

import br.com.hospitalar.domain.Medico;

public interface BuscaMedicoUseCase {
    Medico execute(Long id);
}
