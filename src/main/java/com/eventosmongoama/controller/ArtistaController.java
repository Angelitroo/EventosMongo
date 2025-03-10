package com.eventosmongoama.controller;

import com.eventosmongoama.model.Artista;
import com.eventosmongoama.services.ArtistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/artistas")
public class ArtistaController {
    @Autowired
    private ArtistaService artistaService;

    @PostMapping
    public Artista crearArtista(@RequestBody Artista artista) {
        return artistaService.crearArtista(artista);
    }

    @GetMapping
    public List<Artista> obtenerArtistas(@RequestParam(required = false) String nombre,
                                         @RequestParam(required = false) String generoMusical) {
        if (nombre != null) {
            return artistaService.buscarArtistasPorNombre(nombre);
        } else if (generoMusical != null) {
            return artistaService.buscarArtistasPorGenero(generoMusical);
        }
        return artistaService.obtenerTodosLosArtistas();
    }

    @PutMapping("/{id}")
    public Artista actualizarArtista(@PathVariable String id, @RequestBody Artista artista) {
        return artistaService.actualizarArtista(id, artista);
    }

    @DeleteMapping("/{id}")
    public boolean eliminarArtista(@PathVariable String id) {
        return artistaService.eliminarArtista(id);
    }
}
