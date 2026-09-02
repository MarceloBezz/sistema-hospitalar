package br.com.hospitalar.infrastructure.persistence.adapter;

import java.util.Optional;

import br.com.hospitalar.application.ports.out.ProfissionalRepository;
import br.com.hospitalar.domain.Profissional;
import br.com.hospitalar.infrastructure.persistence.mapper.ProfissionalMapper;
import br.com.hospitalar.infrastructure.persistence.repository.ProfissionalSpringDataRepository;

public class ProfissionalRepositoryImpl implements ProfissionalRepository {
    private final ProfissionalSpringDataRepository profissionalSpringDataRepository;

    public ProfissionalRepositoryImpl(ProfissionalSpringDataRepository profissionalSpringDataRepository) {
        this.profissionalSpringDataRepository = profissionalSpringDataRepository;
    }

    @Override
    public Optional<Profissional> buscaPorId(Long id) {
        return profissionalSpringDataRepository.findById(id)
                .map(ProfissionalMapper::toDomain);
    }

    @Override
    public Profissional cadastra(Profissional profissional) {
        return ProfissionalMapper.toDomain(
                profissionalSpringDataRepository.save(ProfissionalMapper.toEntity(profissional))
        );
    }

    @Override
    public Profissional atualiza(Profissional profissional) {
        return ProfissionalMapper.toDomain(
                profissionalSpringDataRepository.save(ProfissionalMapper.toEntity(profissional))
        );
    }

    @Override
    public void remove(Long id) {
        profissionalSpringDataRepository.deleteById(id);
    }
    
}
