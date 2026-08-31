package br.com.hospitalar.application.ports.out;

import java.util.Optional;

import br.com.hospitalar.domain.Paciente;

public interface PacienteRepository {
    Optional<Paciente> buscaPorId(Long id);
    Paciente cadastra(Paciente paciente);
    Paciente atualiza(Paciente paciente);
    void remove(Long id);
}
