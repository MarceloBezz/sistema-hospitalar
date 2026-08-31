package br.com.hospitalar.application.usecase.profissional;

import br.com.hospitalar.domain.enums.TipoProfissional;

public record CriaProfissionalCommand(
        String nome,
        TipoProfissional tipoProfissional
) {
    
}
