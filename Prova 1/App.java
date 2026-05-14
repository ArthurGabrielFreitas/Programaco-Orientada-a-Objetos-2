
import exception.CalculoInvalidoException;
import java.util.Scanner;
import model.Colaborador;
import model.Departamento;
import model.Desenvolvedor;
import model.Gerente;
import util.Validacao;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String cpf = scanner.nextLine();

        if (!Validacao.validarCpf(cpf)) {
            System.out.println("CPF informado inválido! Finalizando a aplicação...");
            scanner.close();
            return;
        }
        double salarioLiquidoGerente, salarioLiquidoDesenvolvedor;
        Gerente gerente = new Gerente("Alice", 8000.0, new Departamento("TI"), "Rua Principal, 100");
        gerente.registrarKpi(20);
        Desenvolvedor desenvolvedor = new Desenvolvedor("Bob", 5000.0);

        try {
            salarioLiquidoGerente = gerente.calcularSalarioLiquido();
            salarioLiquidoDesenvolvedor = desenvolvedor.calcularSalarioLiquido();

            System.out.println("--- PROCESSAMENTO DA FOLHA ---\n");
            System.out.println("Salário Líquido Processado: R$" + String.format("%.2f", salarioLiquidoGerente));
            System.out.println("Salário Líquido Processado: R$" + String.format("%.2f", salarioLiquidoDesenvolvedor));

            System.out.println("____________________________");
            System.out.println("Total de colaboradores: " + Colaborador.getTotalColaboradores());
        } catch (CalculoInvalidoException e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }
}
