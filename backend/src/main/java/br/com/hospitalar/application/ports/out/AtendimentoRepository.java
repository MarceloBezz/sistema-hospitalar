package br.com.hospitalar.application.ports.out;

import java.util.List;
import java.util.Optional;

import br.com.hospitalar.domain.Atendimento;

public interface AtendimentoRepository {
    Optional<Atendimento> buscaPorId(Long id);
    List<Atendimento> buscaPorPaciente(Long idPaciente);
    List<Atendimento> buscaPorMedico(Long idMedico);
    Atendimento cadastra(Atendimento atendimento);
    void salva(Atendimento atendimento);
}
