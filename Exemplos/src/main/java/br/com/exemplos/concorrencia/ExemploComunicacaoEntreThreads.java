package br.com.exemplos.concorrencia;
import java.util.LinkedList;
import java.util.Queue;

class FilaCompartilhada {
    private Queue<Integer> fila = new LinkedList<>();
    private final int CAPACIDADE = 5;

    public synchronized void produzir(int valor) throws InterruptedException {
        while (fila.size() == CAPACIDADE) {
            // A fila está cheia, a thread produtora aguarda.
            wait();
        }
        fila.offer(valor);
        //String nomeDaThread = Thread.currentThread().getName();
        System.out.println("Produzido: " + valor + " Thread ");
        notify(); // Notifica a thread consumidora.
    }

    public synchronized int consumir() throws InterruptedException {
        while (fila.isEmpty()) {
            // A fila está vazia, a thread consumidora aguarda.
            wait();
        }
        int valor = fila.poll();
        //String nomeDaThread = Thread.currentThread().getName();
        System.out.println("Consumido: " + valor + " Thread ");
        notify(); // Notifica a thread produtora.
        return valor;
    }
}

public class ExemploComunicacaoEntreThreads {
    public static void main(String[] args) {
        final FilaCompartilhada filaCompartilhada = new FilaCompartilhada();

        Thread produtora = new Thread(() -> {
            for (int i = 1; i <= 100; i++) {
                try {
                    filaCompartilhada.produzir(i);
                    Thread.sleep(100); // Simula a produção de dados
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread consumidora = new Thread(() -> {
            for (int i = 1; i <= 100; i++) {
                try {
                    int caixa = filaCompartilhada.consumir();
                    //System.out.println("Consumiu o caixa: " + caixa);
                    Thread.sleep(800); // Simula o consumo de dados
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        produtora.start();
        consumidora.start();

        try {
            produtora.join();
            consumidora.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
