package br.com.exemplos.concorrencia;
import java.util.concurrent.CountDownLatch;

class Corredor implements Runnable {
    private final String nome;
    private final CountDownLatch barreira;

    public Corredor(String nome, CountDownLatch barreira) {
        this.nome = nome;
        this.barreira = barreira;
    }

    @Override
    public void run() {
        try {
            System.out.println(nome + " está se preparando.");
            Thread.sleep((long) (Math.random() * 1000)); // Simula o tempo de preparação

            System.out.println(nome + " está pronto.");
            barreira.countDown(); // Indica que esta thread está pronta

            barreira.await(); // Aguarda até que todas as threads estejam prontas

            System.out.println(nome + " começou a correr.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class ExemploCountdownLatch {
    public static void main(String[] args) {
        final int numeroCorredores = 5;
        CountDownLatch barreira = new CountDownLatch(numeroCorredores);

        for (int i = 1; i <= numeroCorredores; i++) {
            String nomeCorredor = "Corredor " + i;
            Thread threadCorredor = new Thread(new Corredor(nomeCorredor, barreira));
            threadCorredor.start();
        }

        System.out.println("Finalizando...");
    }
}
