package edu.infnet.partida_service.service.clients;

import edu.infnet.partida_service.model.Campeao;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("RESOURCE-SERVICE")
public interface CampeaoClient {

    @GetMapping("/campeao/{id}")
    Campeao findById(@PathVariable Long id);
}
