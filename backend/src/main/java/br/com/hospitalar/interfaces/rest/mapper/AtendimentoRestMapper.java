package br.com.hospitalar.interfaces.rest.mapper;

import java.util.List;

import br.com.hospitalar.application.usecase.atendimento.CriaAtendimentoCommand;
import br.com.hospitalar.domain.Atendimento;
import br.com.hospitalar.interfaces.rest.dto.atendimento.AtendimentoResponse;

public class AtendimentoRestMapper {
    public static List<AtendimentoResponse> toResponseList(List<Atendimento> atendimentos) {
        return atendimentos.stream()
                .map(AtendimentoResponse::new)
                .toList();
    }

    public static CriaAtendimentoCommand toCriaAtendimentoCommand(Long idPaciente) {
        return new CriaAtendimentoCommand(idPaciente);
    }
}
