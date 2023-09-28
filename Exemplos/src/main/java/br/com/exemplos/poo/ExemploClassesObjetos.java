package br.com.exemplos.poo;

// Definindo a classe ContaBancaria
class ContaBancaria {
    String titular;
    double saldo;

    void depositar(double valor) {
        saldo += valor;
    }

    void sacar(double valor) {
        if (saldo >= valor) {
            saldo -= valor;
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }
}

public class ExemploClassesObjetos {
    public static void main(String[] args) {
        // Criando objetos da classe ContaBancaria
        ContaBancaria conta1 = new ContaBancaria();
        conta1.titular = "Alice";
        conta1.depositar(1000.0);
        conta1.sacar(300.0);

        ContaBancaria conta2 = new ContaBancaria();
        conta2.titular = "Bob";
        conta2.depositar(1500.0);
        conta2.sacar(200.0);

        System.out.println("Saldo da conta de " + conta1.titular + ": R$" + conta1.saldo);
        System.out.println("Saldo da conta de " + conta2.titular + ": R$" + conta2.saldo);
    }
}
