package br.com.exemplos.concorrencia;
class ContaBancaria {
    private int saldo = 1000; // Saldo inicial de 1000

    public synchronized void depositar(int valor) {
        saldo += valor;
        System.out.println("Depósito de " + valor + " realizado. Saldo total: " + saldo);
    }

    public synchronized void sacar(int valor) {
        if (saldo >= valor) {
            saldo -= valor;
            System.out.println("Saque de " + valor + " realizado. Saldo total: " + saldo);
        } else {
            System.out.println("Saldo insuficiente para saque.");
        }
    }

    public int getSaldo() {
        return saldo;
    }
}

public class ExemploThreadSafety {
    public static void main(String[] args) {
        final ContaBancaria conta = new ContaBancaria();

        Thread threadDeposito = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                conta.depositar(200);
                try {
                    Thread.sleep(100); // Simula um intervalo de tempo entre transações
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread threadSaque = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                conta.sacar(150);
                try {
                    Thread.sleep(150); // Simula um intervalo de tempo entre transações
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        threadDeposito.start();
        threadSaque.start();

        try {
            threadDeposito.join();
            threadSaque.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Saldo final: " + conta.getSaldo());
    }
}
