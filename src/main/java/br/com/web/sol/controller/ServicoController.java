package br.com.web.sol.controller;

import br.com.web.sol.controller.DTO.ServicoDTO;
import br.com.web.sol.controller.form.ServicoForm;
import br.com.web.sol.controller.form.UpdateServicoForm;
import br.com.web.sol.model.Servico;
import br.com.web.sol.service.ServicoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/servico")
public class ServicoController {

    private final ServicoService servicoService;

    public ServicoController ( ServicoService servicoService ) {
        this.servicoService = servicoService;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> cadastrarServico ( @RequestBody @Valid ServicoForm form ) {
        var servico = form.converter();
        servicoService.saveServico(servico);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServicoDTO> consultaServico ( @PathVariable Long id ) {
        Optional<Servico> servico = servicoService.findById(id);
        if (servico.isPresent()) {
            return ResponseEntity.ok(new ServicoDTO(servico.get()));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<ServicoDTO> atualizaServico ( @PathVariable Long id, @RequestBody @Valid UpdateServicoForm form) {
        Optional<Servico> optional = servicoService.findById(id);
        if (optional.isPresent()) {
            Servico servico = servicoService.atualizar(id, form);
            return ResponseEntity.ok( new ServicoDTO(servico));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> removeServico ( @PathVariable Long id ) {
        Optional<Servico> optional = servicoService.findById(id);
        if (optional.isPresent()) {
            servicoService.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/servicos")
    public List<ServicoDTO> listaServico (){
        List<Servico> servicos = servicoService.findAll();
        return ServicoDTO.converter(servicos);
    }

    @PostMapping("/servicos")
    @Transactional
    public ResponseEntity<?> cadastrarListaServico ( @RequestBody List<ServicoForm> servicoFormList ) {
        var forms = new ServicoForm();
        List<Servico> servicos = forms.converterListaServico(servicoFormList);
        servicoService.saveAll(servicos);
        return ResponseEntity.ok().build();
    }
}
