package com.marketduoc.cl.marketduoc.service;

import com.marketduoc.cl.marketduoc.model.Usuario;
import com.marketduoc.cl.marketduoc.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Usuario findById(Long id) {
        return usuarioRepository.findById(id).get();
    }

    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public void delete(Long id) {
        usuarioRepository.deleteById(id);
    }

    public Usuario patchUsuario(Long id, Usuario parcialUsuario){
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        if (usuarioOptional.isPresent()) {
            
            Usuario usuarioToUpdate = usuarioOptional.get();
            
            if (parcialUsuario.getNombre() != null) {
                usuarioToUpdate.setNombre(parcialUsuario.getNombre());   
            }

            if(parcialUsuario.getApellidos() != null) {
                usuarioToUpdate.setApellidos(parcialUsuario.getApellidos());
            }

            if(parcialUsuario.getCorreo() != null) {
                usuarioToUpdate.setCorreo(parcialUsuario.getCorreo());
            }

            return usuarioRepository.save(usuarioToUpdate);
        } else {
            return null;
        }
    }
}