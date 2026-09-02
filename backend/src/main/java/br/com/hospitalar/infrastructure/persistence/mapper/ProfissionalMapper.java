package br.com.hospitalar.infrastructure.persistence.mapper;

import br.com.hospitalar.domain.Profissional;
import br.com.hospitalar.infrastructure.persistence.entity.ProfissionalJpaEntity;

public class ProfissionalMapper {
    public static ProfissionalJpaEntity toEntity(Profissional profissional) {
        return new ProfissionalJpaEntity(
            profissional.getId(),
            profissional.getNome(),
            profissional.getTipo()
        );
    }

    public static Profissional toDomain(ProfissionalJpaEntity profissionalJpaEntity) {
        return new Profissional(
            profissionalJpaEntity.getId(),
            profissionalJpaEntity.getNome(),
            profissionalJpaEntity.getTipo()
        );
    }
}
