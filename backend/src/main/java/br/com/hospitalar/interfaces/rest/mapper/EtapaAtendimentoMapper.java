package br.com.hospitalar.interfaces.rest.mapper;

import java.util.List;

import br.com.hospitalar.application.usecase.etapaAtendimento.CriaEtapaAtendimentoCommand;
import br.com.hospitalar.domain.EtapaAtendimento;
import br.com.hospitalar.interfaces.rest.dto.etapaAtendimento.CriaEtapaAtendimentoRequest;
import br.com.hospitalar.interfaces.rest.dto.etapaAtendimento.EtapaAtendimentoResponse;

public class EtapaAtendimentoMapper {
    public static List<EtapaAtendimentoResponse> toResponseList(List<EtapaAtendimento> etapas) {
        return etapas.stream()
                .map(EtapaAtendimentoResponse::new)
                .toList();
    }

    public static CriaEtapaAtendimentoCommand toCommand(CriaEtapaAtendimentoRequest request) {
        return new CriaEtapaAtendimentoCommand(
                request.atendimentoId(),
                request.profissionalId(),
                request.tipo(),
                request.dataInicio()
        );
    }
}
