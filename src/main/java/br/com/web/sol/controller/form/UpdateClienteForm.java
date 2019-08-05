package br.com.web.sol.controller.form;


import br.com.web.sol.model.Cliente;
import br.com.web.sol.repository.ClienteRepository;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UpdateClienteForm {

    @NotNull
    @NotEmpty
    private String clientName;
    private String clientTel;
    private String clientAddress;

    public String getClientName ( ) {
        return clientName;
    }

    public void setClientName ( String clientName ) {
        this.clientName = clientName;
    }

    public String getClientTel ( ) {
        return clientTel;
    }

    public void setClientTel ( String clientTel ) {
        this.clientTel = clientTel;
    }

    public String getClientAddress ( ) {
        return clientAddress;
    }

    public void setClientAddress ( String clientAddress ) {
        this.clientAddress = clientAddress;
    }

    public Cliente atualizar ( Long id, ClienteRepository clienteRepository ) {
        Cliente cliente = clienteRepository.getOne(id);

        cliente.setClientName(this.clientName);
        cliente.setClientAddress(this.clientAddress);
        cliente.setClientTel(this.clientTel);

        return cliente;
    }
}
