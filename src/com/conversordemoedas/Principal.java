package com.conversordemoedas;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Conversor conversor = new Conversor();

        System.out.println("Bem-vindo ao Conversor de Moedas!");
        while (true) {
            System.out.println("Selecione uma opção:");
            System.out.println("1. Converter USD para EUR");
            System.out.println("2. Converter EUR para USD");
            System.out.println("3. Converter ARS para USD");
            System.out.println("4. Converter USD para ARS");
            System.out.println("5. Converter BRL para USD");
            System.out.println("6. Converter USD para BRL");
            System.out.println("7. Sair");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> {
                    System.out.print("Digite o valor em USD: ");
                    double quantidade = scanner.nextDouble();
                    conversor.converter("USD", "EUR", quantidade);
                }
                case 2 -> {
                    System.out.print("Digite o valor em EUR: ");
                    double quantidade = scanner.nextDouble();
                    conversor.converter("EUR", "USD", quantidade);
                }
                case 3 -> {
                    System.out.print("Digite o valor em ARS: ");
                    double quantidade = scanner.nextDouble();
                    conversor.converter("ARS", "USD", quantidade);
                }
                case 4 -> {
                    System.out.print("Digite o valor em USD: ");
                    double quantidade = scanner.nextDouble();
                    conversor.converter("USD", "ARS", quantidade);
                }
                case 5 -> {
                    System.out.print("Digite o valor em BRL: ");
                    double quantidade = scanner.nextDouble();
                    conversor.converter("BRL", "USD", quantidade);
                }
                case 6 -> {
                    System.out.print("Digite o valor em USD: ");
                    double quantidade = scanner.nextDouble();
                    conversor.converter("USD", "BRL", quantidade);
                }

                case 7 -> {
                    System.out.println("Obrigado por usar o Conversor de Moedas! Até logo!");
                    System.exit(0);
                }
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
