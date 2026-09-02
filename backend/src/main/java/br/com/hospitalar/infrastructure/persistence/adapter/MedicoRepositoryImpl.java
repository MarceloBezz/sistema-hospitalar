package br.com.hospitalar.infrastructure.persistence.adapter;

import java.util.Optional;

import br.com.hospitalar.application.ports.out.MedicoRepository;
import br.com.hospitalar.domain.Medico;
import br.com.hospitalar.infrastructure.persistence.mapper.MedicoMapper;
import br.com.hospitalar.infrastructure.persistence.repository.MedicoSpringDataRepository;

public class MedicoRepositoryImpl implements MedicoRepository {
    private final MedicoSpringDataRepository medicoSpringDataRepository;

    public MedicoRepositoryImpl(MedicoSpringDataRepository medicoSpringDataRepository) {
        this.medicoSpringDataRepository = medicoSpringDataRepository;
    }

    @Override
    public Optional<Medico> buscaPorCrm(String crm) {
        return medicoSpringDataRepository.findByCrm(crm)
                .map(MedicoMapper::toDomain);
    }

    @Override
    public Optional<Medico> buscaPorId(Long id) {
        return medicoSpringDataRepository.findById(id)
                .map(MedicoMapper::toDomain);
    }

    @Override
    public Medico cadastra(Medico medico) {
        return MedicoMapper.toDomain(
            medicoSpringDataRepository.save(MedicoMapper.toEntity(medico))
        );
    }

    @Override
    public Medico atualiza(Medico medico) {
        return MedicoMapper.toDomain(
            medicoSpringDataRepository.save(MedicoMapper.toEntity(medico))
        );
    }

    @Override
    public void remove(Long id) {
        medicoSpringDataRepository.deleteById(id);
    }

    @Override
    public boolean existePorCRM(String crm) {
        return medicoSpringDataRepository.existsByCrm(crm);
    }
    
}
