package edu.infnet.jogador_service.repository;

import edu.infnet.jogador_service.model.Conhecido;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConhecidoRepository extends CrudRepository<Conhecido, Long> {

}
