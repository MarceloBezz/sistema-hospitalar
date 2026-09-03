package br.com.hospitalar.interfaces.rest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hospitalar.application.ports.in.medico.AtualizaMedicoUseCase;
import br.com.hospitalar.application.ports.in.medico.BuscaMedicoUseCase;
import br.com.hospitalar.application.ports.in.medico.CadastraMedicoUseCase;
import br.com.hospitalar.application.ports.in.medico.DeletaMedicoUseCase;
import br.com.hospitalar.interfaces.rest.dto.medico.AtualizaMedicoRequest;
import br.com.hospitalar.interfaces.rest.dto.medico.CadastraMedicoRequest;
import br.com.hospitalar.interfaces.rest.dto.medico.MedicoResponse;
import br.com.hospitalar.interfaces.rest.mapper.MedicoRestMapper;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;




@RestController
@RequestMapping("/medicos")
public class MedicoController {
    private final AtualizaMedicoUseCase atualizaMedicoUseCase;
    private final BuscaMedicoUseCase buscaMedicoUseCase;
    private final CadastraMedicoUseCase cadastraMedicoUseCase;
    private final DeletaMedicoUseCase deletaMedicoUseCase;

    public MedicoController(AtualizaMedicoUseCase atualizaMedicoUseCase, BuscaMedicoUseCase buscaMedicoUseCase, CadastraMedicoUseCase cadastraMedicoUseCase, DeletaMedicoUseCase deletaMedicoUseCase) {
        this.atualizaMedicoUseCase = atualizaMedicoUseCase;
        this.buscaMedicoUseCase = buscaMedicoUseCase;
        this.cadastraMedicoUseCase = cadastraMedicoUseCase;
        this.deletaMedicoUseCase = deletaMedicoUseCase;
    }

    @PutMapping("/{id}")
    public ResponseEntity<MedicoResponse> atualiza(@PathVariable Long id, @RequestBody AtualizaMedicoRequest request) {
        var command = MedicoRestMapper.toAtualizaMedicoCommand(request);

        var response = new MedicoResponse(atualizaMedicoUseCase.execute(id, command));
        
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicoResponse> buscarEntity(@RequestParam Long id) {
        var response = new MedicoResponse(buscaMedicoUseCase.execute(id));

        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<MedicoResponse> cadastra(@RequestBody CadastraMedicoRequest request) {
        var command = MedicoRestMapper.toCadastraMedicoCommand(request);

        var response = new MedicoResponse(cadastraMedicoUseCase.execute(command));
        
        return ResponseEntity.created(URI.create("/medicos/" + response.id())).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleta(@PathVariable Long id) {
        deletaMedicoUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
    
}
