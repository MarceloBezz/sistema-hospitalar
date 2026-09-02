package br.com.hospitalar.infrastructure.persistence.adapter;

import java.util.List;
import java.util.Optional;

import br.com.hospitalar.application.ports.out.AtendimentoRepository;
import br.com.hospitalar.domain.Atendimento;
import br.com.hospitalar.domain.Medico;
import br.com.hospitalar.domain.Paciente;
import br.com.hospitalar.infrastructure.persistence.mapper.AtendimentoMapper;
import br.com.hospitalar.infrastructure.persistence.mapper.MedicoMapper;
import br.com.hospitalar.infrastructure.persistence.mapper.PacienteMapper;
import br.com.hospitalar.infrastructure.persistence.repository.AtendimentoSpringDataRepository;

public class AtendimentoRepositoryImpl implements AtendimentoRepository {
    private final AtendimentoSpringDataRepository atendimentoSpringDataRepository;

    public AtendimentoRepositoryImpl(AtendimentoSpringDataRepository atendimentoSpringDataRepository) {
        this.atendimentoSpringDataRepository = atendimentoSpringDataRepository;
    }

    @Override
    public Optional<Atendimento> buscaPorId(Long id) {
        return atendimentoSpringDataRepository.findById(id)
                .map(AtendimentoMapper::toDomain);
    }

    @Override
    public List<Atendimento> buscaPorPaciente(Paciente paciente) {
        return atendimentoSpringDataRepository.findByPaciente(PacienteMapper.toEntity(paciente))
                .stream()
                .map(AtendimentoMapper::toDomain)
                .toList();
    }

    @Override
    public List<Atendimento> buscaPorMedico(Medico medico) {
        return atendimentoSpringDataRepository.findByMedico(MedicoMapper.toEntity(medico))
                .stream()
                .map(AtendimentoMapper::toDomain)
                .toList();
    }

    @Override
    public Atendimento cadastra(Atendimento atendimento) {
        return AtendimentoMapper.toDomain(
            atendimentoSpringDataRepository.save(AtendimentoMapper.toEntity(atendimento))
        );
    }

    @Override
    public void salva(Atendimento atendimento) {
        atendimentoSpringDataRepository.save(AtendimentoMapper.toEntity(atendimento));
    }
    

    @Override
    public boolean existePorId(Long idAtendimento) {
        return atendimentoSpringDataRepository.existsById(idAtendimento);
    }

}
