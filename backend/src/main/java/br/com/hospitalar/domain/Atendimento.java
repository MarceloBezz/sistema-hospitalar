package br.com.hospitalar.domain;

import java.time.LocalDateTime;
import java.util.Objects;

import br.com.hospitalar.domain.enums.Status;
import br.com.hospitalar.domain.exception.RegraDeNegocioException;

public class Atendimento {
    private Long id;
    private Paciente paciente;
    private Status status;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;

    public Atendimento(Paciente paciente, LocalDateTime dataInicio) {
        this.paciente = Objects.requireNonNull(paciente, "Paciente é obrigatório");
        this.dataInicio = Objects.requireNonNull(dataInicio, "Data de início é obrigatória");
        this.status = Status.EM_ANDAMENTO;
    }

    public void concluirAtendimento() {
        this.status = Status.CONCLUIDO;
        this.dataFim = LocalDateTime.now();
    }

    public void cancelarAtendimento() {
        this.status = Status.CANCELADO;
        this.dataFim = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Status getStatus() {
        return status;
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
}
