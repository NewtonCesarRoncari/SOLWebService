package br.com.web.sol.controller.DTO;

import br.com.web.sol.model.Servico;

import java.util.List;
import java.util.stream.Collectors;

public class ServicoDTO {

    private String idServico;
    private String descricao;
    private Double valor;

    public ServicoDTO ( Servico servico ) {
        this.idServico = servico.getId();
        this.descricao = servico.getDescricao();
        this.valor = servico.getValor();
    }

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

    public static List<ServicoDTO> converter ( List<Servico> servicos ) {
        return servicos.stream().map(ServicoDTO::new).collect(Collectors.toList());
    }
}
