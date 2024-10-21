package br.com.balanca.interfaces;

import java.util.List;

public interface IBalanca<T> {
    void exportar(List<T> produtos, String pastaArquivoTxt);
}
