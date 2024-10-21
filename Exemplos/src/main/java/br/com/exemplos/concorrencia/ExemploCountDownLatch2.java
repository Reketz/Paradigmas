package br.com.exemplos.concorrencia;

import java.util.concurrent.CountDownLatch;

public class ExemploCountDownLatch2 {
    public static void main(String[] args) {
        // Inicializa o CountDownLatch com o valor 3, indicando que 3 threads precisam completar suas tarefas.
        CountDownLatch latch = new CountDownLatch(3);

        // Criação de três threads de trabalho.
        Thread worker1 = new Thread(new Worker(latch), "Worker-1");
        Thread worker2 = new Thread(new Worker(latch), "Worker-2");
        Thread worker3 = new Thread(new Worker(latch), "Worker-3");

        // Inicia as threads.
        worker1.start();
        worker2.start();
        worker3.start();

        try {
            // A thread principal espera até que todas as threads de trabalho concluam suas tarefas.
            latch.await();
            System.out.println("Todas as threads completaram suas tarefas. Continuando...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



    }
}

class Worker implements Runnable {
    private final CountDownLatch latch;

    public Worker(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            // Simula uma tarefa que leva um tempo para ser concluída.
            System.out.println(Thread.currentThread().getName() + " está executando a tarefa.");
            Thread.sleep(2000); // Pausa de 2 segundos.
            System.out.println(Thread.currentThread().getName() + " completou a tarefa.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Chama countDown() para sinalizar que esta thread completou sua tarefa.
            latch.countDown();
        }
    }
}
