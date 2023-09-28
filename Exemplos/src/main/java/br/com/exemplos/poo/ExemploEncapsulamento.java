package br.com.exemplos.poo;

class ContaBancariaE {
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

public class ExemploEncapsulamento {
    public static void main(String[] args) {
        ContaBancariaE conta = new ContaBancariaE();
        conta.setTitular("Alice");
        conta.depositar(1000.0);
        conta.sacar(300.0);

        System.out.println("Saldo da conta de " + conta.getTitular() + ": R$" + conta.getSaldo());
    }
}
