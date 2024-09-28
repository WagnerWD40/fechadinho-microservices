package edu.infnet.jogador_service.repository;

import edu.infnet.jogador_service.model.Jogador;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JogadorRepository extends CrudRepository<Jogador, Long> {

}
