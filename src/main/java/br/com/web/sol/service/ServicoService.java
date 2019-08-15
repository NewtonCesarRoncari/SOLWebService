package br.com.web.sol.service;

import br.com.web.sol.controller.form.UpdateServicoForm;
import br.com.web.sol.model.Servico;
import br.com.web.sol.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class ServicoService {

    private final ServicoRepository servicoRepository;

    @Autowired
    public ServicoService ( ServicoRepository servicoRepository ) {
        this.servicoRepository = servicoRepository;
    }

    public void saveServico ( Servico servico ) {
        servicoRepository.save(servico);
    }

    public Servico atualizar ( Long id, @Valid UpdateServicoForm form ) {
        var servico = form.atualizar(id, servicoRepository);
        return servico;
    }

    public void deleteById ( Long id ) {
        servicoRepository.deleteById(id);
    }

    public List<Servico> findAll(){
        List<Servico> servicos = servicoRepository.findAll();
        return servicos;
    }

    public Optional<Servico> findById ( Long id ) {
        var servico = servicoRepository.findById(id);
        return servico;
    }

    public void saveAll ( List<Servico> servicos ) {
        servicoRepository.saveAll(servicos);
    }
}
