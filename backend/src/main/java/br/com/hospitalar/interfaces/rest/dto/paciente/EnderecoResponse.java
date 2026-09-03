package br.com.hospitalar.interfaces.rest.dto.paciente;

import br.com.hospitalar.domain.valueobjects.Endereco;

public record EnderecoResponse(
        String logradouro,
        String numero,
        String complemento,
        String bairro,
        String cidade,
        String estado,
        String cep) {
    public EnderecoResponse(Endereco endereco) {
        this(
            endereco.logradouro(),
            endereco.numero(),
            endereco.complemento(),
            endereco.bairro(),
            endereco.cidade(),
            endereco.estado(),
            endereco.cep()
        );
    }
}
