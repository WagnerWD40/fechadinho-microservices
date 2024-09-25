package edu.infnet.partida_service.service;

import edu.infnet.partida_service.model.Pick;
import edu.infnet.partida_service.repository.PickRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PickService implements ResourceService<Pick> {

    private final PickRepository pickRepository;

    @Override
    public Pick create(Pick item) {
        return pickRepository.save(item);
    }

    @Override
    public Optional<Pick> findById(Long id) {
        return pickRepository.findById(id);
    }

    @Override
    public List<Pick> findAll() {
        return (List<Pick>) pickRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        pickRepository.deleteById(id);
    }

    @Override
    public Pick update(Pick item) {
        return pickRepository.save(item);
    }
}
