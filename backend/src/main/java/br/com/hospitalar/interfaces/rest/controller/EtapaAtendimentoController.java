package br.com.hospitalar.interfaces.rest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hospitalar.application.ports.in.etapaAtendimento.BuscaEtapaAtendimentoUseCase;
import br.com.hospitalar.application.ports.in.etapaAtendimento.BuscaEtapasPorAtendimentoUseCase;
import br.com.hospitalar.application.ports.in.etapaAtendimento.CriaEtapaAtendimentoUseCase;
import br.com.hospitalar.interfaces.rest.dto.etapaAtendimento.CriaEtapaAtendimentoRequest;
import br.com.hospitalar.interfaces.rest.dto.etapaAtendimento.EtapaAtendimentoResponse;
import br.com.hospitalar.interfaces.rest.mapper.EtapaAtendimentoMapper;
import jakarta.validation.Valid;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/etapas-atendimento")
public class EtapaAtendimentoController {
    private final BuscaEtapaAtendimentoUseCase buscaEtapasAtendimentoUseCase;
    private final BuscaEtapasPorAtendimentoUseCase buscaEtapasPorAtendimentoUseCase;
    private final CriaEtapaAtendimentoUseCase criaEtapaAtendimentoUseCase;

    public EtapaAtendimentoController(BuscaEtapaAtendimentoUseCase buscaEtapasAtendimentoUseCase,
            BuscaEtapasPorAtendimentoUseCase buscaEtapasPorAtendimentoUseCase,
            CriaEtapaAtendimentoUseCase criaEtapaAtendimentoUseCase) {
        this.buscaEtapasAtendimentoUseCase = buscaEtapasAtendimentoUseCase;
        this.buscaEtapasPorAtendimentoUseCase = buscaEtapasPorAtendimentoUseCase;
        this.criaEtapaAtendimentoUseCase = criaEtapaAtendimentoUseCase;
    }

    @GetMapping("/{id}")
    public ResponseEntity<EtapaAtendimentoResponse> buscaPorId(@PathVariable Long id) {
        var response = new EtapaAtendimentoResponse(buscaEtapasAtendimentoUseCase.execute(id));

        return ResponseEntity.ok(response);
    }

    @GetMapping("/atendimento/{idAtendimento}")
    public ResponseEntity<List<EtapaAtendimentoResponse>> buscaEtapasPorAtendimento(@PathVariable Long idAtendimento) {
        var response = EtapaAtendimentoMapper
                .toResponseList(buscaEtapasPorAtendimentoUseCase.execute(idAtendimento));

        return ResponseEntity.ok(response);
    }

    @PostMapping("path")
    public ResponseEntity<EtapaAtendimentoResponse> criaEtapaAtendimento(
            @RequestBody @Valid CriaEtapaAtendimentoRequest request) {
        var command = EtapaAtendimentoMapper.toCommand(request);

        var response = new EtapaAtendimentoResponse(criaEtapaAtendimentoUseCase.execute(command));

        return ResponseEntity
                .created(URI.create("/etapas-atendimento/" + response.id()))
                .body(response);
    }

}
