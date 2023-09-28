package br.com.exemplos.poo;

class ContaBancariaH {
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

class ContaCorrente extends ContaBancariaH {
    private double limiteChequeEspecial;

    public void setLimiteChequeEspecial(double limite) {
        limiteChequeEspecial = limite;
    }

    public double getLimiteChequeEspecial() {
        return limiteChequeEspecial;
    }
}

public class ExemploHeranca {
    public static void main(String[] args) {
        ContaCorrente conta = new ContaCorrente();
        conta.setTitular("Bob");
        conta.depositar(1000.0);
        conta.setLimiteChequeEspecial(500.0);
        conta.sacar(1500.0);

        System.out.println("Saldo da conta de " + conta.getTitular() + ": R$" + conta.getSaldo());
        System.out.println("Limite de Cheque Especial: R$" + conta.getLimiteChequeEspecial());
    }
}
