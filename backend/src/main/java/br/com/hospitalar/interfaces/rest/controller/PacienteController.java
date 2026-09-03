package br.com.hospitalar.interfaces.rest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hospitalar.application.ports.in.paciente.AtualizaPacienteUseCase;
import br.com.hospitalar.application.ports.in.paciente.ConsultaPacienteUseCase;
import br.com.hospitalar.application.ports.in.paciente.CriaPacienteUseCase;
import br.com.hospitalar.interfaces.rest.dto.paciente.AtualizaPacienteRequest;
import br.com.hospitalar.interfaces.rest.dto.paciente.CriarPacienteRequest;
import br.com.hospitalar.interfaces.rest.dto.paciente.PacienteResponse;
import br.com.hospitalar.interfaces.rest.mapper.PacienteRestMapper;
import jakarta.validation.Valid;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    private final CriaPacienteUseCase criaPacienteUseCase;
    private final ConsultaPacienteUseCase consultaPacienteUseCase;
    private final AtualizaPacienteUseCase atualizaPacienteUseCase;

    public PacienteController(CriaPacienteUseCase criaPacienteUseCase, ConsultaPacienteUseCase consultaPacienteUseCase, AtualizaPacienteUseCase atualizaPacienteUseCase) {
        this.criaPacienteUseCase = criaPacienteUseCase;
        this.consultaPacienteUseCase = consultaPacienteUseCase;
        this.atualizaPacienteUseCase = atualizaPacienteUseCase;
    }

    @PostMapping
    public ResponseEntity<PacienteResponse> cadastrarPaciente(@RequestBody @Valid CriarPacienteRequest request) {
        var command = PacienteRestMapper.toCriaPacienteCommand(request);

        PacienteResponse paciente = new PacienteResponse(criaPacienteUseCase.execute(command));

        return ResponseEntity.created(URI.create("/pacientes/" + paciente.id())).body(paciente);
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<PacienteResponse> buscarPorCpf(@PathVariable String cpf) {
        PacienteResponse paciente = new PacienteResponse(consultaPacienteUseCase.execute(cpf));
        return ResponseEntity.ok(paciente);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<PacienteResponse> atualizar(@PathVariable Long id, @RequestBody AtualizaPacienteRequest request) {
        var command = PacienteRestMapper.toAtualizaPacienteCommand(request);
        
        PacienteResponse paciente = new PacienteResponse(atualizaPacienteUseCase.execute(id, command));
        
        return ResponseEntity.ok(paciente);
    }
}
