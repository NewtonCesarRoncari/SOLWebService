package br.com.web.sol.service;

import br.com.web.sol.controller.form.UpdateClienteForm;
import br.com.web.sol.model.Cliente;
import br.com.web.sol.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private ClienteRepository clienteRepository;

    @Autowired
    public ClienteService ( ClienteRepository clienteRepository ) {
        this.clienteRepository = clienteRepository;
    }

    public void saveClient ( Cliente cliente ) {
        clienteRepository.save(cliente);
    }

    public Cliente atualizar ( Long id, @Valid UpdateClienteForm form ) {
        var cliente = form.atualizar(id, clienteRepository);
        return cliente;
    }

    public void deleteById ( Long id ) {
        clienteRepository.deleteById(id);
    }

    public List<Cliente> findAllClients ( ) {
        List<Cliente> clientes = clienteRepository.findAll();
        return clientes;
    }

    public Optional<Cliente> findById ( Long id ) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente;
    }

    public void saveAll ( List<Cliente> clientes ) {
        clienteRepository.saveAll(clientes);
    }
}
