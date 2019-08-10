package br.com.web.sol.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cliente {

    @Id
    private String id;
    private String clientName;
    private String clientTel;
    private String clientAddress;

    public Cliente ( ) {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public Cliente (String id, String clientName, String clientTel, String clientAddress) {
        this.id = id;
        this.clientName = clientName;
        this.clientTel = clientTel;
        this.clientAddress = clientAddress;
    }

}
