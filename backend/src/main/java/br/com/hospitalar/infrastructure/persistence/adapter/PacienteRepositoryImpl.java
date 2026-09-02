package br.com.hospitalar.infrastructure.persistence.adapter;

import java.util.Optional;

import br.com.hospitalar.application.ports.out.PacienteRepository;
import br.com.hospitalar.domain.Paciente;
import br.com.hospitalar.infrastructure.persistence.mapper.PacienteMapper;
import br.com.hospitalar.infrastructure.persistence.repository.PacienteSpringDataRepository;

public class PacienteRepositoryImpl implements PacienteRepository {
    private final PacienteSpringDataRepository pacienteRepositoryJpa;

    public PacienteRepositoryImpl(PacienteSpringDataRepository pacienteRepositoryJpa) {
        this.pacienteRepositoryJpa = pacienteRepositoryJpa;
    }

    @Override
    public Optional<Paciente> buscaPorId(Long id) {
        return pacienteRepositoryJpa.findById(id)
                .map(PacienteMapper::toDomain);
    }

    @Override
    public Optional<Paciente> buscaPorCpf(String cpf) {
        return pacienteRepositoryJpa.findByCpf(cpf)
                .map(PacienteMapper::toDomain);
    }

    @Override
    public Paciente cadastra(Paciente paciente) {
        return PacienteMapper.toDomain(
            pacienteRepositoryJpa.save(PacienteMapper.toEntity(paciente))
        );
    }

    @Override
    public Paciente atualiza(Paciente paciente) {
        return PacienteMapper.toDomain(
            pacienteRepositoryJpa.save(PacienteMapper.toEntity(paciente))
        );
    }

    @Override
    public void remove(Long id) {
        pacienteRepositoryJpa.deleteById(id);
    }

    @Override
    public boolean existePorCpf(String cpf) {
        return pacienteRepositoryJpa.existsByCpf(cpf);
    }

    @Override
    public boolean existePorId(Long pacienteId) {
        return pacienteRepositoryJpa.existsById(pacienteId);
    }
    
}
