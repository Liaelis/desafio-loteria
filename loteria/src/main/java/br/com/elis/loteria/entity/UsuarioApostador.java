package br.com.elis.loteria.entity;

import javax.persistence.*;
import java.util.List;
@Entity
public class UsuarioApostador {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idusuario;
    private String email;
    @OneToMany(mappedBy = "usuarioApostador")
    private List<BilheteLoteria> bilhetesApostas;


    public Integer getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<BilheteLoteria> getBilhetesApostas() {
        return bilhetesApostas;
    }

    public void setBilhetesApostas(List<BilheteLoteria> bilhetesApostas) {
        this.bilhetesApostas = bilhetesApostas;
    }


}
