package com.eventosmongoama.repository;

import com.eventosmongoama.model.Evento;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface EventoRepository extends MongoRepository<Evento, String> {
    List<Evento> findByNombreContainingIgnoreCase(String nombre);
    List<Evento> findByFecha(long fecha);
    List<Evento> findByArtistasContaining(String artistaId);
}
