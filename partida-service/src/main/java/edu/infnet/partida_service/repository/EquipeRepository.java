package edu.infnet.partida_service.repository;

import edu.infnet.partida_service.model.Equipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipeRepository extends CrudRepository<Equipe, Long> {
}
