package br.com.exemplos.concorrencia;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExemploPoolDeThreads2 {
    public static void main(String[] args) {
        // Cria um pool com 3 threads
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Envia 5 tarefas para serem executadas no pool de threads
        for (int i = 1; i <= 5; i++) {
            Runnable worker = new WorkerThread("Tarefa " + i);
            executor.execute(worker); // Executa a tarefa usando uma thread do pool
        }

        // Solicita ao executor para não aceitar novas tarefas e para encerrar após a execução das tarefas pendentes
        executor.shutdown();

        try {
            // Aguarda até que todas as tarefas sejam concluídas
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                executor.shutdownNow(); // Força o encerramento das tarefas pendentes
            }
        } catch (InterruptedException e) {
            executor.shutdownNow(); // Força o encerramento em caso de interrupção
        }

        System.out.println("Todas as tarefas foram concluídas.");
    }
}

class WorkerThread implements Runnable {
    private final String taskName;

    public WorkerThread(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " está executando " + taskName);
        try {
            Thread.sleep(2000); // Simula algum processamento
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " completou " + taskName);
    }
}
