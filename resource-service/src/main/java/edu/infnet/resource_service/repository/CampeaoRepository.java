package edu.infnet.resource_service.repository;

import edu.infnet.resource_service.model.Campeao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampeaoRepository extends CrudRepository<Campeao, Long> {
}
