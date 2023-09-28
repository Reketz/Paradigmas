package br.com.exemplos.excessoes;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class ExemploExcecoesTempoCompilacao {
    public static void main(String[] args) {
        try {
            // Tentativa de abrir um arquivo inexistente
            FileReader arquivo = new FileReader("arquivo.txt");
        } catch (FileNotFoundException e) {
            // Trata a exceção de arquivo não encontrado
            System.out.println("Arquivo não encontrado: " + e.getMessage());
        }
    }
}
