package br.com.exemplos.excessoes;
public class ExemploTryCatchBasico {
    public static void main(String[] args) {
        try {
            // Código que pode lançar uma exceção
            int resultado = 10 / 0; // Isso lança uma ArithmeticException
        } catch (ArithmeticException e) {
            // Trata a exceção
            System.out.println("Ocorreu uma exceção: " + e.getMessage());
        }
    }
}
