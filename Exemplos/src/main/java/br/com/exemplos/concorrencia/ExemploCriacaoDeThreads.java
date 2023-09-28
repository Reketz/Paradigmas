package br.com.exemplos.concorrencia;
// Importe a classe Thread
class MinhaThread extends Thread {
    public void run() {
        // Código a ser executado pela thread
        System.out.println("Esta é uma thread executando.");
    }
}

public class ExemploCriacaoDeThreads {
    public static void main(String[] args) {
        // Cria uma instância da thread
        MinhaThread thread = new MinhaThread();

        // Inicia a execução da thread
        thread.start();
    }
}
