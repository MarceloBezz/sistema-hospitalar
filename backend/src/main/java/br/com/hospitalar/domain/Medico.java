package br.com.hospitalar.domain;

import static br.com.hospitalar.domain.utils.ValidacoesRegex.validarCRM;

import br.com.hospitalar.domain.enums.Especialidade;
import br.com.hospitalar.domain.enums.TipoProfissional;
import br.com.hospitalar.domain.exception.RegraDeNegocioException;

public class Medico extends Profissional {
    private String crm;
    private Especialidade especialidade;

    public Medico(String nome, String crm, Especialidade especialidade) {
        super(nome, TipoProfissional.MEDICO); 
        if (crm == null || !validarCRM(crm) || especialidade == null) {
            throw new RegraDeNegocioException("Dados inválidos");
        }
        
        this.crm = crm;
        this.especialidade = especialidade;
    }

    public Medico(Long id, String nome, String crm, Especialidade especialidade) {
        super(id, nome, TipoProfissional.MEDICO);
        if (crm == null || !validarCRM(crm) || especialidade == null) {
            throw new RegraDeNegocioException("Dados inválidos");
        }
        
        this.crm = crm;
        this.especialidade = especialidade;
    }

    public String getCrm() {
        return crm;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void atualizaDados(String nome, Especialidade especialidade) {
        atualizaDados(nome, especialidade);
        if (especialidade != null) {
            this.especialidade = especialidade;
        }
    }
}
