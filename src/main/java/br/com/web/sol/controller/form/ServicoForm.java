package br.com.web.sol.controller.form;

import br.com.web.sol.model.Servico;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

public class ServicoForm {

    @NotNull
    private String id;
    @NotNull @NotEmpty
    private String description;
    @NotNull @NotEmpty
    private Double value;

    public String getId ( ) {
        return id;
    }

    public void setId ( String id ) {
        this.id = id;
    }

    public String getDescription ( ) {
        return description;
    }

    public void setDescription ( String description ) {
        this.description = description;
    }

    public Double getValue ( ) {
        return value;
    }

    public void setValue ( Double value ) {
        this.value = value;
    }

    public Servico converter ( ) {
        return new Servico(id, description, value);
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
