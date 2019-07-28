package br.com.web.sol.controller.form;

import br.com.web.sol.model.Cliente;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ClienteForm {

    @NotNull @NotEmpty
    private String clientName;
    private String clientTel;
    private String clientAddress;


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

    public Cliente converter () {
        return new Cliente(clientName,clientTel, clientAddress);
    }
}
