package br.com.hospitalar.infrastructure.persistence.entity;

import java.time.LocalDate;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pacientes")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PacienteJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private EnderecoJpa endereco;
    private String nome;
    private String cpf;
    private String telefone;
    private LocalDate dataNascimento;
    private String email;
}
