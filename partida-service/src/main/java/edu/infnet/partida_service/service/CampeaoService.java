package edu.infnet.partida_service.service;

import edu.infnet.partida_service.model.Campeao;
import edu.infnet.partida_service.model.Rota;
import edu.infnet.partida_service.service.clients.CampeaoClient;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
@RequiredArgsConstructor
public class CampeaoService {

    private final CampeaoClient campeaoClient;
    private static Map<Long, Campeao> CACHE = new ConcurrentHashMap<>();

    @CircuitBreaker(name = "resourceService", fallbackMethod = "getFromCache")
    public Campeao findById(Long id) {

        if (CACHE.containsKey(id)) {
            return CACHE.get(id);
        }

        Campeao campeao = campeaoClient.findById(id);

        CACHE.put(id, campeao);

        return campeao;
    }

    public Campeao getFromCache(Long id, Exception e) {
        return CACHE.getOrDefault(id, null);
    }
}
