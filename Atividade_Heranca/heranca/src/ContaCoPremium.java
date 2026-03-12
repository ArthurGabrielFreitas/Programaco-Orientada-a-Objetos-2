public class ContaCoPremium extends ContaCo {
    private double cashBackPercentual;

    public ContaCoPremium(String titular, double saldo, double limiteChequeEspecial, double cashBackPercentual) {
        super(titular, saldo, limiteChequeEspecial);
        this.cashBackPercentual = cashBackPercentual;
    }

    @Override
    public boolean sacar(double valor) {
        if (valor > super.saldo + super.limiteChequeEspecial) {
            return false;
        }
        super.saldo -= valor;
        super.saldo += valor * (this.cashBackPercentual / 100);
        return true;
    }

    public String exibeBeneficioPremium() {
        return "Conta Corrente Premium com cashback de " + this.cashBackPercentual + "% em cada saque";
    }
}
