package br.com.hospitalar.infrastructure.persistence.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hospitalar.infrastructure.persistence.entity.MedicoJpaEntity;

public interface MedicoSpringDataRepository extends JpaRepository<MedicoJpaEntity, Long> {
    Optional<MedicoJpaEntity> findByCrm(String crm);
    boolean existsByCrm(String crm);
}
