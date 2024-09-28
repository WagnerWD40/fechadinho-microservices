package edu.infnet.jogador_service.service;

import edu.infnet.jogador_service.model.Rota;
import edu.infnet.jogador_service.service.clients.RotaClient;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Service
@RequiredArgsConstructor
public class RotaService {

    private final RotaClient rotaClient;
    private static Map<Long, Rota> CACHE = new ConcurrentHashMap<>();

    @CircuitBreaker(name = "resourceService", fallbackMethod = "getFromCache")
    public Rota findById(Long id) {

        if (CACHE.containsKey(id)) {
            return CACHE.get(id);
        }

        Rota rota = rotaClient.findById(id);

        CACHE.put(id, rota);

        return rota;
    }

    private Rota getFromCache(Long id) {
        return CACHE.getOrDefault(id, null);
    }
}
