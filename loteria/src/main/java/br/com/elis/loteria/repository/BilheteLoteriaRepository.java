package br.com.elis.loteria.repository;

import br.com.elis.loteria.entity.BilheteLoteria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BilheteLoteriaRepository extends JpaRepository<BilheteLoteria,Integer > {

    List<BilheteLoteria> findByUsuarioApostadorIdusuario(Integer idUsuario);
}
