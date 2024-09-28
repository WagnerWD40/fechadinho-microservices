package edu.infnet.partida_service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import edu.infnet.partida_service.model.Equipe;
import edu.infnet.partida_service.model.Pick;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
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
public class EquipeCompletaDTO {

    private Long id;

    private List<PickCompletoDTO> picks = new ArrayList<>();

    private String side;
    private Integer dragao;
    private Integer barao;
    private Integer herald;
    private Integer grub;
    private Integer torre;
    private Integer inibidor;

    public static EquipeCompletaDTO from(Equipe equipe, List<PickCompletoDTO> picks) {
        return new EquipeCompletaDTO(
                equipe.getId(),
                picks,
                equipe.getSide(),
                equipe.getDragao(),
                equipe.getBarao(),
                equipe.getHerald(),
                equipe.getGrub(),
                equipe.getTorre(),
                equipe.getInibidor()
        );

    }
}
