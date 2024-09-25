package edu.infnet.partida_service.service;

import edu.infnet.partida_service.model.Campeao;
import edu.infnet.partida_service.model.Rota;
import edu.infnet.partida_service.service.clients.RotaClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RotaService {

    private final RotaClient rotaClient;

    public Rota findById(Long id) {
        return rotaClient.findById(id);
    }
}
