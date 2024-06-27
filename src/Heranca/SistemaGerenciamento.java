package Heranca;

import java.util.Scanner;

public class SistemaGerenciamento {
    private static GerenciadorVeiculos gerenciador = new GerenciadorVeiculos();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean sair = false;

        while (!sair) {
            exibirMenu();
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1:
                    adicionarCarro();
                    break;
                case 2:
                    adicionarMoto();
                    break;
                case 3:
                    gerenciador.listarVeiculos();
                    break;
                case 4:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void exibirMenu() {
        System.out.println("\nSistema de Gerenciamento de Veículos");
        System.out.println("1. Adicionar Carro");
        System.out.println("2. Adicionar Moto");
        System.out.println("3. Listar Veículos");
        System.out.println("4. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void adicionarCarro() {
        System.out.print("Marca: ");
        String marca = scanner.nextLine();
        System.out.print("Modelo: ");
        String modelo = scanner.nextLine();
        System.out.print("Ano: ");
        int ano = scanner.nextInt();
        System.out.print("Número de Portas: ");
        int numeroPortas = scanner.nextInt();
        scanner.nextLine(); // Limpar buffer

        Carro carro = new Carro(marca, modelo, ano, numeroPortas);
        gerenciador.adicionarVeiculo(carro);
        System.out.println("Carro adicionado com sucesso!");
    }

    private static void adicionarMoto() {
        System.out.print("Marca: ");
        String marca = scanner.nextLine();
        System.out.print("Modelo: ");
        String modelo = scanner.nextLine();
        System.out.print("Ano: ");
        int ano = scanner.nextInt();
        System.out.print("Tem carro lateral (true/false): ");
        boolean temCarroLateral = scanner.nextBoolean();
        scanner.nextLine(); // Limpar buffer

        Moto moto = new Moto(marca, modelo, ano, temCarroLateral);
        gerenciador.adicionarVeiculo(moto);
        System.out.println("Moto adicionada com sucesso!");
    }
}
