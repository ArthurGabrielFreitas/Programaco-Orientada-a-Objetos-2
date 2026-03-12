public class ContaPoEstudantil extends ContaPo {
    private double limiteIsencaoTaxa;

    public ContaPoEstudantil(String titular, double saldo, double taxaRendimento, double limiteIsencaoTaxa) {
        super(titular, saldo, taxaRendimento);
        this.limiteIsencaoTaxa = limiteIsencaoTaxa;
    }

    @Override
    public boolean sacar(double valor) {
        if (valor > super.saldo) {
            return false;
        }
        super.saldo -= valor;
        return true;
    }

    public String exibeLimiteIsencao() {
        return "Limite de isenção de taxa para estudantes: R$" + String.format("%.2f", super.saldo);
    }
}
