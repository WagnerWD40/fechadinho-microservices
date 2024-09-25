package edu.infnet.resource_service.controller;

import edu.infnet.resource_service.model.Rota;
import edu.infnet.resource_service.service.RotaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rota")
@RequiredArgsConstructor
public class RotaController {

    private final RotaService rotaService;

    @GetMapping
    public ResponseEntity<List<Rota>> getAll() {
        return ResponseEntity.ok(rotaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id) {
        return ResponseEntity.of(rotaService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Rota> create(@RequestBody Rota rota) {
        return ResponseEntity.ok(rotaService.create(rota));
    }

    @PutMapping
    public ResponseEntity<Rota> update(@RequestBody Rota rota) {
        return ResponseEntity.ok(rotaService.update(rota));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        rotaService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
