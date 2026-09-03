package br.com.hospitalar.interfaces.rest.dto.medico;

import br.com.hospitalar.domain.enums.Especialidade;
import jakarta.validation.constraints.NotBlank;

public record CadastraMedicoRequest(
    @NotBlank(message = "O nome é obrigatório") String nome,
    @NotBlank(message = "O CRM é obrigatório") String crm,
    @NotBlank(message = "A especialidade é obrigatória") Especialidade especialidade
) {
    
}
