package br.com.hospitalar.domain;

import java.time.LocalDateTime;
import java.util.Objects;

import br.com.hospitalar.domain.enums.Status;
import br.com.hospitalar.domain.enums.TipoEtapaAtendimento;
import br.com.hospitalar.domain.exception.RegraDeNegocioException;

public class EtapaAtendimento {
    private Long id;
    private Atendimento atendimento;
    private Profissional profissional;
    private TipoEtapaAtendimento tipo;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    private Status status;
    private String observacao;

    public EtapaAtendimento(Atendimento atendimento, Profissional profissional, TipoEtapaAtendimento tipo, LocalDateTime dataInicio) {
        this.atendimento = Objects.requireNonNull(atendimento, "Atendimento não pode ser nulo");
        this.profissional = Objects.requireNonNull(profissional, "Profissional não pode ser nulo");
        this.tipo = Objects.requireNonNull(tipo, "Tipo não pode ser nulo");
        this.dataInicio = Objects.requireNonNull(dataInicio, "Data de início não pode ser nula");
        this.status = Status.EM_ANDAMENTO;
    }

    public TipoEtapaAtendimento encaminharProximaEtapa(TipoEtapaAtendimento proximaEtapa, String observacao) {
        concluirEtapa(observacao);

        switch (this.tipo) {
            case RECEPCAO:
                return TipoEtapaAtendimento.PRE_ATENDIMENTO;
            case PRE_ATENDIMENTO:
                return TipoEtapaAtendimento.CLINICO;
            case CLINICO:
                if (proximaEtapa != null && 
                    (proximaEtapa == TipoEtapaAtendimento.MEDICACAO || proximaEtapa == TipoEtapaAtendimento.EXAME)) {
                    return proximaEtapa;
                } else {
                    throw new RegraDeNegocioException("Próxima etapa inválida para o tipo CLINICO: " + proximaEtapa);
                }
            case MEDICACAO:
                if (proximaEtapa != null && 
                    (proximaEtapa == TipoEtapaAtendimento.CLINICO || proximaEtapa == TipoEtapaAtendimento.EXAME)) {
                    return proximaEtapa;
                } else {
                    throw new RegraDeNegocioException("Próxima etapa inválida para o tipo MEDICAÇÃO: " + proximaEtapa);
                }
            case EXAME:
                if (proximaEtapa != null && 
                    (proximaEtapa == TipoEtapaAtendimento.MEDICACAO || proximaEtapa == TipoEtapaAtendimento.CLINICO)) {
                    return proximaEtapa;
                } else {
                    throw new RegraDeNegocioException("Próxima etapa inválida para o tipo EXAME: " + proximaEtapa);
                }
            default:
                throw new IllegalStateException("Tipo de etapa desconhecido: " + this.tipo);
        }
    }

    public void concluirEtapa(String observacao) {
        this.status = Status.CONCLUIDO;
        this.dataFim = LocalDateTime.now();
        this.observacao = observacao;
    }

    public void cancelarEtapa(String observacao) {
        this.status = Status.CANCELADO;
        this.dataFim = LocalDateTime.now();
        this.observacao = observacao;
    }

    public Long getId() {
        return id;
    }

    public Atendimento getAtendimento() {
        return atendimento;
    }

    public Profissional getProfissional() {
        return profissional;
    }

    public TipoEtapaAtendimento getTipo() {
        return tipo;
    }

    public LocalDateTime getDataInicio() {
        return dataInicio;
    }

    public LocalDateTime getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDateTime dataFim) {
        if (dataFim != null && dataFim.isBefore(dataInicio)) {
            throw new RegraDeNegocioException("Data de fim não pode ser anterior à data de início");
        }
        this.dataFim = dataFim;
    }

    public Status getStatus() {
        return status;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}
