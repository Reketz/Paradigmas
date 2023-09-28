package br.com.exemplos.excessoes;

public class ExemploHierarquiaExcecoes {
    public static void main(String[] args) {
        try {
            // Tentativa de divisão por zero
            int resultado = 10 / 0; // Isso lança uma ArithmeticException
        } catch (Exception e) {
            // Trata a exceção genérica
            System.out.println("Exceção capturada: " + e.getMessage());
        }
    }
}

