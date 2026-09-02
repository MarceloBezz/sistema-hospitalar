package br.com.hospitalar.infrastructure.persistence.mapper;

import br.com.hospitalar.domain.valueobjects.Endereco;
import br.com.hospitalar.infrastructure.persistence.entity.EnderecoJpa;

public class EnderecoMapper {
    public static EnderecoJpa toEntity(Endereco endereco) {
        return new EnderecoJpa(
            endereco.logradouro(),
            endereco.numero(),
            endereco.complemento(),
            endereco.bairro(),
            endereco.cidade(),
            endereco.estado(),
            endereco.cep()
        );
    }

    public static Endereco toDomain(EnderecoJpa enderecoJpa) {
        return new Endereco(
            enderecoJpa.getLogradouro(),
            enderecoJpa.getNumero(),
            enderecoJpa.getComplemento(),
            enderecoJpa.getBairro(),
            enderecoJpa.getCidade(),
            enderecoJpa.getEstado(),
            enderecoJpa.getCep()
        );
    }
}
