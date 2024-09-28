package edu.infnet.partida_service.service;

import edu.infnet.partida_service.model.Partida;
import edu.infnet.partida_service.repository.PartidaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PartidaService implements ResourceService<Partida> {

    private final PartidaRepository partidaRepository;

    @Override
    public Partida create(Partida item) {
        return partidaRepository.save(item);
    }

    @Override
    public Optional<Partida> findById(Long id) {
        return partidaRepository.findById(id);
    }

    @Override
    public List<Partida> findAll() {
        return (List<Partida>) partidaRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        partidaRepository.deleteById(id);
    }

    @Override
    public Partida update(Partida item) {
        return partidaRepository.save(item);
    }

    public void createRelatorio(Long id) {

    }
}
