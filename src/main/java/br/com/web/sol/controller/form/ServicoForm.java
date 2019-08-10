package br.com.web.sol.controller.form;

import br.com.web.sol.model.Servico;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

public class ServicoForm {

    @NotNull
    private String idServico;
    @NotNull @NotEmpty
    private String descricao;
    @NotNull @NotEmpty
    private Double valor;

    public String getIdServico ( ) {
        return idServico;
    }

    public void setIdServico ( String idServico ) {
        this.idServico = idServico;
    }

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

    public Servico converter ( ) {
        return new Servico(idServico, descricao, valor);
    }

    public List<Servico> converterListaServico ( List<ServicoForm> forms ) {
        List<Servico> servicos = new ArrayList<>();
        forms.forEach( servicoForm -> {
            Servico servico = servicoForm.converter();
            servicos.add(servico);
        });
        return servicos;
    }
}
