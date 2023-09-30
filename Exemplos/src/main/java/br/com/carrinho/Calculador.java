package br.com.carrinho;

import java.math.BigDecimal;

public interface Calculador {
    Item aplicar(Item item, BigDecimal valor);
}
