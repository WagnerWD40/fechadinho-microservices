package edu.infnet.partida_service.service.clients;

import edu.infnet.partida_service.model.JogadorResumido;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("JOGADOR-SERVICE")
public interface JogadorClient {
    @GetMapping("/jogador/{id}")
    JogadorResumido findById(@PathVariable Long id);
}
