package br.com.hospitalar.infrastructure.persistence.mapper;

import br.com.hospitalar.domain.EtapaAtendimento;
import br.com.hospitalar.infrastructure.persistence.entity.EtapaAtendimentoJpaEntity;

public class EtapaAtendimentoMapper {
    public static EtapaAtendimentoJpaEntity toEntity(EtapaAtendimento etapaAtendimento) {
        return new EtapaAtendimentoJpaEntity(
            etapaAtendimento.getId(),
            etapaAtendimento.getAtendimento(),
            etapaAtendimento.getProfissional(),
            etapaAtendimento.getTipo(),
            etapaAtendimento.getStatus(),
            etapaAtendimento.getDataInicio(),
            etapaAtendimento.getDataFim(),
            etapaAtendimento.getObservacao()
        );
    }

    public static EtapaAtendimento toDomain(EtapaAtendimentoJpaEntity etapaAtendimentoJpaEntity) {
        return new EtapaAtendimento(
            etapaAtendimentoJpaEntity.getId(),
            etapaAtendimentoJpaEntity.getAtendimento(),
            etapaAtendimentoJpaEntity.getProfissional(),
            etapaAtendimentoJpaEntity.getTipo(),
            etapaAtendimentoJpaEntity.getStatus(),
            etapaAtendimentoJpaEntity.getDataInicio(),
            etapaAtendimentoJpaEntity.getDataFim(),
            etapaAtendimentoJpaEntity.getObservacao()
        );
    }
}
