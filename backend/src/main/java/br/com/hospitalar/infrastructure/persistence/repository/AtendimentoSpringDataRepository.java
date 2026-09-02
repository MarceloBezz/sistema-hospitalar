package br.com.hospitalar.infrastructure.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
    
import br.com.hospitalar.infrastructure.persistence.entity.AtendimentoJpaEntity;
import br.com.hospitalar.infrastructure.persistence.entity.MedicoJpaEntity;
import br.com.hospitalar.infrastructure.persistence.entity.PacienteJpaEntity;

public interface AtendimentoSpringDataRepository extends JpaRepository<AtendimentoJpaEntity, Long> {
    List<AtendimentoJpaEntity> findByPaciente(PacienteJpaEntity paciente);
    List<AtendimentoJpaEntity> findByMedico(MedicoJpaEntity medico);

}
