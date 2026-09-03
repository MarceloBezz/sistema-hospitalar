package br.com.hospitalar.interfaces.rest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hospitalar.application.ports.in.profissional.AtualizaProfissionalUseCase;
import br.com.hospitalar.application.ports.in.profissional.BuscaProfissionalUseCase;
import br.com.hospitalar.application.ports.in.profissional.CriaProfissionalUseCase;
import br.com.hospitalar.application.ports.in.profissional.DeletaProfissionalUseCase;
import br.com.hospitalar.interfaces.rest.dto.profissional.AtualizaProfissionalRequest;
import br.com.hospitalar.interfaces.rest.dto.profissional.CriaProfissionalRequest;
import br.com.hospitalar.interfaces.rest.dto.profissional.ProfissionalResponse;
import br.com.hospitalar.interfaces.rest.mapper.ProfissionalRestMapper;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/profissionais")
public class ProfissionalController {
    private final AtualizaProfissionalUseCase atualizaProfissionalUseCase;
    private final BuscaProfissionalUseCase buscaProfissionalUseCase;
    private final CriaProfissionalUseCase criaProfissionalUseCase;
    private final DeletaProfissionalUseCase deletaProfissionalUseCase;

    public ProfissionalController(AtualizaProfissionalUseCase atualizaProfissionalUseCase, BuscaProfissionalUseCase buscaProfissionalUseCase, CriaProfissionalUseCase criaProfissionalUseCase, DeletaProfissionalUseCase deletaProfissionalUseCase) {
        this.atualizaProfissionalUseCase = atualizaProfissionalUseCase;
        this.buscaProfissionalUseCase = buscaProfissionalUseCase;
        this.criaProfissionalUseCase = criaProfissionalUseCase;
        this.deletaProfissionalUseCase = deletaProfissionalUseCase;
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfissionalResponse> atualiza(@PathVariable Long id, @RequestBody AtualizaProfissionalRequest request) {
        var command = ProfissionalRestMapper.toAtualizaProfissionalCommand(request);
        
        var response = new ProfissionalResponse(atualizaProfissionalUseCase.execute(id, command));
        
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfissionalResponse> buscaPorId(@PathVariable Long id) {
        var response = new ProfissionalResponse(buscaProfissionalUseCase.execute(id));

        return ResponseEntity.ok(response);
    }
    
    @PostMapping
    public ResponseEntity<ProfissionalResponse> cadastra(@RequestBody CriaProfissionalRequest request) {
        var command = ProfissionalRestMapper.toCriaProfissionalCommand(request);

        var response = new ProfissionalResponse(criaProfissionalUseCase.execute(command));

        return ResponseEntity.created(URI.create("/profissionais/" + response.id())).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleta(@PathVariable Long id) {
        deletaProfissionalUseCase.execute(id);

        return ResponseEntity.noContent().build();
    }
}
