package com.marketduoc.cl.marketduoc.service;

import com.marketduoc.cl.marketduoc.model.Categoria;
import com.marketduoc.cl.marketduoc.repository.CategoriaRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CategoriaService {
@Autowired
    private CategoriaRepository categoriaRepository;

        public List<Categoria> findAll() {
            return categoriaRepository.findAll();
        }

        public Categoria save(Categoria categoria) {
            return categoriaRepository.save(categoria);
        }
}
