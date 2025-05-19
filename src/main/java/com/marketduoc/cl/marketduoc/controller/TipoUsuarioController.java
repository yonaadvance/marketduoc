package com.marketduoc.cl.marketduoc.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marketduoc.cl.marketduoc.model.TipoUsuario;
import com.marketduoc.cl.marketduoc.service.TipoUsuarioService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tipousuarios")
public class TipoUsuarioController {
@Autowired
    private TipoUsuarioService tipousuarioService;

    @GetMapping
    public ResponseEntity<List<TipoUsuario>> listarTipoUsuario() {
        List<TipoUsuario> tipousuarios = tipousuarioService.findAll();
        if (tipousuarios.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(tipousuarios);
    }

    @PostMapping
    public ResponseEntity<TipoUsuario> crearTipoUsuarios(@RequestBody TipoUsuario tipousuario) {
        TipoUsuario nuevoTipousuario = tipousuarioService.save(tipousuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoTipousuario);
    }
}
