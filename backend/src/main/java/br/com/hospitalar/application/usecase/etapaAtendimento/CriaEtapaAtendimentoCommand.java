package br.com.hospitalar.application.usecase.etapaAtendimento;

import java.time.LocalDateTime;

import br.com.hospitalar.domain.enums.TipoEtapaAtendimento;

public record CriaEtapaAtendimentoCommand(
        Long atendimentoId,
        Long profissionalId,
        TipoEtapaAtendimento tipo,
        LocalDateTime dataInicio) {

}
