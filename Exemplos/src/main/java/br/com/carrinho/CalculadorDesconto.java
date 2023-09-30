package br.com.carrinho;

import java.math.BigDecimal;

public class CalculadorDesconto implements Calculador{
    @Override
    public Item aplicar(Item item, BigDecimal valor) {
        item.setDesconto(item.getDesconto().add(valor));
        item.setValor(item.getValor().subtract(valor));
        return item;
    }
}
