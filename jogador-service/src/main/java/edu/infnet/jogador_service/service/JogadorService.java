package edu.infnet.jogador_service.service;

import edu.infnet.jogador_service.model.Jogador;
import edu.infnet.jogador_service.repository.JogadorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JogadorService {
    private final JogadorRepository jogadorRepository;

    public Optional<Jogador> findById(Long id) {
        return jogadorRepository.findById(id);
    }
}
