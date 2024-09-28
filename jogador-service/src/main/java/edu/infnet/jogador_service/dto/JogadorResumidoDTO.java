package edu.infnet.jogador_service.dto;

import edu.infnet.jogador_service.model.Conhecido;
import edu.infnet.jogador_service.model.Convidado;
import edu.infnet.jogador_service.model.Jogador;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JogadorResumidoDTO {
    private Long id;
    private String nickname;

    public static JogadorResumidoDTO from(Jogador jogador) {
        return new JogadorResumidoDTO(jogador.getId(), jogador.getNickname());
    }
}
