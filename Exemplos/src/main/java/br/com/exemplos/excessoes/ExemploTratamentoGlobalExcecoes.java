package br.com.exemplos.excessoes;
public class ExemploTratamentoGlobalExcecoes {
    public static void main(String[] args) {
        // Define um tratamento global de exceções
        Thread.setDefaultUncaughtExceptionHandler((thread, throwable) -> {
            System.err.println("Exceção não capturada pela thread " + thread.getName() + ": " + throwable.getMessage());
        });

        // Causa uma exceção não tratada
        int resultado = 10 / 0; // Isso lança uma ArithmeticException
    }
}
