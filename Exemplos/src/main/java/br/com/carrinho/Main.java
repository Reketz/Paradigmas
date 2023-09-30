package br.com.carrinho;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) throws Exception {
        Carrinho carrinho = new Carrinho();
        CalculadorAcrescimo calculadorAcrescimo = new CalculadorAcrescimo();
        CalculadorDesconto calculadorDesconto = new CalculadorDesconto();

        Item item1 = new Item(1, "Arroz", new BigDecimal("10.0"));
        Item item2 = new Item(2, "Feijão", new BigDecimal("20.0"));

        carrinho.addItem(item1);
        carrinho.addItem(item2);

        //Aplicação de acrescimo em um item
        Item itemBuscado = carrinho.getItem(1);
        calculadorAcrescimo.aplicar(itemBuscado, BigDecimal.TEN);

        //Calculando um desconto total
        BigDecimal valorDescontoTotalDigitado = new BigDecimal("10");
        //Calculo para obter o valor do desconto para distribuir em cada item
        BigDecimal valorDescontoDesmembrado = valorDescontoTotalDigitado.divide(BigDecimal.valueOf(carrinho.getItens().size()));

        //For para aplicar o desconto em todos os itens
        for (Item item : carrinho.getItens()) {
            calculadorDesconto.aplicar(item, valorDescontoDesmembrado);
        }

        //Impressão de venda
        BigDecimal total = new BigDecimal("0");
        BigDecimal totalAcrescimo = new BigDecimal("0");
        BigDecimal totalDesconto = new BigDecimal("0");

        for (Item item : carrinho.getItens()) {
            System.out.println(item);
            total = total.add(item.getValor());
            totalAcrescimo = totalAcrescimo.add(item.getAcrescimo());
            totalDesconto = totalDesconto.add(item.getDesconto());
        }

        System.out.println("Total: " + total);
        System.out.println("Total Acrescimo: " + totalAcrescimo);
        System.out.println("Total Desconto: " + totalDesconto);
    }
}
