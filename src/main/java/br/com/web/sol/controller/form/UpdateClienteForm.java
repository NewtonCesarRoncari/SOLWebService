package br.com.web.sol.controller.form;


import br.com.web.sol.model.Cliente;
import br.com.web.sol.repository.ClienteRepository;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UpdateClienteForm {

    @NotNull
    @NotEmpty
    private String name;
    private String tel;
    private String adress;

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

    public Cliente atualizar ( Long id, ClienteRepository clienteRepository ) {
        Cliente cliente = clienteRepository.getOne(id);

        cliente.setName(this.name);
        cliente.setAdress(this.adress);
        cliente.setTel(this.tel);

        return cliente;
    }
}
