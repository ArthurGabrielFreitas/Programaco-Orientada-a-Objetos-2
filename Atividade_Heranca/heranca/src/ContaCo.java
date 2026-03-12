public class ContaCo extends ContaBancaria {
    protected double limiteChequeEspecial;

    public ContaCo(String titular, double saldo, double limiteChequeEspecial) {
        super(titular, saldo);
        this.limiteChequeEspecial = limiteChequeEspecial;
    }

    @Override
    public boolean sacar(double valor) {
        if (valor > super.saldo + this.limiteChequeEspecial) {
            return false;
        }
        super.saldo -= valor;
        return true;
    }

    public String exibeLimiteChequeEspecial() {
        return "Limite de Cheque Especial: R$" + String.format("%.2f", this.limiteChequeEspecial);
    }
}
