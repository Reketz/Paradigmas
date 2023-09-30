package br.com.carrinho;

import java.math.BigDecimal;

public class CalculadorAcrescimo implements Calculador{
    @Override
    public Item aplicar(Item item, BigDecimal valor) {
        item.setAcrescimo(item.getAcrescimo().add(valor));
        item.setValor(item.getValor().add(valor));
        return item;
    }
}
