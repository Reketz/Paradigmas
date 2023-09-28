package br.com.exemplos.excessoes;
class MinhaExcecaoPersonalizada extends Exception {
    public MinhaExcecaoPersonalizada(String mensagem) {
        super(mensagem);
    }
}

public class ExemploExcecaoPersonalizada {
    public static void main(String[] args) {
        try {
            throw new MinhaExcecaoPersonalizada("Isso é uma exceção personalizada.");
        } catch (MinhaExcecaoPersonalizada e) {
            System.out.println("Exceção personalizada capturada: " + e.getMessage());
        }
    }
}
