package br.com.carrinho;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Item {
    private int codigo;
    private String descrica;
    private BigDecimal valor;
    private BigDecimal acrescimo;
    private BigDecimal desconto;

    public Item(int codigo, String descrica, BigDecimal valor) {
        this.codigo = codigo;
        this.descrica = descrica;
        this.valor = valor;
        this.acrescimo = BigDecimal.ZERO;
        this.desconto = BigDecimal.ZERO;
    }
}
