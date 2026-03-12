import java.util.Scanner;

public class SistemaBancario {
    private static Scanner scanner = new Scanner(System.in);
    private static ContaBancaria contaBancaria = new ContaBancaria("Arnulfo", 1000.0);
    private static ContaCo contaCo = new ContaCo("Salett", 1000.0, 500.0);
    private static ContaCoPremium contaCoPremium = new ContaCoPremium("Doracy", 1000.0, 500.0, 5.0);
    private static ContaCoEmpresarial contaCoEmpresarial = new ContaCoEmpresarial("Maílto", 1000.0, 500.0, 8.0);
    private static ContaPo contaPo = new ContaPo("Chadão", 1000.0, 0.5);
    private static ContaPoEstudantil contaPoEstudantil = new ContaPoEstudantil("Nita", 1000.0, 0.5, 200.0);

    public static void main(String[] args) throws Exception {
        menu();
    }

    public static void menu() {
        boolean continuar = true;
        String[] contas = new String[] { "Conta Bancária", "Conta Corrente", "Conta Corrente Premium",
                "Conta Corrente Empresarial", "Conta Poupança", "Conta Poupança Estudantil" };

        while (continuar) {
            System.out.println("\n========== MENU PRINCIPAL ==========");
            for (int i = 0; i < contas.length; i++) {
                System.out.println("Opção " + (i + 1) + ": " + contas[i]);
            }
            System.out.println("Opção 9: Sair");
            System.out.print("Escolha uma das opções acima: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir quebra de linha

            switch (opcao) {
                case 1:
                    subMenuContaBancaria(contaBancaria);
                    break;
                case 2:
                    subMenuContaCo(contaCo);
                    break;
                case 3:
                    subMenuContaCoPremium(contaCoPremium);
                    break;
                case 4:
                    subMenuContaCoEmpresarial(contaCoEmpresarial);
                    break;
                case 5:
                    subMenuContaPo(contaPo);
                    break;
                case 6:
                    subMenuContaPoEstudantil(contaPoEstudantil);
                    break;
                case 9:
                    System.out.println("Encerrando aplicação...");
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
        scanner.close();
    }

    public static void subMenuContaBancaria(ContaBancaria conta) {
        boolean voltar = false;

        while (!voltar) {
            System.out.println("\n========== SUBMENU - CONTA BANCÁRIA ==========");
            System.out.println("1: Depositar");
            System.out.println("2: Sacar");
            System.out.println("3: Exibir Saldo");
            System.out.println("9: Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            boolean sucesso = false;
            try {
                switch (opcao) {
                    case 1:
                        System.out.print("Informe o valor do depósito: ");
                        double valorDeposito = scanner.nextDouble();
                        scanner.nextLine();
                        sucesso = manipulaDeposito(conta, valorDeposito);
                        break;
                    case 2:
                        System.out.print("Informe o valor do saque: ");
                        double valorSaque = scanner.nextDouble();
                        scanner.nextLine();
                        sucesso = manipulaSaque(conta, valorSaque);
                        break;
                    case 3:
                        sucesso = manipulaExibicao(conta.exibeSaldo());
                        break;
                    case 9:
                        voltar = true;
                        break;
                    default:
                        System.out.println("Opção inválida!");
                }
                if (sucesso && opcao != 9) {
                    System.out.println("✓ Operação realizada com sucesso!");
                    System.out.print("Pressione ENTER para continuar...");
                    scanner.nextLine();
                }
            } catch (MinhasExcecoes e) {
                System.out.println("✗ Erro: " + e.getMessage());
                System.out.print("Pressione ENTER para continuar...");
                scanner.nextLine();
            }
        }
    }

    public static void subMenuContaCo(ContaCo conta) {
        boolean voltar = false;

        while (!voltar) {
            System.out.println("\n========== SUBMENU - CONTA CORRENTE ==========");
            System.out.println("1: Depositar");
            System.out.println("2: Sacar (com limite de cheque especial)");
            System.out.println("3: Exibir Saldo");
            System.out.println("4: Exibir Limite de Cheque Especial");
            System.out.println("9: Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            boolean sucesso = false;
            try {
                switch (opcao) {
                    case 1:
                        System.out.print("Informe o valor do depósito: ");
                        double valorDeposito = scanner.nextDouble();
                        scanner.nextLine();
                        sucesso = manipulaDeposito(conta, valorDeposito);
                        break;
                    case 2:
                        System.out.print("Informe o valor do saque: ");
                        double valorSaque = scanner.nextDouble();
                        scanner.nextLine();
                        sucesso = manipulaSaque(conta, valorSaque);
                        break;
                    case 3:
                        sucesso = manipulaExibicao(conta.exibeSaldo());
                        break;
                    case 4:
                        sucesso = manipulaExibicao(conta.exibeLimiteChequeEspecial());
                        break;
                    case 9:
                        voltar = true;
                        break;
                    default:
                        System.out.println("Opção inválida!");
                }
                if (sucesso && opcao != 9) {
                    System.out.println("✓ Operação realizada com sucesso!");
                    System.out.print("Pressione ENTER para continuar...");
                    scanner.nextLine();
                }
            } catch (MinhasExcecoes e) {
                System.out.println("✗ Erro: " + e.getMessage());
                System.out.print("Pressione ENTER para continuar...");
                scanner.nextLine();
            }
        }
    }

    public static void subMenuContaCoPremium(ContaCoPremium conta) {
        boolean voltar = false;

        while (!voltar) {
            System.out.println("\n========== SUBMENU - CONTA CORRENTE PREMIUM ==========");
            System.out.println("1: Depositar");
            System.out.println("2: Sacar (com limite de cheque especial e cashback)");
            System.out.println("3: Exibir Saldo");
            System.out.println("4: Exibir Limite de Cheque Especial");
            System.out.println("5: Exibir Benefício Premium");
            System.out.println("9: Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            boolean sucesso = false;
            try {
                switch (opcao) {
                    case 1:
                        System.out.print("Informe o valor do depósito: ");
                        double valorDeposito = scanner.nextDouble();
                        scanner.nextLine();
                        sucesso = manipulaDeposito(conta, valorDeposito);
                        break;
                    case 2:
                        System.out.print("Informe o valor do saque: ");
                        double valorSaque = scanner.nextDouble();
                        scanner.nextLine();
                        sucesso = manipulaSaque(conta, valorSaque);
                        break;
                    case 3:
                        sucesso = manipulaExibicao(conta.exibeSaldo());
                        break;
                    case 4:
                        sucesso = manipulaExibicao(conta.exibeLimiteChequeEspecial());
                        break;
                    case 5:
                        sucesso = manipulaExibicao(conta.exibeBeneficioPremium());
                        break;
                    case 9:
                        voltar = true;
                        break;
                    default:
                        System.out.println("Opção inválida!");
                }
                if (sucesso && opcao != 9) {
                    System.out.println("✓ Operação realizada com sucesso!");
                    System.out.print("Pressione ENTER para continuar...");
                    scanner.nextLine();
                }
            } catch (MinhasExcecoes e) {
                System.out.println("✗ Erro: " + e.getMessage());
                System.out.print("Pressione ENTER para continuar...");
                scanner.nextLine();
            }
        }
    }

    public static void subMenuContaCoEmpresarial(ContaCoEmpresarial conta) {
        boolean voltar = false;

        while (!voltar) {
            System.out.println("\n========== SUBMENU - CONTA CORRENTE EMPRESARIAL ==========");
            System.out.println("1: Depositar");
            System.out.println("2: Sacar (com limite de cheque especial)");
            System.out.println("3: Exibir Saldo");
            System.out.println("4: Exibir Limite de Cheque Especial");
            System.out.println("5: Solicitar Empréstimo");
            System.out.println("9: Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            boolean sucesso = false;
            try {
                switch (opcao) {
                    case 1:
                        System.out.print("Informe o valor do depósito: ");
                        double valorDeposito = scanner.nextDouble();
                        scanner.nextLine();
                        sucesso = manipulaDeposito(conta, valorDeposito);
                        break;
                    case 2:
                        System.out.print("Informe o valor do saque: ");
                        double valorSaque = scanner.nextDouble();
                        scanner.nextLine();
                        sucesso = manipulaSaque(conta, valorSaque);
                        break;
                    case 3:
                        sucesso = manipulaExibicao(conta.exibeSaldo());
                        break;
                    case 4:
                        sucesso = manipulaExibicao(conta.exibeLimiteChequeEspecial());
                        break;
                    case 5:
                        System.out.print("Informe o valor do empréstimo: ");
                        double valorEmprestimo = scanner.nextDouble();
                        scanner.nextLine();
                        sucesso = manipulaSolicitaEmprestimo(conta, valorEmprestimo);
                        break;
                    case 9:
                        voltar = true;
                        break;
                    default:
                        System.out.println("Opção inválida!");
                }
                if (sucesso && opcao != 9) {
                    System.out.println("✓ Operação realizada com sucesso!");
                    System.out.print("Pressione ENTER para continuar...");
                    scanner.nextLine();
                }
            } catch (MinhasExcecoes e) {
                System.out.println("✗ Erro: " + e.getMessage());
                System.out.print("Pressione ENTER para continuar...");
                scanner.nextLine();
            }
        }
    }

    public static void subMenuContaPo(ContaPo conta) {
        boolean voltar = false;

        while (!voltar) {
            System.out.println("\n========== SUBMENU - CONTA POUPANÇA ==========");
            System.out.println("1: Depositar");
            System.out.println("2: Sacar");
            System.out.println("3: Exibir Saldo");
            System.out.println("4: Aplicar Rendimento");
            System.out.println("9: Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            boolean sucesso = false;
            try {
                switch (opcao) {
                    case 1:
                        System.out.print("Informe o valor do depósito: ");
                        double valorDeposito = scanner.nextDouble();
                        scanner.nextLine();
                        sucesso = manipulaDeposito(conta, valorDeposito);
                        break;
                    case 2:
                        System.out.print("Informe o valor do saque: ");
                        double valorSaque = scanner.nextDouble();
                        scanner.nextLine();
                        sucesso = manipulaSaque(conta, valorSaque);
                        break;
                    case 3:
                        sucesso = manipulaExibicao(conta.exibeSaldo());
                        break;
                    case 4:
                        sucesso = manipulaAplicarRendimento(conta);
                        break;
                    case 9:
                        voltar = true;
                        break;
                    default:
                        System.out.println("Opção inválida!");
                }
                if (sucesso && opcao != 9) {
                    System.out.println("✓ Operação realizada com sucesso!");
                    System.out.print("Pressione ENTER para continuar...");
                    scanner.nextLine();
                }
            } catch (MinhasExcecoes e) {
                System.out.println("✗ Erro: " + e.getMessage());
                System.out.print("Pressione ENTER para continuar...");
                scanner.nextLine();
            }
        }
    }

    public static void subMenuContaPoEstudantil(ContaPoEstudantil conta) {
        boolean voltar = false;

        while (!voltar) {
            System.out.println("\n========== SUBMENU - CONTA POUPANÇA ESTUDANTIL ==========");
            System.out.println("1: Depositar");
            System.out.println("2: Sacar");
            System.out.println("3: Exibir Saldo");
            System.out.println("4: Aplicar Rendimento");
            System.out.println("5: Exibir Limite de Isenção");
            System.out.println("9: Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            boolean sucesso = false;
            try {
                switch (opcao) {
                    case 1:
                        System.out.print("Informe o valor do depósito: ");
                        double valorDeposito = scanner.nextDouble();
                        scanner.nextLine();
                        sucesso = manipulaDeposito(conta, valorDeposito);
                        break;
                    case 2:
                        System.out.print("Informe o valor do saque: ");
                        double valorSaque = scanner.nextDouble();
                        scanner.nextLine();
                        sucesso = manipulaSaque(conta, valorSaque);
                        break;
                    case 3:
                        sucesso = manipulaExibicao(conta.exibeSaldo());
                        break;
                    case 4:
                        sucesso = manipulaAplicarRendimento(conta);
                        break;
                    case 5:
                        sucesso = manipulaExibicao(conta.exibeLimiteIsencao());
                        break;
                    case 9:
                        voltar = true;
                        break;
                    default:
                        System.out.println("Opção inválida!");
                }
                if (sucesso && opcao != 9) {
                    System.out.println("✓ Operação realizada com sucesso!");
                    System.out.print("Pressione ENTER para continuar...");
                    scanner.nextLine();
                }
            } catch (MinhasExcecoes e) {
                System.out.println("✗ Erro: " + e.getMessage());
                System.out.print("Pressione ENTER para continuar...");
                scanner.nextLine();
            }
        }
    }

    private static boolean manipulaDeposito(ContaBancaria conta, double valor) throws MinhasExcecoes {
        if (valor <= 0) {
            throw new MinhasExcecoes("Valor do depósito deve ser positivo!");
        }
        conta.depositar(valor);
        return true;
    }

    private static boolean manipulaSaque(ContaBancaria conta, double valor) throws MinhasExcecoes {
        if (valor <= 0) {
            throw new MinhasExcecoes("Valor do saque deve ser positivo!");
        }
        boolean resultado = conta.sacar(valor);
        if (!resultado) {
            throw new MinhasExcecoes("Saldo insuficiente para realizar o saque!");
        }
        return true;
    }

    private static boolean manipulaExibicao(String mensagem) throws MinhasExcecoes {
        if (mensagem == null || mensagem.isEmpty()) {
            throw new MinhasExcecoes("Erro ao exibir informações!");
        }
        System.out.println(mensagem);
        return true;
    }

    private static boolean manipulaSolicitaEmprestimo(ContaCoEmpresarial conta, double valor)
            throws MinhasExcecoes {
        if (valor <= 0) {
            throw new MinhasExcecoes("Valor do empréstimo deve ser positivo!");
        }
        boolean resultado = conta.solicitaEmprestimo(valor);
        if (!resultado) {
            throw new MinhasExcecoes("Limite de empréstimo insuficiente!");
        }
        return true;
    }

    private static boolean manipulaAplicarRendimento(ContaPo conta) throws MinhasExcecoes {
        try {
            conta.aplicarRendimento();
            return true;
        } catch (Exception e) {
            throw new MinhasExcecoes("Erro ao aplicar rendimento!");
        }
    }

}

