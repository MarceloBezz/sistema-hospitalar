package br.com.hospitalar.application.ports.out;

import java.util.Optional;

import br.com.hospitalar.domain.Paciente;

public interface PacienteRepository {
    Optional<Paciente> buscaPorId(Long id);
    Optional<Paciente> buscaPorCpf(String cpf);
    Paciente cadastra(Paciente paciente);
    Paciente atualiza(Paciente paciente);
    void remove(Long id);
    boolean existePorCpf(String cpf);
    boolean existePorId(Long pacienteId);
}
