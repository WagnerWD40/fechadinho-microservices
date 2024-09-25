package edu.infnet.partida_service.service.clients;

import edu.infnet.partida_service.model.Rota;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("RESOURCE-SERVICE")
public interface RotaClient {

    @GetMapping("/rota/{id}")
    Rota findById(@PathVariable Long id);
}
