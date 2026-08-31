package br.com.hospitalar.application.usecase.medico;

import br.com.hospitalar.domain.enums.Especialidade;

public record AtualizaMedicoCommand(
    String nome,
    Especialidade especialidade
) {
    
}
