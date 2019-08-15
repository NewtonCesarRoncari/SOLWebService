package br.com.web.sol.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cliente {

    @Id
    private String id;
    private String name;
    private String tel;
    private String adress;

    public Cliente ( ) {
    }

    public String getId ( ) {
        return id;
    }

    public void setId ( String id ) {
        this.id = id;
    }

    public String getName ( ) {
        return name;
    }

    public void setName ( String name ) {
        this.name = name;
    }

    public String getTel ( ) {
        return tel;
    }

    public void setTel ( String tel ) {
        this.tel = tel;
    }

    public String getAdress ( ) {
        return adress;
    }

    public void setAdress ( String adress ) {
        this.adress = adress;
    }

    public Cliente ( String id, String name, String tel, String adress ) {
        this.id = id;
        this.name = name;
        this.tel = tel;
        this.adress = adress;
    }

}
