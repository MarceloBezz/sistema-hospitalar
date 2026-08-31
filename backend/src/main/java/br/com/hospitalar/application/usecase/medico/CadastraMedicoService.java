package br.com.hospitalar.application.usecase.medico;

import br.com.hospitalar.application.ports.in.medico.CadastraMedicoUseCase;
import br.com.hospitalar.application.ports.out.MedicoRepository;
import br.com.hospitalar.domain.Medico;

public class CadastraMedicoService implements CadastraMedicoUseCase {
    private final MedicoRepository medicoRepository;

    public CadastraMedicoService(MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }

    public Medico execute(CadastraMedicoCommand command) {
        if (medicoRepository.existePorCRM(command.crm())) {
            throw new RuntimeException("CRM já cadastrado");
        }
        
        Medico medico = new Medico(command.nome(), command.crm(), command.especialidade());
        return medicoRepository.cadastra(medico);
    }

}
