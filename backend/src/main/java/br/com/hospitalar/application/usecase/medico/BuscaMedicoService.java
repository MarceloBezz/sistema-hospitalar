package br.com.hospitalar.application.usecase.medico;

import br.com.hospitalar.application.ports.in.medico.BuscaMedicoUseCase;
import br.com.hospitalar.application.ports.out.MedicoRepository;
import br.com.hospitalar.domain.Medico;
import br.com.hospitalar.domain.exception.RegraDeNegocioException;

public class BuscaMedicoService implements BuscaMedicoUseCase {
    private final MedicoRepository medicoRepository;

    public BuscaMedicoService(MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }
    
    public Medico execute(Long id) {
        return medicoRepository.buscaPorId(id)
            .orElseThrow(() -> new RegraDeNegocioException("Médico não encontrado"));
    }
    
}
