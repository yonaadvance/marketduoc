package com.marketduoc.cl.marketduoc.service;

import com.marketduoc.cl.marketduoc.model.Producto;
import com.marketduoc.cl.marketduoc.repository.ProductoRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductoService {
@Autowired
    private ProductoRepository productoRepository;

    public List<Producto> findAll() {
        return productoRepository.findAll();
    }

    public Producto findById(Long id) {
        return productoRepository.findById(id).get();
    }

    public Producto save(Producto producto) {
        return productoRepository.save(producto);
    }

    public void delete(Long id) {
        productoRepository.deleteById(id);
    }

    public Producto patchProducto(Long id, Producto parcialProducto){
        Optional<Producto> productoOptional = productoRepository.findById(id);
        if (productoOptional.isPresent()) {
            
            Producto productoToUpdate = productoOptional.get();
            
            if (parcialProducto.getNombrep() != null) {
                productoToUpdate.setNombrep(parcialProducto.getNombrep());   
            }

            if(parcialProducto.getContenido() != null) {
                productoToUpdate.setContenido(parcialProducto.getContenido());
            }

            if(parcialProducto.getFechaCreacion() != null) {
                productoToUpdate.setFechaCreacion(parcialProducto.getFechaCreacion());
            }

            return productoRepository.save(productoToUpdate);
        } else {
            return null;
        }
    }
}
