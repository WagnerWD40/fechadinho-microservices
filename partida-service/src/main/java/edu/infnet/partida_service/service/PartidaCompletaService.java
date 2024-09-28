package edu.infnet.partida_service.service;

import edu.infnet.partida_service.dto.EquipeCompletaDTO;
import edu.infnet.partida_service.dto.PartidaCompletaDTO;
import edu.infnet.partida_service.dto.PickCompletoDTO;
import edu.infnet.partida_service.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PartidaCompletaService {
    private final PartidaService partidaService;
    private final JogadorResumidoService jogadorResumidoService;
    private final CampeaoService campeaoService;
    private final RotaService rotaService;

    public Optional<PartidaCompletaDTO> findById(Long id) {
        Optional<Partida> partida = partidaService.findById(id);

        if (partida.isEmpty()) {
            return Optional.empty();
        }

        List<Equipe> equipes = partida.get().getEquipes();

        List<EquipeCompletaDTO> equipesCompletas = equipes.stream().map(equipe -> EquipeCompletaDTO.from(
                    equipe,
                    equipe.getPicks().stream().map(pick -> {
                        JogadorResumido jogador = jogadorResumidoService.findById(pick.getJogadorId());
                        Campeao campeao = campeaoService.findById(pick.getCampeaoId());
                        Rota rota = rotaService.findById(pick.getRotaId());
                        return PickCompletoDTO.from(pick, jogador, campeao, rota);
                    }).toList())
        ).toList();

        return Optional.of(PartidaCompletaDTO.from(partida.get(), equipesCompletas));
    }


}
