package edu.infnet.partida_service.service.clients;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("JOGADOR-SERVICE")
public interface JogadorClient {
    // TODO - impl
}
