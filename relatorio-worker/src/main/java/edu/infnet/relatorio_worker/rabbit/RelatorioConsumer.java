package edu.infnet.relatorio_worker.rabbit;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RelatorioConsumer {

    private final String QUEUE = "relatorio-queue";

    @RabbitListener(queues = { QUEUE })
    public void receive(@Payload String message) {
        log.info("RelatorioWorker received: {}", message);

        // TODO - criar PDF

        // TODO - enviar por email
    }
}
