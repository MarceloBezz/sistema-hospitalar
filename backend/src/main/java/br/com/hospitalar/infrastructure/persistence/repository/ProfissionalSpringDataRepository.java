package br.com.hospitalar.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hospitalar.infrastructure.persistence.entity.ProfissionalJpaEntity;

public interface ProfissionalSpringDataRepository extends JpaRepository<ProfissionalJpaEntity, Long> {
    
}
