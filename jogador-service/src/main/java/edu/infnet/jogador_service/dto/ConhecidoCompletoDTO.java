package edu.infnet.jogador_service.dto;

import edu.infnet.jogador_service.model.Conhecido;
import edu.infnet.jogador_service.model.Rota;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ConhecidoCompletoDTO {

    private Long id;
    private String nickname;
    private String nome;
    private String discord;
    private String whatsapp;
    private Rota rota;

    static public ConhecidoCompletoDTO from(Conhecido conhecido, Rota rota) {
        return new ConhecidoCompletoDTO(
                conhecido.getId(),
                conhecido.getNickname(),
                conhecido.getNome(),
                conhecido.getDiscord(),
                conhecido.getWhatsapp(),
                rota
        );
    }
}
