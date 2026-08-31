package br.com.hospitalar.application.usecase.paciente;

import br.com.hospitalar.application.ports.in.paciente.ConsultaPacienteUseCase;
import br.com.hospitalar.application.ports.out.PacienteRepository;
import br.com.hospitalar.domain.Paciente;
import br.com.hospitalar.domain.exception.RegraDeNegocioException;

public class ConsultaPacienteService implements ConsultaPacienteUseCase {
    private final PacienteRepository pacienteRepository;

    public ConsultaPacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    @Override
    public Paciente execute(String cpf) {
        return pacienteRepository.buscaPorCpf(cpf)
                .orElseThrow(() -> new RegraDeNegocioException("Paciente não encontrado"));
    }
    
}
