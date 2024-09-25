package edu.infnet.jogador_service.service;

import edu.infnet.jogador_service.model.Rota;
import edu.infnet.jogador_service.service.clients.RotaClient;
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
