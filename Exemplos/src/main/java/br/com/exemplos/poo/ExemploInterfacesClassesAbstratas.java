package br.com.exemplos.poo;

interface OperacoesBancarias {
    void sacar(double valor);
    void depositar(double valor);
}

class ContaCorrenteI implements OperacoesBancarias {
    private String titular;
    private double saldo;

    public ContaCorrenteI(String titular) {
        this.titular = titular;
    }

    public void sacar(double valor) {
        if (saldo >= valor) {
            saldo -= valor;
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    public void depositar(double valor) {
        saldo += valor;
    }

    public double getSaldo() {
        return saldo;
    }
}

class ContaPoupancaI implements OperacoesBancarias {
    private String titular;
    private double saldo;

    public ContaPoupancaI(String titular) {
        this.titular = titular;
    }

    public void sacar(double valor) {
        if (saldo >= valor) {
            saldo -= valor;
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    public void depositar(double valor) {
        saldo += valor;
    }

    public double getSaldo() {
        return saldo;
    }
}

public class ExemploInterfacesClassesAbstratas {
    public static void main(String[] args) {
        OperacoesBancarias conta1 = new ContaCorrenteI("Alice");
        conta1.depositar(1000.0);
        conta1.sacar(300.0);

        OperacoesBancarias conta2 = new ContaPoupancaI("Bob");
        conta2.depositar(1500.0);
        conta2.sacar(200.0);

        System.out.println("Saldo da conta de Alice: R$" + ((ContaCorrenteI) conta1).getSaldo());
        System.out.println("Saldo da conta de Bob: R$" + ((ContaPoupancaI) conta2).getSaldo());
    }
}

