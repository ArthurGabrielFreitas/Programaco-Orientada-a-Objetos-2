public class ContaCoEmpresarial extends ContaCo {
    private double taxaJurosEmprestimo;

    public ContaCoEmpresarial(String titular, double saldo, double taxaRendimento, double taxaJurosEmprestimo) {
        super(titular, saldo, taxaRendimento);
        this.taxaJurosEmprestimo = taxaJurosEmprestimo;
    }

    public boolean solicitaEmprestimo(double valor) {
        if (valor > super.saldo + super.limiteChequeEspecial) {
            return false;
        }
        super.saldo += valor;
        return true;
    }

    @Override
    public String exibeSaldo() {
        return "Saldo da conta empresarial de " + super.titular + ": R$" + String.format("%.2f", super.saldo);
    }
}
