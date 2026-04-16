public class ContaCorrente implements Conta {
    private double saldo;
    private final double taxa;

    public ContaCorrente(double taxa) {
        this.saldo = 0.0;
        if (taxa <= 0) {
            System.err.println("A taxa não pode ser menor ou igual a 0. Taxa definida em 0.001");   
            this.taxa = 0.001; 
        } else if (taxa > 0.2) {
            System.err.println("A taxa não pode ser maior que 0.2. Taxa definida em 0.2");   
            this.taxa = 0.2;
        } else
            this.taxa = taxa;
    }

    @Override
    public void depositar(double valor) {
        if (valor > 0){    
            saldo += valor;
            cobrarTaxa();
        }
        else
            System.err.println("O valor deve ser numérico e maior que 0");
    }

    @Override
    public void sacar(double valor) {
        if (valor > 0) {
            if (valor <= saldo){
                saldo -= valor;
                cobrarTaxa();
            } else
                System.err.println("Saldo insuficiente para o saque.");
        } else
            System.err.println("O valor deve ser numérico e maior que 0");
    }

    @Override
    public double getSaldo() {
        return saldo;
    }

    private void cobrarTaxa(){
        saldo *= 1 - taxa;
    }
}
