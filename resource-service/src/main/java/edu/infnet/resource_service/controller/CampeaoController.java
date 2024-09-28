package edu.infnet.resource_service.controller;

import edu.infnet.resource_service.model.Campeao;
import edu.infnet.resource_service.service.CampeaoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/campeao")
@RequiredArgsConstructor
@Slf4j
public class CampeaoController {

    private final CampeaoService campeaoService;

    @GetMapping
    public ResponseEntity<List<Campeao>> getAll() {
        return ResponseEntity.ok(campeaoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id) {
        log.info("Getting Campeao ID: {}", id);
        return ResponseEntity.of(campeaoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Campeao> create(@RequestBody Campeao campeao) {
        return ResponseEntity.ok(campeaoService.create(campeao));
    }

    @PutMapping
    public ResponseEntity<Campeao> update(@RequestBody Campeao campeao) {
        return ResponseEntity.ok(campeaoService.update(campeao));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        campeaoService.delete(id);

        return ResponseEntity.noContent().build();
    }

}
