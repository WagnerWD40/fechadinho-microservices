package edu.infnet.partida_service.service.rabbit;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import edu.infnet.partida_service.dto.PartidaCompletaDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RelatorioProducer {
    private final AmqpTemplate amqpTemplate;
    private final ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());

    private final String EXCHANGE = "relatorio-exc";
    private final String ROUTING_KEY = "relatorio-rk";

    public void send(PartidaCompletaDTO partidaCompletaDTO) throws JsonProcessingException {
        amqpTemplate.convertAndSend(EXCHANGE, ROUTING_KEY, objectMapper.writeValueAsString(partidaCompletaDTO));
    }

}
