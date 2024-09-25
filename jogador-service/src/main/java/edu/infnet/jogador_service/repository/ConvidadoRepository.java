package edu.infnet.jogador_service.repository;

import edu.infnet.jogador_service.model.Convidado;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConvidadoRepository extends CrudRepository<Convidado, Long> {
}
