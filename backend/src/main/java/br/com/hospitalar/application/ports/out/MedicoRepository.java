package br.com.hospitalar.application.ports.out;

import java.util.Optional;

import br.com.hospitalar.domain.Medico;

public interface MedicoRepository {
    Optional<Medico> buscaPorCrm(String crm);
    Medico cadastra(Medico medico);
    Medico atualiza(Medico medico);
    void remove(Long id);
}
