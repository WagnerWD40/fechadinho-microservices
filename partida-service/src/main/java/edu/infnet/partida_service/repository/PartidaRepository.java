package edu.infnet.partida_service.repository;

import edu.infnet.partida_service.model.Partida;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartidaRepository extends CrudRepository<Partida, Long> {
}
