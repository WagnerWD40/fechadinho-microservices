package edu.infnet.jogador_service.service;

import edu.infnet.jogador_service.dto.ConhecidoCompletoDTO;
import edu.infnet.jogador_service.model.Conhecido;
import edu.infnet.jogador_service.model.Rota;
import edu.infnet.jogador_service.repository.ConhecidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ConhecidoService implements ResourceService<Conhecido> {

    private final ConhecidoRepository conhecidoRepository;
    private final RotaService rotaService;

    @Override
    public Conhecido create(Conhecido item) {
        return conhecidoRepository.save(item);
    }

    @Override
    public Optional<Conhecido> findById(Long id) {
        return conhecidoRepository.findById(id);
    }

    @Override
    public List<Conhecido> findAll() {
        return (List<Conhecido>) conhecidoRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        conhecidoRepository.deleteById(id);
    }

    @Override
    public Conhecido update(Conhecido item) {
        return conhecidoRepository.save(item);
    }

    public Optional<ConhecidoCompletoDTO> findCompleto(Long id) {
        Optional<Conhecido> conhecido = findById(id);

        if (conhecido.isEmpty()) {
            return Optional.empty();
        }

        Rota rota = rotaService.findById(conhecido.get().getRotaId());

        return Optional.of(ConhecidoCompletoDTO.from(conhecido.get(), rota));
    }
}
