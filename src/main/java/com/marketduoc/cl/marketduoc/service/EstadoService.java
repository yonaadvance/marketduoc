package com.marketduoc.cl.marketduoc.service;

import com.marketduoc.cl.marketduoc.model.Estado;
import com.marketduoc.cl.marketduoc.repository.EstadoRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class EstadoService {
@Autowired
    private EstadoRepository estadoRepository;

        public List<Estado> findAll() {
            return estadoRepository.findAll();
        }

        public Estado save(Estado estado) {
            return estadoRepository.save(estado);
        }
}
