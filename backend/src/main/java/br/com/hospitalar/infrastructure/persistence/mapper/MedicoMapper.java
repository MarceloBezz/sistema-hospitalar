package br.com.hospitalar.infrastructure.persistence.mapper;

import br.com.hospitalar.domain.Medico;
import br.com.hospitalar.infrastructure.persistence.entity.MedicoJpaEntity;

public class MedicoMapper {
    public static MedicoJpaEntity toEntity(Medico medico) {
        return new MedicoJpaEntity(
            medico.getId(),
            medico.getNome(),
            medico.getCrm(),
            medico.getEspecialidade()
        );
    }

    public static Medico toDomain(MedicoJpaEntity medicoJpaEntity) {
        return new Medico(
            medicoJpaEntity.getId(),
            medicoJpaEntity.getNome(),
            medicoJpaEntity.getCrm(),
            medicoJpaEntity.getEspecialidade()
        );
    }
}
