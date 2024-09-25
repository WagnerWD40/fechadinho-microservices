package edu.infnet.partida_service.service;

import edu.infnet.partida_service.model.Equipe;
import edu.infnet.partida_service.repository.EquipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EquipeService implements ResourceService<Equipe> {

    private final EquipeRepository equipeRepository;

    @Override
    public Equipe create(Equipe item) {
        return equipeRepository.save(item);
    }

    @Override
    public Optional<Equipe> findById(Long id) {
        return equipeRepository.findById(id);
    }

    @Override
    public List<Equipe> findAll() {
        return (List<Equipe>) equipeRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        equipeRepository.deleteById(id);
    }

    @Override
    public Equipe update(Equipe item) {
        return equipeRepository.save(item);
    }
}
