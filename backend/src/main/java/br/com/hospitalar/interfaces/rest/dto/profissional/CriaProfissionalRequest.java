package br.com.hospitalar.interfaces.rest.dto.profissional;

import org.hibernate.validator.constraints.Length;

import br.com.hospitalar.domain.enums.TipoProfissional;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CriaProfissionalRequest(
    @NotBlank(message = "Nome é obrigatório") 
    @Length(min = 3, max = 100, message = "Nome deve ter entre 3 e 100 caracteres") 
    String nome,
    @NotNull(message = "Tipo é obrigatório") TipoProfissional tipo
) {
    
}
