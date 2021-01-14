package br.com.elis.loteria.controller;

import br.com.elis.loteria.entity.BilheteLoteria;
import br.com.elis.loteria.model.BilheteLoteriaDTO;
import br.com.elis.loteria.service.ApostasService;
import br.com.elis.loteria.service.BilhetesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/loteria")
public class LoteriaController {
@Autowired
ApostasService apostasService;
@Autowired
BilhetesService bilhetesService;

    @GetMapping("/aposta")
    public ResponseEntity<BilheteLoteriaDTO> fazerAposta(@RequestBody String email){
        Optional<BilheteLoteriaDTO> bilheteLoteriaOptional = apostasService.verificaUsuarioParaAposta(email);
        return ResponseEntity.of(bilheteLoteriaOptional);
    }

    @GetMapping("/bilhetes")
    public ResponseEntity<List<BilheteLoteriaDTO>> bilhetesDoUsuario(@RequestBody String email){

        Optional<List<BilheteLoteriaDTO>> bilhetesUsuario = bilhetesService.VerificaBilhetesUsuario(email);
        return ResponseEntity.of(bilhetesUsuario);
    }
}
