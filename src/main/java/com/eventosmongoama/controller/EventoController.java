package com.eventosmongoama.controller;

import com.eventosmongoama.model.Evento;
import com.eventosmongoama.services.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Date;

import static org.apache.tomcat.util.http.FastHttpDateFormat.parseDate;

@RestController
@RequestMapping("/eventos")
public class EventoController {
    @Autowired
    private EventoService eventoService;

    @PostMapping
    public Evento crearEvento(@RequestBody Evento evento) {
        return eventoService.crearEvento(evento);
    }

    @GetMapping
    public List<Evento> obtenerEventos(@RequestParam(required = false) String nombre,
                                       @RequestParam(required = false) String fecha,
                                       @RequestParam(required = false) String artistaId) {
        if (nombre != null) {
            return eventoService.buscarEventosPorNombre(nombre);
        } else if (fecha != null) {
            long parsedFecha = parseDate(fecha);
            return eventoService.buscarEventosPorFecha(parsedFecha);
        } else if (artistaId != null) {
            return eventoService.buscarEventosPorArtista(artistaId);
        }
        return eventoService.obtenerTodosLosEventos();
    }


    @PutMapping("/{id}")
    public Evento actualizarEvento(@PathVariable String id, @RequestBody Evento evento) {
        return eventoService.actualizarEvento(id, evento);
    }

    @DeleteMapping("/{id}")
    public boolean eliminarEvento(@PathVariable String id) {
        return eventoService.eliminarEvento(id);
    }
}
