package br.com.hospitalar.interfaces.rest.dto.atendimento;

import java.time.LocalDateTime;

import br.com.hospitalar.domain.Atendimento;
import br.com.hospitalar.domain.enums.Status;

public record AtendimentoResponse(
    Long id,
    String pacienteNome,
    Status status,
    LocalDateTime dataInicio,
    LocalDateTime dataFim
) {
    public AtendimentoResponse(Atendimento atendimento) {
        this(
            atendimento.getId(),
            atendimento.getPaciente().getNome(),
            atendimento.getStatus(),
            atendimento.getDataInicio(),
            atendimento.getDataFim()
        );
    }
}
