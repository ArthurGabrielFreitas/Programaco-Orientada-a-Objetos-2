import java.util.InputMismatchException;
import java.util.Scanner;

public class SistemaBancario {

    private static final GeradorExtratos geradorExtratos = new GeradorExtratos();

    private static int lerOpcao(Scanner scanner) {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            scanner.nextLine();
            return -1;
        }
    }

    private static double lerValor(Scanner scanner, String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                return scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Valor inválido. Digite um número válido.");
                scanner.nextLine();
            }
        }
    }

    private static void exibirMenu() {
        System.out.println("\n--------------------");
        System.out.println("1. Sacar");
        System.out.println("2. Depositar");
        System.out.println("3. Consultar saldo");
        System.out.println("4. Voltar");
        System.out.print("Escolha uma opção: ");
    }

    private static void processarConta(Conta conta, Scanner scanner) {
        while (true) {
            exibirMenu();
            int opcao = lerOpcao(scanner);

            if (opcao == 4) {
                return;
            }

            switch (opcao) {
                case 1:
                    conta.sacar(lerValor(scanner, "Digite o valor a sacar: "));
                    break;
                case 2:
                    conta.depositar(lerValor(scanner, "Digite o valor a depositar: "));
                    break;
                case 3:
                    System.out.println(geradorExtratos.exibeExtrato(conta));
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContaCorrente contaCorrente = new ContaCorrente(0.005);
        ContaPoupanca contaPoupanca = new ContaPoupanca();

        while (true) {
            System.out.println("\n--- Sistema Bancário ---");
            System.out.println("1. Conta Corrente");
            System.out.println("2. Conta Poupança");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = lerOpcao(scanner);
            if (opcao == 3) {
                System.out.println("Saindo...");
                break;
            }

            switch (opcao) {
                case 1:
                    processarConta(contaCorrente, scanner);
                    break;
                case 2:
                    processarConta(contaPoupanca, scanner);
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }

        scanner.close();
    }
}
