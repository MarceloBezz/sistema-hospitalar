package br.com.hospitalar.infrastructure.persistence.entity;

import static jakarta.persistence.InheritanceType.JOINED;

import br.com.hospitalar.domain.enums.TipoProfissional;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "profissionais")
@Inheritance(strategy = JOINED)
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ProfissionalJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private TipoProfissional tipo;
}
