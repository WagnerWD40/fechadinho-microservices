package edu.infnet.resource_service.service;

import edu.infnet.resource_service.model.Campeao;
import edu.infnet.resource_service.repository.CampeaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CampeaoService implements ResourceService<Campeao> {

    final private CampeaoRepository campeaoRepository;

    @Override
    public Campeao create(Campeao item) {
        return campeaoRepository.save(item);
    }

    @Override
    public Optional<Campeao> findById(Long id) {
        return campeaoRepository.findById(id);
    }

    @Override
    public List<Campeao> findAll() {
        return (List<Campeao>) campeaoRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        campeaoRepository.deleteById(id);
    }

    @Override
    public Campeao update(Campeao item) {
        return campeaoRepository.save(item);
    }
}
