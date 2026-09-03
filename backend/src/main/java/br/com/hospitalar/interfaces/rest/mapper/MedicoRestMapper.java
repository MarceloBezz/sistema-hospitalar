package br.com.hospitalar.interfaces.rest.mapper;

import br.com.hospitalar.application.usecase.medico.AtualizaMedicoCommand;
import br.com.hospitalar.application.usecase.medico.CadastraMedicoCommand;
import br.com.hospitalar.interfaces.rest.dto.medico.AtualizaMedicoRequest;
import br.com.hospitalar.interfaces.rest.dto.medico.CadastraMedicoRequest;

public class MedicoRestMapper {
    public static AtualizaMedicoCommand toAtualizaMedicoCommand(AtualizaMedicoRequest request) {
        return new AtualizaMedicoCommand(request.nome(), request.especialidade());
    }

    public static CadastraMedicoCommand toCadastraMedicoCommand(CadastraMedicoRequest request) {
        return new CadastraMedicoCommand(
            request.nome(),
            request.crm(), 
            request.especialidade()
        );
    }
}
