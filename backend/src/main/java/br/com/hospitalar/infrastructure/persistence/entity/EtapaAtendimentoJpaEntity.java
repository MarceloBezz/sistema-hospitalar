package br.com.hospitalar.infrastructure.persistence.entity;

import java.time.LocalDateTime;

import br.com.hospitalar.domain.Atendimento;
import br.com.hospitalar.domain.Profissional;
import br.com.hospitalar.domain.enums.Status;
import br.com.hospitalar.domain.enums.TipoEtapaAtendimento;
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
@Table(name = "etapas_atendimentos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EtapaAtendimentoJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "atendimento_id", referencedColumnName = "id")
    private Atendimento atendimento;

    @OneToOne
    @JoinColumn(name = "profissional_id", referencedColumnName = "id")
    private Profissional profissional;

    @Enumerated(EnumType.STRING)
    private TipoEtapaAtendimento tipo;
    @Enumerated(EnumType.STRING)
    private Status status;

    private LocalDateTime dataInicio;
    private LocalDateTime dataFim; 
    private String observacao;
}
