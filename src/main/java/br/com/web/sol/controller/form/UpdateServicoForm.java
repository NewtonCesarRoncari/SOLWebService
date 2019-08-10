package br.com.web.sol.controller.form;

import br.com.web.sol.model.Servico;
import br.com.web.sol.repository.ServicoRepository;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UpdateServicoForm {

    @NotNull @NotEmpty
    private String descricao;
    @NotNull @NotEmpty
    private Double valor;

    public String getDescricao ( ) {
        return descricao;
    }

    public void setDescricao ( String descricao ) {
        this.descricao = descricao;
    }

    public Double getValor ( ) {
        return valor;
    }

    public void setValor ( Double valor ) {
        this.valor = valor;
    }

    public Servico atualizar ( Long id, ServicoRepository servicoRepository ) {
        Servico servico = servicoRepository.getOne(id);
        servico.setDescricao(this.descricao);
        servico.setValor(this.valor);

        return servico;
    }
}
