public class ContaPoupanca implements Conta {
    private double saldo;

    public ContaPoupanca() {
        this.saldo = 0.0;
    }

    @Override
    public void depositar(double valor) {
        if (valor > 0)
            saldo += valor;
        else
            System.out.println("O valor deve ser numérico e maior que 0");
    }

    @Override
    public void sacar(double valor) {
        if (valor > 0) {
            if (valor <= saldo)
                saldo -= valor;
            else
                System.out.println("Saldo insuficiente para o saque.");
        } else
            System.out.println("O valor deve ser numérico e maior que 0");
    }

    @Override
    public double getSaldo() {
        return saldo;
    }
}
