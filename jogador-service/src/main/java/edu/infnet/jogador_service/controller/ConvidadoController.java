package edu.infnet.jogador_service.controller;

import edu.infnet.jogador_service.dto.ConhecidoCompletoDTO;
import edu.infnet.jogador_service.dto.ConvidadoCompletoDTO;
import edu.infnet.jogador_service.model.Convidado;
import edu.infnet.jogador_service.service.ConvidadoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/convidado")
@RequiredArgsConstructor
@Slf4j
public class ConvidadoController {

    public final ConvidadoService convidadoService;

    @GetMapping
    public ResponseEntity<List<Convidado>> getAll() {
        return ResponseEntity.ok(convidadoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Convidado> getOne(@PathVariable Long id) {
        return ResponseEntity.of(convidadoService.findById(id));
    }

    @GetMapping("/{id}/completo")
    public ResponseEntity<ConvidadoCompletoDTO> getCompleto(@PathVariable Long id) {
        log.info("Getting Convidado Completo ID: {}", id);
        return ResponseEntity.of(convidadoService.findCompleto(id));
    }

    @PostMapping
    public ResponseEntity<Convidado> create(@RequestBody Convidado convidado) {
        return ResponseEntity.ok(convidadoService.create(convidado));
    }

    @PutMapping
    public ResponseEntity<Convidado> update(@RequestBody Convidado convidado) {
        return ResponseEntity.ok(convidadoService.update(convidado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        convidadoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
