package br.com.hospitalar.interfaces.rest.dto.profissional;

import br.com.hospitalar.domain.Profissional;
import br.com.hospitalar.domain.enums.TipoProfissional;

public record ProfissionalResponse(
    Long id,
    String nome,
    TipoProfissional tipo
) {
    public ProfissionalResponse(Profissional profissional) {
        this(
            profissional.getId(),
            profissional.getNome(),
            profissional.getTipo()
        );
    }
}
