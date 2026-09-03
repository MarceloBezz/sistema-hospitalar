package br.com.hospitalar.interfaces.rest.dto.paciente;

public record AtualizaEnderecoRequest(
    String logradouro,
    String numero,
    String complemento,
    String bairro,
    String cidade,
    String estado,
    String cep
) {
}