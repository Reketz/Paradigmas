package br.com.exemplos.concorrencia;
class Contador {
    private int valor = 0;

    public void incrementar() {
        valor++;
    }

    public void decrementar() {
        valor--;
    }

    public int getValor() {
        return valor;
    }
}

public class ExemploConcorrenciaProblemas {
    public static void main(String[] args) {
        Contador contador = new Contador();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                contador.incrementar();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                contador.decrementar();
            }
        });

        t1.start();
        t2.start();

        // Aguarda as threads terminarem
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Valor final: " + contador.getValor());
    }
}
