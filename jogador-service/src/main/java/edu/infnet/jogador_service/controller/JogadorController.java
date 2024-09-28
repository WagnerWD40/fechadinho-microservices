package edu.infnet.jogador_service.controller;

import edu.infnet.jogador_service.dto.JogadorResumidoDTO;
import edu.infnet.jogador_service.model.Jogador;
import edu.infnet.jogador_service.service.JogadorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("jogador")
@RequiredArgsConstructor
public class JogadorController {
    private final JogadorService jogadorService;

    @GetMapping("/{id}")
    public ResponseEntity<JogadorResumidoDTO> getResumido(@PathVariable Long id) {
        Optional<Jogador> jogador = jogadorService.findById(id);

        return jogador.map(value -> ResponseEntity.ok(JogadorResumidoDTO.from(value)))
                    .orElseGet(() -> ResponseEntity.notFound().build());

    }

}
