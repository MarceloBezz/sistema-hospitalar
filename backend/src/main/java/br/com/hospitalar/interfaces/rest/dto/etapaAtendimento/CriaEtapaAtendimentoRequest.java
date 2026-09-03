package br.com.hospitalar.interfaces.rest.dto.etapaAtendimento;

import java.time.LocalDateTime;

import br.com.hospitalar.domain.enums.TipoEtapaAtendimento;
import jakarta.validation.constraints.NotNull;

public record CriaEtapaAtendimentoRequest(
        @NotNull(message = "O ID do atendimento é obrigatório") Long atendimentoId,
        @NotNull(message = "O ID do profissional é obrigatório") Long profissionalId,
        @NotNull(message = "O tipo da etapa de atendimento é obrigatório") TipoEtapaAtendimento tipo,
        @NotNull(message = "A data de início da etapa de atendimento é obrigatória") LocalDateTime dataInicio
) {
    
}
