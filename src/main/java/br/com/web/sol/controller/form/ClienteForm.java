package br.com.web.sol.controller.form;

import br.com.web.sol.model.Cliente;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

public class ClienteForm {

    @NotNull
    private String id;
    @NotNull @NotEmpty
    private String clientName;
    private String clientTel;
    private String clientAddress;

    public String getId ( ) {
        return id;
    }

    public void setId ( String id ) {
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

    public Cliente converter () {
        return new Cliente(id, clientName,clientTel, clientAddress);
    }

    public List<Cliente> converterListaClientes(List<ClienteForm> forms){
        List<Cliente> clientes = new ArrayList<>();
        forms.forEach( clienteForm -> {
            Cliente cliente = clienteForm.converter();
            clientes.add(cliente);
        });
        return clientes;
    }
}
