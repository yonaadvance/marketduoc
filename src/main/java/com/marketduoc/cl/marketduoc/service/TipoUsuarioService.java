package com.marketduoc.cl.marketduoc.service;

import com.marketduoc.cl.marketduoc.model.TipoUsuario;
import com.marketduoc.cl.marketduoc.repository.TipoUsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TipoUsuarioService {
@Autowired
    private TipoUsuarioRepository tipousuarioRepository;

        public List<TipoUsuario> findAll() {
            return tipousuarioRepository.findAll();
        }

        public TipoUsuario save(TipoUsuario tipousuario) {
            return tipousuarioRepository.save(tipousuario);
        }
}
