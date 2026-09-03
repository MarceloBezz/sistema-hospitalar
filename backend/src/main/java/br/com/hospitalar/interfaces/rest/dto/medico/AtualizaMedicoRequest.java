package br.com.hospitalar.interfaces.rest.dto.medico;

import br.com.hospitalar.domain.enums.Especialidade;

public record AtualizaMedicoRequest(
    String nome,
    Especialidade especialidade
) {
    
}
