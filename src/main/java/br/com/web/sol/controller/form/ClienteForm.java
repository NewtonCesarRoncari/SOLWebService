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
    private String name;
    private String tel;
    private String adress;

    public String getId ( ) {
        return id;
    }

    public void setId ( String id ) {
        this.id = id;
    }

    public String getName () {
        return name;
    }

    public void setName ( String name ) {
        this.name = name;
    }

    public String getTel () {
        return tel;
    }

    public void setTel ( String tel ) {
        this.tel = tel;
    }

    public String getAdress () {
        return adress;
    }

    public void setAdress ( String adress ) {
        this.adress = adress;
    }

    public Cliente converter () {
        return new Cliente(id, name, tel, adress);
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
