package br.com.hospitalar.interfaces.rest.mapper;

import br.com.hospitalar.application.usecase.profissional.AtualizaProfissionalCommand;
import br.com.hospitalar.application.usecase.profissional.CriaProfissionalCommand;
import br.com.hospitalar.interfaces.rest.dto.profissional.AtualizaProfissionalRequest;
import br.com.hospitalar.interfaces.rest.dto.profissional.CriaProfissionalRequest;

public class ProfissionalRestMapper {
    public static AtualizaProfissionalCommand toAtualizaProfissionalCommand(AtualizaProfissionalRequest request) {
        return new AtualizaProfissionalCommand(
            request.nome(),
            request.tipo()
        );
    }

    public static CriaProfissionalCommand toCriaProfissionalCommand(CriaProfissionalRequest request) {
        return new CriaProfissionalCommand(
            request.nome(),
            request.tipo()
        );
    }
}
