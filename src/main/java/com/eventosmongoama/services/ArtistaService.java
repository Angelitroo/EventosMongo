package com.eventosmongoama.services;

import com.eventosmongoama.model.Artista;
import com.eventosmongoama.repository.ArtistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ArtistaService {
    @Autowired
    private ArtistaRepository artistaRepository;

    public Artista crearArtista(Artista artista) {
        return artistaRepository.save(artista);
    }

    public List<Artista> buscarArtistasPorNombre(String nombre) {
        return artistaRepository.findByNombreContainingIgnoreCase(nombre);
    }

    public List<Artista> buscarArtistasPorGenero(String generoMusical) {
        return artistaRepository.findByGeneroMusical(generoMusical);
    }

    public List<Artista> obtenerTodosLosArtistas() {
        return artistaRepository.findAll();
    }

    public Artista actualizarArtista(String id, Artista artista) {
        Optional<Artista> artistaExistente = artistaRepository.findById(id);
        if (artistaExistente.isPresent()) {
            Artista artistaActualizado = artistaExistente.get();
            artistaActualizado.setNombre(artista.getNombre());
            artistaActualizado.setGeneroMusical(artista.getGeneroMusical());
            artistaActualizado.setBiografia(artista.getBiografia());
            artistaActualizado.setRedesSociales(artista.getRedesSociales());
            return artistaRepository.save(artistaActualizado);
        }
        return null;
    }

    public boolean eliminarArtista(String id) {
        Optional<Artista> artistaExistente = artistaRepository.findById(id);
        if (artistaExistente.isPresent()) {
            artistaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
