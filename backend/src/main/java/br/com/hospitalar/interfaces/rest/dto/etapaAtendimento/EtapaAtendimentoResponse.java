package br.com.hospitalar.interfaces.rest.dto.etapaAtendimento;

import java.time.LocalDateTime;

import br.com.hospitalar.domain.EtapaAtendimento;
import br.com.hospitalar.domain.enums.Status;
import br.com.hospitalar.domain.enums.TipoEtapaAtendimento;

public record EtapaAtendimentoResponse(
    Long id,
    Long atendimentoId,
    Long profissionalId,
    TipoEtapaAtendimento tipo,
    LocalDateTime dataInicio,
    LocalDateTime dataFim,
    Status status,
    String observacao
) {
    public EtapaAtendimentoResponse(EtapaAtendimento etapaAtendimento) {
        this(
            etapaAtendimento.getId(),
            etapaAtendimento.getAtendimento().getId(),
            etapaAtendimento.getProfissional().getId(),
            etapaAtendimento.getTipo(),
            etapaAtendimento.getDataInicio(),
            etapaAtendimento.getDataFim(),
            etapaAtendimento.getStatus(),
            etapaAtendimento.getObservacao()
        );
    }
}
