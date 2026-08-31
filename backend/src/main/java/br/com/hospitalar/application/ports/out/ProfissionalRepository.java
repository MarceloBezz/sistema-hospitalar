package br.com.hospitalar.application.ports.out;

import java.util.Optional;

import br.com.hospitalar.domain.Profissional;

public interface ProfissionalRepository {
    Optional<Profissional> buscaPorId(Long id);
    Profissional cadastra(Profissional profissional);
    Profissional atualiza(Profissional profissional);
    void remove(Long id);
}
