package edu.infnet.partida_service.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import edu.infnet.partida_service.dto.PartidaCompletaDTO;
import edu.infnet.partida_service.service.rabbit.RelatorioProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RelatorioService {

    private final RelatorioProducer relatorioProducer;
    private final PartidaCompletaService partidaCompletaService;

    public void emitir(Long id) throws JsonProcessingException {
        Optional<PartidaCompletaDTO> partida = partidaCompletaService.findById(id);

        if (partida.isEmpty()) {
            throw new RuntimeException("Partida inexistente");
        }

        relatorioProducer.send(partida.get());
    }

}
