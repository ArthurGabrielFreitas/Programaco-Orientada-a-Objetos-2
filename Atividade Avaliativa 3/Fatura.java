public class Fatura implements Pagavel {
    private final String numeroPeca, descricaoPeca;
    private int quantidade;
    private double precoItem;

    Fatura(String numeroPeca, String descricaoPeca, int quantidade, double precoItem) {
        this.numeroPeca = numeroPeca;
        this.descricaoPeca = descricaoPeca;
        this.quantidade = validaQuantidade(quantidade);
        this.precoItem = validaPrecoItem(precoItem);
    }

    private int validaQuantidade(int quantidade) {
        return quantidade >= 0 ? quantidade : 0;
    }

    private double validaPrecoItem(double precoItem) {
        return precoItem >= 0.0 ? precoItem : 0.0;
    }

    public String getNumeroPeca() {
        return numeroPeca;
    }

    public String getDescricaoPeca() {
        return descricaoPeca;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = validaQuantidade(quantidade);
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setPrecoItem(int precoItem) {
        this.precoItem = validaPrecoItem(precoItem);
    }

    public double getPrecoItem() {
        return precoItem;
    }

    @Override
    public double calculaPagamento() {
        return quantidade * precoItem;
    }
}
