package edu.infnet.partida_service.service;

import edu.infnet.partida_service.model.Campeao;
import edu.infnet.partida_service.service.clients.CampeaoClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CampeaoService {

    private final CampeaoClient campeaoClient;

    public Campeao findById(Long id) {
        return campeaoClient.findById(id);
    }
}
