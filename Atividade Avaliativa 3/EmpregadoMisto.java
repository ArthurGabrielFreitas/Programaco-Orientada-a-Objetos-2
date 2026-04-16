public class EmpregadoMisto extends EmpregadoComissionado {
    private double salarioBase;

    EmpregadoMisto(String nome, String sobrenome, String numeroSeguroSocial, double vendasBrutasSemanais,
            double taxaComissao, double salarioBase) {
        super(nome, sobrenome, numeroSeguroSocial, vendasBrutasSemanais, taxaComissao);
        this.salarioBase = validaSalarioBase(salarioBase);
    }

    private double validaSalarioBase(double salarioBase) {
        return salarioBase >= 0.0 ? salarioBase : 0.0;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = validaSalarioBase(salarioBase);
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    @Override
    public double calculaPagamento() {
        return salarioBase + super.calculaPagamento();
    }

    @Override
    public String toString() {
        return "Empregado Horista: " + String.join(" ", getNome(), getSobrenome()) + "\nNúmero do Seguro Social: "
                + getNumeroSeguroSocial() + "\nVendas Brutas Semanais: $"
                + String.format("%.2f", getVendasBrutasSemanais())
                + "; Taxa da Comissão: "
                + String.format("%.2f", getTaxaComissao()) + " Salário Base: $" + String.format("%.2f", salarioBase);
    }
}
