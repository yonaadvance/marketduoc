package com.marketduoc.cl.marketduoc.repository;

import org.springframework.stereotype.Repository;
import com.marketduoc.cl.marketduoc.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long>{
    
    List<Producto> findByNombrep(String nombrep);

    Producto findById(Integer Id);

    List<Producto> findByUsuario_id(Integer Id);
}
