package edu.infnet.jogador_service.controller;

import edu.infnet.jogador_service.dto.ConhecidoCompletoDTO;
import edu.infnet.jogador_service.model.Conhecido;
import edu.infnet.jogador_service.service.ConhecidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conhecido")
@RequiredArgsConstructor
public class ConhecidoController {

    private final ConhecidoService conhecidoService;

    @GetMapping
    public ResponseEntity<List<Conhecido>> getAll() {
        return ResponseEntity.ok(conhecidoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Conhecido> getOne(@PathVariable Long id) {
        return ResponseEntity.of(conhecidoService.findById(id));
    }

    @GetMapping("/{id}/completo")
    public ResponseEntity<ConhecidoCompletoDTO> getCompleto(@PathVariable Long id) {
        return ResponseEntity.of(conhecidoService.findCompleto(id));
    }

    @PostMapping
    public ResponseEntity<Conhecido> create(@RequestBody Conhecido conhecido) {
        return ResponseEntity.ok(conhecidoService.create(conhecido));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Conhecido> update(@RequestBody Conhecido conhecido) {
        return ResponseEntity.ok(conhecidoService.update(conhecido));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        conhecidoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
