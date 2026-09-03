package br.com.hospitalar.interfaces.rest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hospitalar.application.ports.in.paciente.AtualizaPacienteUseCase;
import br.com.hospitalar.application.ports.in.paciente.ConsultaPacienteUseCase;
import br.com.hospitalar.application.ports.in.paciente.CriaPacienteUseCase;
import br.com.hospitalar.application.usecase.paciente.AtualizaPacienteCommand;
import br.com.hospitalar.application.usecase.paciente.CriaPacienteCommand;
import br.com.hospitalar.domain.valueobjects.Endereco;
import br.com.hospitalar.interfaces.rest.dto.paciente.AtualizaPacienteRequest;
import br.com.hospitalar.interfaces.rest.dto.paciente.CriarPacienteRequest;
import br.com.hospitalar.interfaces.rest.dto.paciente.PacienteResponse;
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
        var command = new CriaPacienteCommand(
                request.nome(),
                request.cpf(),
                request.telefone(),
                request.email(), 
                request.dataNascimento(), 
                request.endereco());

        PacienteResponse paciente = new PacienteResponse(criaPacienteUseCase.execute(command));

        return ResponseEntity.created(URI.create("/pacientes/" + paciente.id())).body(paciente);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteResponse> buscarPorId(@PathVariable String cpf) {
        PacienteResponse paciente = new PacienteResponse(consultaPacienteUseCase.execute(cpf));
        return ResponseEntity.ok(paciente);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<PacienteResponse> atualizar(@PathVariable Long id, @RequestBody AtualizaPacienteRequest request) {
        Endereco endereco = null;
        if (request.endereco() != null) {
            endereco = new Endereco(
                request.endereco().logradouro(),
                request.endereco().numero(),
                request.endereco().complemento(),
                request.endereco().bairro(),
                request.endereco().cidade(),
                request.endereco().estado(),
                request.endereco().cep()
            );
        }
        var command = new AtualizaPacienteCommand(
            request.nome(),
            request.telefone(),
            request.email(),
            endereco
        );
        PacienteResponse paciente = new PacienteResponse(atualizaPacienteUseCase.execute(id, command));
        
        return ResponseEntity.ok(paciente);
    }
}
