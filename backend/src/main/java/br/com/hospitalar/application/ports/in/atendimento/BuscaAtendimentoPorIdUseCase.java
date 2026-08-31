package br.com.hospitalar.application.ports.in.atendimento;

import br.com.hospitalar.domain.Atendimento;

public interface BuscaAtendimentoPorIdUseCase {
    Atendimento execute(Long id);
}
