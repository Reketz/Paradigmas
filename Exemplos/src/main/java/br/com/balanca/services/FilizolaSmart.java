package br.com.balanca.services;

import br.com.balanca.interfaces.IBalanca;
import br.com.balanca.models.Produto;
import exceptions.ArquivoNaoEncontradoException;
import exceptions.ExportacaoFalhaException;
import exceptions.ProdutoFormatException;
import exceptions.ProdutoInvalidoException;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FilizolaSmart implements IBalanca<Produto> {
    @Override
    public void exportar(List<Produto> produtos, String pastaArquivoTxt) {
        File directory = new File(pastaArquivoTxt);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(pastaArquivoTxt + "/CADTXT.TXT"))) {
            for (Produto produto : produtos) {
                String linha = formatarProduto(produto);
                writer.write(linha);
                writer.newLine();
            }
        } catch (Exception e) {
            System.err.println("Erro: " + e);
        }
    }

    private String formatarProduto(Produto produto) {
        String codigo = String.format("%06d", produto.getCodigo());
        String tipo = "9".equals(produto.getTipo()) ? "P" : "U"; // 9 coloquei como se fosse para o peso
        String descricao = String.format("%-22s", produto.getDescricao());
        String preco = String.format("%07d", (int) (produto.getValor() * 100));

        return codigo + tipo + descricao + preco + "000";
    }
}

