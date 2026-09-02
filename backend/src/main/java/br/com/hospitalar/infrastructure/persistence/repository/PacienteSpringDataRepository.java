package br.com.hospitalar.infrastructure.persistence.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hospitalar.infrastructure.persistence.entity.PacienteJpaEntity;

public interface PacienteSpringDataRepository extends JpaRepository<PacienteJpaEntity, Long> {
    Optional<PacienteJpaEntity> findByCpf(String cpf);

    boolean existsByCpf(String cpf);
}
