package br.com.exemplos.concorrencia;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class ExemploBarreiraCiclica {
    public static void main(String[] args) {
        // Define o número de threads que devem esperar pela barreira.
        final int NUM_THREADS = 3;

        // Cria um CyclicBarrier para 3 threads, com uma ação opcional que será executada quando todas as threads atingirem a barreira.
        CyclicBarrier barrier = new CyclicBarrier(NUM_THREADS, () -> {
            System.out.println("Finalizando...");
        });

        // Cria e inicia 3 threads.
        for (int i = 0; i < NUM_THREADS; i++) {
            Thread worker = new Thread(new WorkerBarrier(barrier), "Worker-" + i);
            worker.start();
        }
    }
}

class WorkerBarrier implements Runnable {
    private final CyclicBarrier barrier;

    public WorkerBarrier(CyclicBarrier barrier) {
        this.barrier = barrier;
    }

    @Override
    public void run() {
        try {
            // Simula uma tarefa que leva um tempo para ser concluída.
            System.out.println(Thread.currentThread().getName() + " está executando sua tarefa.");
            Thread.sleep((long) (Math.random() * 1000 + 500)); // Pausa de 500 a 1500ms.
            System.out.println(Thread.currentThread().getName() + " terminou sua tarefa e está aguardando na barreira.");

            // Aguarda as outras threads na barreira.
            barrier.await();

            // Após todas as threads alcançarem a barreira, elas continuam a execução.
            System.out.println(Thread.currentThread().getName() + " passou da barreira e continua a execução.");
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
