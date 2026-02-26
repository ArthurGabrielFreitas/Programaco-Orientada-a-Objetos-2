package arthurMorais_TipoGenerico;

import arthurMorais_TipoGenerico.model.Cidade;
import arthurMorais_TipoGenerico.model.Pessoa;
import arthurMorais_TipoGenerico.model.Vetor;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o tamanho do vetor de pessoas: ");
        int tamanho = scanner.nextInt();
        scanner.nextLine();
        Vetor<Pessoa> vetorPessoas = new Vetor<>(tamanho);

        for (int i = 0; i < tamanho; i++) {
            System.out.print("Digite o nome da pessoa " + (i + 1) + ": ");
            String nome = scanner.nextLine();
            System.out.print("Digite o sexo da pessoa (apenas uma letra) " + (i + 1) + ": ");
            String sexo = scanner.nextLine();
            System.out.print("Digite a naturalidade da pessoa " + (i + 1) + ": ");
            String naturalidade = scanner.nextLine();
            vetorPessoas.set(i, new Pessoa(nome, sexo, naturalidade));
        }

        System.out.print("\nDigite o tamanho do vetor de cidades: ");
        int tamanhoCidades = scanner.nextInt();
        scanner.nextLine();
        Vetor<Cidade> vetorCidades = new Vetor<>(tamanhoCidades);

        for (int i = 0; i < tamanhoCidades; i++) {
            System.out.print("Digite o nome da cidade " + (i + 1) + ": ");
            String nome = scanner.nextLine();
            System.out.print("Digite o adjetivo da cidade " + (i + 1) + ": ");
            String adjetivo = scanner.nextLine();
            System.out.print("Digite o estado da cidade " + (i + 1) + ": ");
            String estado = scanner.nextLine();
            vetorCidades.set(i, new Cidade(nome, adjetivo, estado));
        }

        System.out.print("\nQuantas pessoas deseja validar no sistema? ");
        int quantidadeValidar = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < quantidadeValidar; i++) {
            System.out.print("Digite o nome da pessoa a validar: ");
            String nomeValidar = scanner.nextLine();

            String mensagemDeRetorno = "";
            String sufixoSexual = "";
            String adjetivoCidade = "";
            boolean pessoaEncontrada = false;

            for (int j = 0; j < vetorPessoas.getTamanho(); j++) {
                if (vetorPessoas.get(j).getNome().equalsIgnoreCase(nomeValidar)) {
                    for (int k = 0; k < vetorCidades.getTamanho(); k++) {
                        if (vetorCidades.get(k).getNome().equalsIgnoreCase(vetorPessoas.get(j).getNaturalidade())) {
                            if (vetorPessoas.get(j).getSexo().equalsIgnoreCase("M")) {
                                sufixoSexual = "o";
                            } else if (vetorPessoas.get(j).getSexo().equalsIgnoreCase("F")) {
                                sufixoSexual = "a";
                            } else {
                                sufixoSexual = "x";
                            }
                            if (vetorCidades.get(k).getAdjetivo().contains("/")) {
                                String[] adjetivos = vetorCidades.get(k).getAdjetivo().split("/");
                                if (sufixoSexual.equalsIgnoreCase("o")) {
                                    adjetivoCidade = adjetivos[0];
                                } else if (sufixoSexual.equalsIgnoreCase("a")) {
                                    adjetivoCidade = adjetivos[1];
                                } else {
                                    adjetivoCidade = adjetivos[0] + "/" + adjetivos[1];
                                }
                            } else {
                                adjetivoCidade = vetorCidades.get(k).getAdjetivo();
                            }
                            mensagemDeRetorno = sufixoSexual.toUpperCase() + " " + adjetivoCidade + " " + nomeValidar + " nasceu em " + vetorPessoas.get(j).getNaturalidade() + " - " + vetorCidades.get(k).getEstado() + ".";
                            break;
                        } else {
                            mensagemDeRetorno = nomeValidar + " nasceu em " + vetorPessoas.get(j).getNaturalidade() + ".";
                        }
                    }
                    pessoaEncontrada = true;
                    break;
                }
            }
            if (!pessoaEncontrada) {
                mensagemDeRetorno = nomeValidar + " nasceu em cidade desconhecida.";
            }

            System.out.println(mensagemDeRetorno);
        }
    }
}
