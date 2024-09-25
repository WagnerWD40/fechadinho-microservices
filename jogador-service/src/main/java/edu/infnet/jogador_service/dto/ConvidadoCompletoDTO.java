package edu.infnet.jogador_service.dto;

import edu.infnet.jogador_service.model.Convidado;
import edu.infnet.jogador_service.model.Rota;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ConvidadoCompletoDTO {

    private Long id;
    private String nickname;
    private String origemContato;
    private String rankSolo;
    private Rota rota;

    static public ConvidadoCompletoDTO from(Convidado convidado, Rota rota) {
        return new ConvidadoCompletoDTO(
                convidado.getId(),
                convidado.getNickname(),
                convidado.getOrigemContato(),
                convidado.getRankSolo(),
                rota
        );
    }
}
