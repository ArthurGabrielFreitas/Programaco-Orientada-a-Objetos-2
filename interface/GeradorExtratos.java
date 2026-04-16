public class GeradorExtratos {
    String exibeExtrato(Conta conta){
        return "O saldo da sua conta é R$" + String.format("%.2f", conta.getSaldo());
    }
}
