package edu.infnet.partida_service.service;

import edu.infnet.partida_service.model.Campeao;
import edu.infnet.partida_service.model.Rota;
import edu.infnet.partida_service.service.clients.RotaClient;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

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

    private Rota getFromCache(Long id, Exception e) {
        return CACHE.getOrDefault(id, null);
    }
}
