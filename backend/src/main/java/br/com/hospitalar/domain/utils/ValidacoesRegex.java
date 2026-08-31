package br.com.hospitalar.domain.utils;

public class ValidacoesRegex {
    public static final String REGEX_CPF = "^(\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2})$";
    public static final String REGEX_TELEFONE = "^(\\(\\d{2}\\)\\s\\d{4,5}\\-\\d{4})$";
    public static final String REGEX_EMAIL = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
    public static final String REGEX_CEP = "^(\\d{5}\\-\\d{3})$";
    public static final String REGEX_CRM = "^(\\d{4,6})$";
    public static final String REGEX_NOME = "^[A-Za-zÀ-ÿ\\s]+$";
    public static final String REGEX_NUMERO = "^(\\d+)$";
    
    public static boolean validarCPF(String cpf) {
        return cpf.matches(REGEX_CPF);
    }

    public static boolean validarTelefone(String telefone) {
        return telefone.matches(REGEX_TELEFONE);
    }

    public static boolean validarEmail(String email) {
        return email.matches(REGEX_EMAIL);
    }

    public static boolean validarCEP(String cep) {
        return cep.matches(REGEX_CEP);
    }

    public static boolean validarCRM(String crm) {
        return crm.matches(REGEX_CRM);
    }

    public static boolean validarNome(String nome) {
        return nome.matches(REGEX_NOME);
    }

    public static boolean validarNumero(String numero) {
        return numero.matches(REGEX_NUMERO);
    }
}
