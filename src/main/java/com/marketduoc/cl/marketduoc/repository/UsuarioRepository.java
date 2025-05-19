package com.marketduoc.cl.marketduoc.repository;

import org.springframework.stereotype.Repository;
import com.marketduoc.cl.marketduoc.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

    List<Usuario> findByapellidos(String apellidos);

    Usuario findById(Integer Id);

    Usuario findBycorreo(String correo);

    List<Usuario> findByNombreAndApellidos(String nombres, String apellidos);
}
