package br.com.web.sol.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Servico {

    @Id
    private String id;
    private String descricao;
    private Double valor;

    public Servico ( ) {
    }

    public String getId ( ) {
        return id;
    }

    public void setId ( String id ) {
        this.id = id;
    }

    public String getDescricao ( ) {
        return descricao;
    }

    public void setDescricao ( String descricao ) {
        this.descricao = descricao;
    }

    public Double getValor ( ) {
        return valor;
    }

    public void setValor ( Double valor ) {
        this.valor = valor;
    }

    public Servico ( String id, String descricao, Double valor ) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
    }

}
