package br.com.exemplos.concorrencia;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExemploPoolDeThreads {
    public static void main(String[] args) {
        // Cria um pool de threads com 3 threads
        ExecutorService poolDeThreads = Executors.newFixedThreadPool(2);

        // Adiciona tarefas ao pool
        for (int i = 1; i <= 10; i++) {
            final int numero = i;
            poolDeThreads.execute(() -> {
                System.out.println("Impressão " + numero + " executada por Impressora (" + Thread.currentThread().getName() + ")");
                processarTarefa(numero);
            });
        }

        // Encerra o pool após as tarefas serem concluídas
        poolDeThreads.shutdown();
    }

    private static void processarTarefa(int numeroTarefa) {
        // Simula o processamento de uma tarefa
        try {
            Thread.sleep(1000); // Simula uma tarefa que leva 1 segundo para ser concluída
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Impressão " + numeroTarefa + " concluída.");
    }
}
