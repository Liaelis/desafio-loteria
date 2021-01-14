package br.com.elis.loteria.service;

import br.com.elis.loteria.entity.BilheteLoteria;
import br.com.elis.loteria.entity.UsuarioApostador;
import br.com.elis.loteria.model.BilheteLoteriaDTO;
import br.com.elis.loteria.repository.BilheteLoteriaRepository;
import br.com.elis.loteria.repository.UsuarioApostadorRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BilhetesService {

    @Autowired
    UsuarioApostadorRespository usuarioApostadorRespository;
    @Autowired
    BilheteLoteriaRepository bilheteLoteriaRepository;

    public Optional<List<BilheteLoteriaDTO>> VerificaBilhetesUsuario(String email) {
        Optional<UsuarioApostador> usuarioApostadorOptional = usuarioApostadorRespository.findByEmail(email);
        List<BilheteLoteriaDTO> bilhetes = usuarioApostadorOptional.map(this::buscaBilhetes)
                .orElse(null);

        return Optional.ofNullable(bilhetes);
    }

    public List<BilheteLoteriaDTO> buscaBilhetes(UsuarioApostador usuarioApostador) {
        List<BilheteLoteriaDTO> bilhetesUsuario = new ArrayList<>();
        List<BilheteLoteria> bilhetesLoteria = bilheteLoteriaRepository
                .findByUsuarioApostadorIdusuario(usuarioApostador.getIdusuario());
        for (BilheteLoteria b : bilhetesLoteria) {
            BilheteLoteriaDTO bilhete = new BilheteLoteriaDTO();
            bilhete.setUsuario(b.getUsuarioApostador().getEmail());
            bilhete.setDataHora(b.getDateTimeAposta());
            bilhete.setNumeroAposta(b.getNumeroAposta());
            bilhetesUsuario.add(bilhete);
        }
        return bilhetesUsuario;
    }

}
