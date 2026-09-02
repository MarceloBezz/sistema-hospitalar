package br.com.hospitalar.infrastructure.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hospitalar.infrastructure.persistence.entity.AtendimentoJpaEntity;
import br.com.hospitalar.infrastructure.persistence.entity.EtapaAtendimentoJpaEntity;

public interface EtapaAtendimentoSpringDataRepository extends JpaRepository<EtapaAtendimentoJpaEntity, Long> {
    List<EtapaAtendimentoJpaEntity> findByAtendimento(AtendimentoJpaEntity atendimento);
}
