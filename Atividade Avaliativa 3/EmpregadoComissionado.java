public class EmpregadoComissionado extends Empregado {
    private double vendasBrutasSemanais, taxaComissao;

    EmpregadoComissionado(String nome, String sobrenome, String numeroSeguroSocial, double vendasBrutasSemanais,
            double taxaComissao) {
        super(nome, sobrenome, numeroSeguroSocial);
        this.vendasBrutasSemanais = validaVendasBrutasSemanais(vendasBrutasSemanais);
        this.taxaComissao = validaTaxaComissao(taxaComissao);
    }

    private double validaVendasBrutasSemanais(double vendasBrutasSemanais) {
        return vendasBrutasSemanais >= 0.0 ? vendasBrutasSemanais : 0.0;
    }

    private double validaTaxaComissao(double taxaComissao) {
        return taxaComissao >= 0.0 ? (taxaComissao <= 1.0 ? taxaComissao : 1.0) : 0.0;
    }

    public void setVendasBrutasSemanais(double vendasBrutasSemanais) {
        this.vendasBrutasSemanais = validaTaxaComissao(vendasBrutasSemanais);
    }

    public double getVendasBrutasSemanais() {
        return vendasBrutasSemanais;
    }

    public void setTaxaComissao(double taxaComissao) {
        this.taxaComissao = validaTaxaComissao(taxaComissao);
    }

    public double getTaxaComissao() {
        return taxaComissao;
    }

    @Override
    public double calculaPagamento() {
        return vendasBrutasSemanais * taxaComissao;
    }

    @Override
    public String toString() {
        return "Empregado Horista: " + String.join(" ", getNome(), getSobrenome()) + "\nNúmero do Seguro Social: "
                + getNumeroSeguroSocial() + "\nVendas Brutas Semanais: $" + String.format("%.2f", vendasBrutasSemanais)
                + "; Taxa da Comissão: "
                + String.format("%.2f", taxaComissao);
    }
}
