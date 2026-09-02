package br.com.hospitalar.infrastructure.persistence.mapper;

import br.com.hospitalar.domain.Paciente;
import br.com.hospitalar.infrastructure.persistence.entity.PacienteJpaEntity;

public class PacienteMapper {
    public static PacienteJpaEntity toEntity(Paciente paciente) {
        return new PacienteJpaEntity(
                paciente.getId(),
                EnderecoMapper.toEntity(paciente.getEndereco()),
                paciente.getNome(),
                paciente.getCpf(),
                paciente.getTelefone(),
                paciente.getDataNascimento(),
                paciente.getEmail());
    }

    public static Paciente toDomain(PacienteJpaEntity pacienteJpaEntity) {
        return new Paciente(
                pacienteJpaEntity.getId(),
                EnderecoMapper.toDomain(pacienteJpaEntity.getEndereco()),
                pacienteJpaEntity.getNome(),
                pacienteJpaEntity.getCpf(),
                pacienteJpaEntity.getTelefone(),
                pacienteJpaEntity.getDataNascimento(),
                pacienteJpaEntity.getEmail());
    }
}
