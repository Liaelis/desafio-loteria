package br.com.elis.loteria.model;

import br.com.elis.loteria.entity.UsuarioApostador;

import java.time.LocalDateTime;
import java.util.List;

public class BilheteLoteriaDTO {
    private LocalDateTime dataHora;
    private String usuario;
    private List<Integer> numeroAposta;

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public List<Integer> getNumeroAposta() {
        return numeroAposta;
    }

    public void setNumeroAposta(List<Integer> numeroAposta) {
        this.numeroAposta = numeroAposta;
    }
}
