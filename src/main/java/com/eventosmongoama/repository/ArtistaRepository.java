package com.eventosmongoama.repository;

import com.eventosmongoama.model.Artista;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface ArtistaRepository extends MongoRepository<Artista, String> {
    List<Artista> findByNombreContainingIgnoreCase(String nombre);
    List<Artista> findByGeneroMusical(String generoMusical);
}
