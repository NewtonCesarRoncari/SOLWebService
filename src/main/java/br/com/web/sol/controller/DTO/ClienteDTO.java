package br.com.web.sol.controller.DTO;

import br.com.web.sol.model.Cliente;

import java.util.List;
import java.util.stream.Collectors;

public class ClienteDTO {

    private String id;
    private String name;
    private String tel;
    private String adress;

    public ClienteDTO ( Cliente cliente) {
        this.id = cliente.getId();
        this.name = cliente.getName();
        this.tel = cliente.getTel();
        this.adress = cliente.getAdress();
    }

    public String getId ( ) {
        return id;
    }

    public String getName ( ) {
        return name;
    }

    public String getTel ( ) {
        return tel;
    }

    public String getAdress ( ) {
        return adress;
    }

    public static List<ClienteDTO> converter ( List<Cliente> clientes ) {
        return clientes.stream().map(ClienteDTO::new).collect(Collectors.toList());
    }
}
