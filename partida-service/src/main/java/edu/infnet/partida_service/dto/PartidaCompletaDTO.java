package edu.infnet.partida_service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import edu.infnet.partida_service.model.Equipe;
import edu.infnet.partida_service.model.Partida;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PartidaCompletaDTO {

    private Long id;

    private List<EquipeCompletaDTO> equipes = new ArrayList<>();
    private boolean vitoriaTimeAzul;

    @JsonFormat(pattern="dd/MM/yyyy")
    private LocalDate data;

    @JsonFormat(pattern="HH:mm:ss")
    private LocalTime duracao;

    public static PartidaCompletaDTO from(Partida partida, List<EquipeCompletaDTO> equipes) {
        return new PartidaCompletaDTO(
                partida.getId(),
                equipes,
                partida.isVitoriaTimeAzul(),
                partida.getData(),
                partida.getDuracao()
        );
    }
}
