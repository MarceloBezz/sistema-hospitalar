package br.com.hospitalar.interfaces.rest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hospitalar.application.ports.in.atendimento.BuscaAtendimentoPorIdUseCase;
import br.com.hospitalar.application.ports.in.atendimento.BuscaAtendimentosPorPacienteUseCase;
import br.com.hospitalar.application.ports.in.atendimento.CriaAtendimentoUseCase;
import br.com.hospitalar.application.ports.in.atendimento.EncerraAtendimentoUseCase;
import br.com.hospitalar.interfaces.rest.dto.atendimento.AtendimentoResponse;
import br.com.hospitalar.interfaces.rest.dto.atendimento.CriaAtendimentoRequest;
import br.com.hospitalar.interfaces.rest.mapper.AtendimentoRestMapper;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/atendimentos")
public class AtendimentoController {
    private final BuscaAtendimentoPorIdUseCase buscaAtendimentoPorIdUseCase;
    private final BuscaAtendimentosPorPacienteUseCase buscaAtendimentosPorPacienteUseCase;
    private final CriaAtendimentoUseCase criaAtendimentoUseCase;
    private final EncerraAtendimentoUseCase encerraAtendimentoUseCase;

    public AtendimentoController(BuscaAtendimentoPorIdUseCase buscaAtendimentoPorIdUseCase, BuscaAtendimentosPorPacienteUseCase buscaAtendimentosPorPacienteUseCase, CriaAtendimentoUseCase criaAtendimentoUseCase, EncerraAtendimentoUseCase encerraAtendimentoUseCase) {
        this.buscaAtendimentoPorIdUseCase = buscaAtendimentoPorIdUseCase;
        this.buscaAtendimentosPorPacienteUseCase = buscaAtendimentosPorPacienteUseCase;
        this.criaAtendimentoUseCase = criaAtendimentoUseCase;
        this.encerraAtendimentoUseCase = encerraAtendimentoUseCase;
    }

    @GetMapping("/{id}")
    public ResponseEntity<AtendimentoResponse> buscaPorId(@PathVariable Long id) {
        var response = new AtendimentoResponse(buscaAtendimentoPorIdUseCase.execute(id));
        
        return ResponseEntity.ok(response);
    }

    @GetMapping("/paciente/{idPaciente}")
    public ResponseEntity<List<AtendimentoResponse>> buscaPorPaciente(@PathVariable Long idPaciente) {
        var response = AtendimentoRestMapper.toResponseList(buscaAtendimentosPorPacienteUseCase.execute(idPaciente));

        return ResponseEntity.ok(response);
    }
    
    @PostMapping
    public ResponseEntity<AtendimentoResponse> cadastra(@RequestBody CriaAtendimentoRequest request) {
        var command = AtendimentoRestMapper.toCriaAtendimentoCommand(request.idPaciente());

        var response = new AtendimentoResponse(criaAtendimentoUseCase.execute(command));

        return ResponseEntity.created(URI.create("/atendimento/" + response.id())).body(response);
    }

    @PatchMapping("/encerrar/{id}")
    public ResponseEntity<Void> encerra(@PathVariable Long id) {
        encerraAtendimentoUseCase.execute(id);

        return ResponseEntity.ok().build();
    }
}
