package br.com.elis.loteria.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class BilheteLoteria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDateTime dateTimeAposta;
    @ElementCollection
    private List<Integer> numeroAposta;
    @ManyToOne
    @JoinColumn(name = "idusuario")
    private UsuarioApostador usuarioApostador;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getDateTimeAposta() {
        return dateTimeAposta;
    }

    public void setDateTimeAposta(LocalDateTime dateTimeAposta) {
        this.dateTimeAposta = dateTimeAposta;
    }

    public List<Integer> getNumeroAposta() {
        return numeroAposta;
    }

    public void setNumeroAposta(List<Integer> numeroAposta) {
        this.numeroAposta = numeroAposta;
    }

    public UsuarioApostador getUsuarioApostador() {
        return usuarioApostador;
    }

    public void setUsuarioApostador(UsuarioApostador usuarioApostador) {
        this.usuarioApostador = usuarioApostador;
    }
}
