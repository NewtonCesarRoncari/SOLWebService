package br.com.web.sol.controller.form;

import br.com.web.sol.model.Servico;
import br.com.web.sol.repository.ServicoRepository;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UpdateServicoForm {

    @NotNull @NotEmpty
    private String description;
    @NotNull @NotEmpty
    private Double value;

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

    public Servico atualizar ( Long id, ServicoRepository servicoRepository ) {
        Servico servico = servicoRepository.getOne(id);
        servico.setDescription(this.description);
        servico.setValue(this.value);

        return servico;
    }
}
