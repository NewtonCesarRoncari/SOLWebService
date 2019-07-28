package br.com.web.sol.controller.DTO;

import br.com.web.sol.model.Cliente;

public class ClienteDTO {

    private Long id;
    private String clientName;
    private String clientTel;
    private String clientAddress;

    public ClienteDTO ( Cliente cliente) {
        this.id = cliente.getId();
        this.clientName = cliente.getClientName();
        this.clientTel = cliente.getClientTel();
        this.clientAddress = cliente.getClientName();
    }

    public Long getId ( ) {
        return id;
    }

    public String getClientName ( ) {
        return clientName;
    }

    public String getClientTel ( ) {
        return clientTel;
    }

    public String getClientAddress ( ) {
        return clientAddress;
    }
}
