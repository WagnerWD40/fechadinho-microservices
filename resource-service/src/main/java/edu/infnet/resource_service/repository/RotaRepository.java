package edu.infnet.resource_service.repository;

import edu.infnet.resource_service.model.Rota;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RotaRepository extends CrudRepository<Rota, Long> {
}
