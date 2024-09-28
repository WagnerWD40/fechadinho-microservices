package edu.infnet.partida_service.controller;

import edu.infnet.partida_service.dto.PartidaCompletaDTO;
import edu.infnet.partida_service.model.Partida;
import edu.infnet.partida_service.service.PartidaCompletaService;
import edu.infnet.partida_service.service.PartidaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class PartidaController {

    private final PartidaService partidaService;
    private final PartidaCompletaService partidaCompletaService;

    @GetMapping
    public ResponseEntity<List<Partida>> getAll() {
        return ResponseEntity.ok(partidaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Partida> getOne(@PathVariable Long id) {
        return ResponseEntity.of(partidaService.findById(id));
    }

    @GetMapping("/{id}/completo")
    public ResponseEntity<PartidaCompletaDTO> getOneCompleto(@PathVariable Long id) {
        return ResponseEntity.of(partidaCompletaService.findById(id));
    }

    @GetMapping("/{id}/relatorio")
    public ResponseEntity<String> getRelatorio(@PathVariable Long id) {
        Optional<Partida> partida = partidaService.findById(id);

        return ResponseEntity.ok().build();
    }


    @PostMapping
    public ResponseEntity<Partida> create(@RequestBody Partida partida) {
        return ResponseEntity.ok(partidaService.create(partida));
    }

    @PutMapping
    public ResponseEntity<Partida> update(@RequestBody Partida partida) {
        return ResponseEntity.ok(partidaService.update(partida));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        partidaService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
