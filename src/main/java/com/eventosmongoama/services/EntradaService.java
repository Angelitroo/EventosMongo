package com.eventosmongoama.services;

import com.eventosmongoama.model.Entrada;
import com.eventosmongoama.repository.EntradaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EntradaService {
    @Autowired
    private EntradaRepository entradaRepository;

    public Entrada registrarEntrada(Entrada entrada) {
        return entradaRepository.save(entrada);
    }

    public long obtenerNumeroDeEntradasVendidas(String eventoId) {
        return entradaRepository.findByEventoId(eventoId).size();
    }

    public boolean anularEntrada(String id) {
        Optional<Entrada> entradaExistente = entradaRepository.findById(id);
        if (entradaExistente.isPresent()) {
            Entrada entrada = entradaExistente.get();
            entrada.setAnulada(true);
            entradaRepository.save(entrada);
            return true;
        }
        return false;
    }
}
