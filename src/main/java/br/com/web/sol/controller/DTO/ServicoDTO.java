package br.com.web.sol.controller.DTO;

import br.com.web.sol.model.Servico;

import java.util.List;
import java.util.stream.Collectors;

public class ServicoDTO {

    private String id;
    private String description;
    private Double value;

    public ServicoDTO ( Servico servico ) {
        this.id = servico.getId();
        this.description = servico.getDescription();
        this.value = servico.getValue();
    }

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

    public static List<ServicoDTO> converter ( List<Servico> servicos ) {
        return servicos.stream().map(ServicoDTO::new).collect(Collectors.toList());
    }
}
