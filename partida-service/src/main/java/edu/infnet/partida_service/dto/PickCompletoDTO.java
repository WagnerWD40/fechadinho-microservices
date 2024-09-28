package edu.infnet.partida_service.dto;

import edu.infnet.partida_service.model.Campeao;
import edu.infnet.partida_service.model.JogadorResumido;
import edu.infnet.partida_service.model.Pick;
import edu.infnet.partida_service.model.Rota;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PickCompletoDTO {
    private Long id;

    private JogadorResumido jogador;
    private Campeao campeao;
    private Rota rota;

    private Integer abates;
    private Integer mortes;
    private Integer assistencias;
    private Integer danoCausado;
    private Integer danoRecebido;
    private Integer gold;
    private Integer cs;

    public static PickCompletoDTO from(Pick pick, JogadorResumido jogador, Campeao campeao, Rota rota) {
        return new PickCompletoDTO(
                pick.getId(),
                jogador,
                campeao,
                rota,
                pick.getAbates(),
                pick.getMortes(),
                pick.getAssistencias(),
                pick.getDanoCausado(),
                pick.getDanoRecebido(),
                pick.getGold(),
                pick.getCs()
        );
    }
}
