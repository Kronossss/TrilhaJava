package com.leilao.leilao.controller.DTO;

import java.math.BigDecimal;

import com.leilao.leilao.model.Leilao;

public class LeilaoDTO {
    
    private String descricao;
    private BigDecimal valorMinimo;
    private Boolean status;

    public LeilaoDTO(Leilao leilao) {
        this.descricao = leilao.getDescricao();
        this.valorMinimo = leilao.getValorMinimo();
        this.status = leilao.getStatus();
    }

    public String getDescricao() {
        return descricao;
    }

    public BigDecimal getValorMinimo() {
        return valorMinimo;
    }

    public Boolean getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "{" + "descricao=" + descricao + ", valorMinimo=" + valorMinimo + ", status=" + status + '}';
    }
}
