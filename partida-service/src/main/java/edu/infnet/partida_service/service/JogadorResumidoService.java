package edu.infnet.partida_service.service;

import edu.infnet.partida_service.model.Campeao;
import edu.infnet.partida_service.model.JogadorResumido;
import edu.infnet.partida_service.service.clients.JogadorClient;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
@RequiredArgsConstructor
public class JogadorResumidoService {
    private final JogadorClient jogadorClient;
    private static Map<Long, JogadorResumido> CACHE = new ConcurrentHashMap<>();

    @CircuitBreaker(name = "jogadorService", fallbackMethod = "getFromCache")
    public JogadorResumido findById(Long id) {
        if (CACHE.containsKey(id)) {
            return CACHE.get(id);
        }

        JogadorResumido jogadorResumido = jogadorClient.findById(id);

        CACHE.put(id, jogadorResumido);

        return jogadorResumido;
    }

    public JogadorResumido getFromCache(Long id, Exception e) {
        return CACHE.getOrDefault(id, null);
    }
}
