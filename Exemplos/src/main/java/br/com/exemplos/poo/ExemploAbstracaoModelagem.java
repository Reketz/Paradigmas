package br.com.exemplos.poo;

abstract class ContaBancariaA {
    private String titular;
    protected double saldo;

    public abstract void sacar(double valor);

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

class ContaCorrenteA extends ContaBancariaA {
    public void sacar(double valor) {
        if (getSaldo() >= valor) {
            super.saldo -= valor;
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    public void depositar(double valor) {
        if(valor > 1) {
            valor = valor - 0.50;
            super.saldo += valor;
        } else {
            System.out.println("Valor mínimo para deposito não atingido.");
        }
    }
}

class ContaPoupancaA extends ContaBancariaA {
    public void sacar(double valor) {
        if (getSaldo() >= valor) {
            super.saldo -= valor;
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    public void depositar(double valor) {
        super.saldo += valor;
    }
}

public class ExemploAbstracaoModelagem {
    public static void main(String[] args) {
        ContaBancariaA conta1 = new ContaCorrenteA();
        conta1.setTitular("Alice");
        ((ContaCorrenteA) conta1).depositar(1000.0);
        conta1.sacar(300.0);

        ContaBancariaA conta2 = new ContaPoupancaA();
        conta2.setTitular("Bob");
        ((ContaPoupancaA) conta2).depositar(1500.0);
        conta2.sacar(200.0);

        System.out.println("Saldo da conta de " + conta1.getTitular() + ": R$" + conta1.getSaldo());
        System.out.println("Saldo da conta de " + conta2.getTitular() + ": R$" + conta2.getSaldo());
    }
}
