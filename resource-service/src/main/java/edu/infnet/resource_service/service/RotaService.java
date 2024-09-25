package edu.infnet.resource_service.service;

import edu.infnet.resource_service.model.Rota;
import edu.infnet.resource_service.repository.RotaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RotaService implements ResourceService<Rota> {

    private final RotaRepository rotaRepository;

    @Override
    public Rota create(Rota item) {
        return rotaRepository.save(item);
    }

    @Override
    public Optional<Rota> findById(Long id) {
        return rotaRepository.findById(id);
    }

    @Override
    public List<Rota> findAll() {
        return (List<Rota>) rotaRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        rotaRepository.deleteById(id);
    }

    @Override
    public Rota update(Rota item) {
        return rotaRepository.save(item);
    }
}
