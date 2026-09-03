package br.com.hospitalar.interfaces.rest.dto.profissional;

import br.com.hospitalar.domain.enums.TipoProfissional;

public record AtualizaProfissionalRequest(
    String nome,
    TipoProfissional tipo
) {
    
}
