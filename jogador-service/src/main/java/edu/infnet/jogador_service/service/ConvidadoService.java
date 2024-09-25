package edu.infnet.jogador_service.service;

import edu.infnet.jogador_service.dto.ConhecidoCompletoDTO;
import edu.infnet.jogador_service.dto.ConvidadoCompletoDTO;
import edu.infnet.jogador_service.model.Conhecido;
import edu.infnet.jogador_service.model.Convidado;
import edu.infnet.jogador_service.model.Rota;
import edu.infnet.jogador_service.repository.ConvidadoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ConvidadoService implements ResourceService<Convidado> {

    private final ConvidadoRepository convidadoRepository;
    private final RotaService rotaService;

    @Override
    public Convidado create(Convidado item) {
        return convidadoRepository.save(item);
    }

    @Override
    public Optional<Convidado> findById(Long id) {
        return convidadoRepository.findById(id);
    }

    @Override
    public List<Convidado> findAll() {
        return (List<Convidado>) convidadoRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        convidadoRepository.deleteById(id);
    }

    @Override
    public Convidado update(Convidado item) {
        return convidadoRepository.save(item);
    }

    public Optional<ConvidadoCompletoDTO> findCompleto(Long id) {
        Optional<Convidado> convidado = findById(id);

        if (convidado.isEmpty()) {
            return Optional.empty();
        }

        Rota rota = rotaService.findById(convidado.get().getRotaId());

        return Optional.of(ConvidadoCompletoDTO.from(convidado.get(), rota));
    }
}
