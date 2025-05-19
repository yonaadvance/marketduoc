package com.marketduoc.cl.marketduoc.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marketduoc.cl.marketduoc.model.Estado;
import com.marketduoc.cl.marketduoc.service.EstadoService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/estados")
public class EstadoController {
@Autowired
    private EstadoService estadoService;

    @GetMapping
    public ResponseEntity<List<Estado>> listarEstados() {
        List<Estado> estados = estadoService.findAll();
        if (estados.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(estados);
    }

    @PostMapping
    public ResponseEntity<Estado> crearEstado(@RequestBody Estado estado) {
        Estado nuevoEstado = estadoService.save(estado);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoEstado);
    }
}
