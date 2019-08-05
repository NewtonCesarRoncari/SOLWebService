package br.com.web.sol.controller.DTO;

import br.com.web.sol.model.Cliente;

import java.util.List;
import java.util.stream.Collectors;

public class ClienteDTO {

    private String id;
    private String clientName;
    private String clientTel;
    private String clientAddress;

    public ClienteDTO ( Cliente cliente) {
        this.id = cliente.getId();
        this.clientName = cliente.getClientName();
        this.clientTel = cliente.getClientTel();
        this.clientAddress = cliente.getClientName();
    }

    public String getId ( ) {
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

    public static List<ClienteDTO> converter ( List<Cliente> clientes ) {
        return clientes.stream().map(ClienteDTO::new).collect(Collectors.toList());
    }
}
