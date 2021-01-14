package br.com.elis.loteria.repository;

import br.com.elis.loteria.entity.UsuarioApostador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioApostadorRespository extends JpaRepository<UsuarioApostador,Integer > {
    Optional<UsuarioApostador> findByEmail(String email);
}
