package br.com.exemplos.excessoes;
public class ExemploEscolhaExcecoesAdequadas {
    public static void main(String[] args) {
        try {
            int[] numeros = new int[3];
            int valor = numeros[5]; // Isso lança uma ArrayIndexOutOfBoundsException
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Índice fora dos limites: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Exceção genérica: " + e.getMessage());
        }
    }
}
