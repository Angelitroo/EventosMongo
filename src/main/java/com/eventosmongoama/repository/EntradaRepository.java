package com.eventosmongoama.repository;

import com.eventosmongoama.model.Entrada;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface EntradaRepository extends MongoRepository<Entrada, String> {
    List<Entrada> findByEventoId(String eventoId);
}
