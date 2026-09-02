package br.com.hospitalar.infrastructure.persistence.entity;

import static br.com.hospitalar.domain.enums.TipoProfissional.MEDICO;
import static jakarta.persistence.EnumType.STRING;

import br.com.hospitalar.domain.enums.Especialidade;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "medicos")
@Getter
@NoArgsConstructor
public class MedicoJpaEntity extends ProfissionalJpaEntity {
    private String crm;
    @Enumerated(STRING)
    private Especialidade especialidade;
    
    public MedicoJpaEntity(Long id, String nome, String crm, Especialidade especialidade) {
        super(id, nome, MEDICO);
        this.crm = crm;
        this.especialidade = especialidade;
    }
}
