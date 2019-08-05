package br.com.web.sol.controller;

import br.com.web.sol.controller.DTO.ClienteDTO;
import br.com.web.sol.controller.form.UpdateClienteForm;
import br.com.web.sol.controller.form.ClienteForm;
import br.com.web.sol.model.Cliente;
import br.com.web.sol.service.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController ( ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public List<ClienteDTO> listaClientes(){
        List<Cliente> clientes = clienteService.findAllClients();
        return ClienteDTO.converter(clientes);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> cadastrarCliente( @RequestBody @Valid ClienteForm clienteForm){
        var cliente = clienteForm.converter();
            clienteService.saveClient(cliente);
            return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> consultaCliente(@PathVariable Long id){
        Optional<Cliente> cliente = clienteService.findById(id);
        if(cliente.isPresent()){
            return ResponseEntity.ok(new ClienteDTO(cliente.get()));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/clientes")
    @Transactional
    public ResponseEntity<?> cadastrarListaClientes ( @RequestBody @Valid List<ClienteForm> listClienteForm){
        var forms = new ClienteForm();
        List<Cliente> clientes = forms.converterListaClientes(listClienteForm);
        clienteService.saveAll(clientes);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<ClienteDTO> atualizarCliente ( @PathVariable Long id, @RequestBody @Valid UpdateClienteForm form ) {
        Optional<Cliente> optional = clienteService.findById(id);
        if (optional.isPresent()) {
            Cliente cliente = clienteService.atualizar(id, form);
            return ResponseEntity.ok(new ClienteDTO(cliente));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> removerCliente (@PathVariable Long id){
        Optional<Cliente> optional = clienteService.findById(id);
        if(optional.isPresent()){
            clienteService.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
