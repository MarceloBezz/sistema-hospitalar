package br.com.hospitalar.application.ports.out;

import java.util.List;
import java.util.Optional;

import br.com.hospitalar.domain.Atendimento;
import br.com.hospitalar.domain.Medico;
import br.com.hospitalar.domain.Paciente;

public interface AtendimentoRepository {
    Optional<Atendimento> buscaPorId(Long id);
    List<Atendimento> buscaPorPaciente(Paciente paciente);
    List<Atendimento> buscaPorMedico(Medico medico);
    Atendimento cadastra(Atendimento atendimento);
    void salva(Atendimento atendimento);
    boolean existePorId(Long idAtendimento);
}
