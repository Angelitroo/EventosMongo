package com.eventosmongoama.services;

import com.eventosmongoama.model.Evento;
import com.eventosmongoama.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.Date;

@Service
public class EventoService {
    @Autowired
    private EventoRepository eventoRepository;

    public Evento crearEvento(Evento evento) {
        return eventoRepository.save(evento);
    }

    public List<Evento> buscarEventosPorNombre(String nombre) {
        return eventoRepository.findByNombreContainingIgnoreCase(nombre);
    }

    public List<Evento> buscarEventosPorFecha(Date fecha) {
        return eventoRepository.findByFecha(fecha);
    }

    public List<Evento> buscarEventosPorArtista(String artistaId) {
        return eventoRepository.findByArtistasContaining(artistaId);
    }

    public List<Evento> obtenerTodosLosEventos() {
        return eventoRepository.findAll();
    }

    public Evento actualizarEvento(String id, Evento evento) {
        Optional<Evento> eventoExistente = eventoRepository.findById(id);
        if (eventoExistente.isPresent()) {
            Evento eventoActualizado = eventoExistente.get();
            eventoActualizado.setNombre(evento.getNombre());
            eventoActualizado.setFecha(evento.getFecha());
            eventoActualizado.setHora(evento.getHora());
            eventoActualizado.setLugar(evento.getLugar());
            eventoActualizado.setArtistas(evento.getArtistas());
            eventoActualizado.setPrecioEntrada(evento.getPrecioEntrada());
            return eventoRepository.save(eventoActualizado);
        }
        return null;
    }

    public boolean eliminarEvento(String id) {
        Optional<Evento> eventoExistente = eventoRepository.findById(id);
        if (eventoExistente.isPresent()) {
            eventoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
