package br.com.hospitalar.domain.object_values;

public record Endereco(
        Long id,
        String logradouro,
        String numero,
        String complemento,
        String bairro,
        String cidade,
        String estado,
        String cep) {
}