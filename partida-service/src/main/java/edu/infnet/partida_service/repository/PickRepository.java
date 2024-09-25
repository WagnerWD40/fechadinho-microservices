package edu.infnet.partida_service.repository;

import edu.infnet.partida_service.model.Pick;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PickRepository extends CrudRepository<Pick, Long> {
}
