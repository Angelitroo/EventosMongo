package com.eventosmongoama.controller;

import com.eventosmongoama.model.Entrada;
import com.eventosmongoama.services.EntradaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/entradas")
public class EntradaController {
    @Autowired
    private EntradaService entradaService;

    @PostMapping
    public Entrada registrarEntrada(@RequestBody Entrada entrada) {
        return entradaService.registrarEntrada(entrada);
    }

    @GetMapping
    public long obtenerNumeroDeEntradasVendidas(@RequestParam String eventoId) {
        return entradaService.obtenerNumeroDeEntradasVendidas(eventoId);
    }

    @PutMapping("/{id}/anular")
    public boolean anularEntrada(@PathVariable String id) {
        return entradaService.anularEntrada(id);
    }
}
