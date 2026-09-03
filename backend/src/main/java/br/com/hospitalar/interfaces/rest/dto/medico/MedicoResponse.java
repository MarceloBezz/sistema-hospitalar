package br.com.hospitalar.interfaces.rest.dto.medico;

import br.com.hospitalar.domain.Medico;
import br.com.hospitalar.domain.enums.Especialidade;

public record MedicoResponse(
    Long id,
    String nome,
    Especialidade especialidade
) {
    public MedicoResponse(Medico medico) {
        this(
            medico.getId(),
            medico.getNome(),
            medico.getEspecialidade()
        );
    }
}
