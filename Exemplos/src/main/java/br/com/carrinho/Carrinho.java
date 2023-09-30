package br.com.carrinho;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {

    private List<Item> itens;

    public Carrinho() {
        this.itens = new ArrayList<>();
    }

    public void addItem(Item item) {
        this.itens.add(item);
    }

    public Item getItem(int codigo) throws Exception {
        return this.itens.stream()
                .filter(item -> item.getCodigo() == codigo)
                .findFirst()
                .orElseThrow(() -> new Exception("Item não encontrado!"));
    }

    public List<Item> getItens() {
        return itens;
    }
}
