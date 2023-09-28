package br.com.exemplos.poo;

class ContaBancariaP {
    private String titular;
    private double saldo;

    public void depositar(double valor) {
        saldo += valor;
    }

    public void sacar(double valor) {
        if (saldo >= valor) {
            saldo -= valor;
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    public double getSaldo() {
        return saldo;
    }

    public void setTitular(String novoTitular) {
        titular = novoTitular;
    }

    public String getTitular() {
        return titular;
    }
}

class ContaPoupanca extends ContaBancariaP {
    // Implementação específica para Conta Poupança
}

public class ExemploPolimorfismo {
    public static void main(String[] args) {
        ContaBancariaP conta1 = new ContaBancariaP();
        conta1.setTitular("Alice");
        conta1.depositar(1000.0);

        ContaBancariaP conta2 = new ContaPoupanca();
        conta2.setTitular("Bob");
        conta2.depositar(1500.0);

        conta1.sacar(300.0);
        conta2.sacar(200.0);

        System.out.println("Saldo da conta de " + conta1.getTitular() + ": R$" + conta1.getSaldo());
        System.out.println("Saldo da conta de " + conta2.getTitular() + ": R$" + conta2.getSaldo());
    }
}
