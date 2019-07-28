package br.com.web.sol.controller;

import br.com.web.sol.controller.form.ClienteForm;
import br.com.web.sol.model.Cliente;
import br.com.web.sol.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping
    public void cadastrarCliente( @RequestBody @Valid ClienteForm clienteForm){
        Cliente cliente = clienteForm.converter();
            clienteRepository.save(cliente);
    }

    @PostMapping("/clientes")
    public void cadastrarListaCLientes ( @RequestBody @Valid List<ClienteForm> listClienteForm){
        listClienteForm.forEach( clienteForm ->{
            Cliente cliente = clienteForm.converter();
            clienteRepository.save(cliente);
        });
    }
}
