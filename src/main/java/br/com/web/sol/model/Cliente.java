package br.com.web.sol.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Cliente {

    @Id @GeneratedValue
    private Long id;
    private String clientName;
    private String clientTel;
    private String clientAddress;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientTel() {
        return clientTel;
    }

    public void setClientTel(String clientTel) {
        this.clientTel = clientTel;
    }

    public String getClientAddress() {
        return clientAddress;
    }

    public void setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
    }

    public Cliente ( ) {
    }

    public Cliente (String clientName, String clientTel, String clientAddress ) {
        this.clientName = clientName;
        this.clientTel = clientTel;
        this.clientAddress = clientAddress;
    }

    @Override
    public String toString() {
        return clientName;
    }
}
