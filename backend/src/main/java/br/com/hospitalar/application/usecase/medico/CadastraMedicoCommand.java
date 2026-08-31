package br.com.hospitalar.application.usecase.medico;

import br.com.hospitalar.domain.enums.Especialidade;

public record CadastraMedicoCommand(
    String nome,
    String crm,
    Especialidade especialidade
) {
    
}
