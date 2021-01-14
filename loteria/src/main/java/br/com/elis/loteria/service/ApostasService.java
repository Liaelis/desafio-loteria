package br.com.elis.loteria.service;

import br.com.elis.loteria.entity.BilheteLoteria;
import br.com.elis.loteria.entity.UsuarioApostador;
import br.com.elis.loteria.model.BilheteLoteriaDTO;
import br.com.elis.loteria.repository.BilheteLoteriaRepository;
import br.com.elis.loteria.repository.UsuarioApostadorRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class ApostasService {

    @Autowired
    private UsuarioApostadorRespository usuarioApostadorRespository;
    @Autowired
    private BilheteLoteriaRepository bilheteLoteriaRepository;

    public Optional<BilheteLoteriaDTO> verificaUsuarioParaAposta(String email) {

        Optional<UsuarioApostador> usuarioApostadorOptional = usuarioApostadorRespository.findByEmail(email);
        BilheteLoteriaDTO bilheteLoteriaDTO = usuarioApostadorOptional.map(this::novaAposta)
                .orElseGet(() -> novaAposta(criaNovoUsuario(email)));
        return Optional.ofNullable(bilheteLoteriaDTO);
    }

    public BilheteLoteriaDTO novaAposta(UsuarioApostador usuarioApostador) {
        BilheteLoteria bilheteLoteria = new BilheteLoteria();
        bilheteLoteria.setDateTimeAposta(LocalDateTime.now());
        bilheteLoteria.setNumeroAposta(geraNumeros());
        bilheteLoteria.setUsuarioApostador(usuarioApostador);
        bilheteLoteriaRepository.save(bilheteLoteria);

        return criaBilheteUsuario(bilheteLoteria);
    }

    public BilheteLoteriaDTO criaBilheteUsuario(BilheteLoteria bilheteLoteria) {
        BilheteLoteriaDTO bilhete = new BilheteLoteriaDTO();
        bilhete.setUsuario(bilheteLoteria.getUsuarioApostador().getEmail());
        bilhete.setDataHora(bilheteLoteria.getDateTimeAposta());
        bilhete.setNumeroAposta(bilheteLoteria.getNumeroAposta());
        return bilhete;
    }

    public List<Integer> geraNumeros() {
        List<Integer> numerosBilhete = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            numerosBilhete.add(random.nextInt(60));
        }
        return numerosBilhete;
    }

    public UsuarioApostador criaNovoUsuario(String email) {
        UsuarioApostador usuarioApostador = new UsuarioApostador();
        usuarioApostador.setEmail(email);
        usuarioApostadorRespository.save(usuarioApostador);
        return usuarioApostador;
    }
}
