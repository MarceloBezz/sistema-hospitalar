package br.com.hospitalar.infrastructure.persistence.entity;

import java.time.LocalDateTime;

import br.com.hospitalar.domain.Paciente;
import br.com.hospitalar.domain.enums.Status;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "atendimentos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AtendimentoJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "paciente_id", referencedColumnName = "id")
    private Paciente paciente;
    
    @Enumerated(EnumType.STRING)
    private Status status;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
}
