package br.com.hospitalar.application.ports.in.atendimento;

import java.util.List;

import br.com.hospitalar.domain.Atendimento;

public interface BuscaAtendimentosPorPacienteUseCase {
    List<Atendimento> execute(Long pacienteId);
}
