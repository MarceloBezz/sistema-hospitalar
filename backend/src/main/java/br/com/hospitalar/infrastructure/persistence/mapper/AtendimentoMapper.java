package br.com.hospitalar.infrastructure.persistence.mapper;

import br.com.hospitalar.domain.Atendimento;
import br.com.hospitalar.infrastructure.persistence.entity.AtendimentoJpaEntity;

public class AtendimentoMapper {
    public static AtendimentoJpaEntity toEntity(Atendimento atendimento) {
        return new AtendimentoJpaEntity(
            atendimento.getId(),
            atendimento.getPaciente(),
            atendimento.getStatus(),
            atendimento.getDataInicio(),
            atendimento.getDataFim()
        );
    }

    public static Atendimento toDomain(AtendimentoJpaEntity atendimentoJpaEntity) {
        return new Atendimento(
            atendimentoJpaEntity.getId(),
            atendimentoJpaEntity.getPaciente(),
            atendimentoJpaEntity.getStatus(),
            atendimentoJpaEntity.getDataInicio(),
            atendimentoJpaEntity.getDataFim()
        );
    }
}
