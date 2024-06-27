package AdivinhaNumero;

import java.util.Random;
import java.util.Scanner;

public class JogoAdivinhacao {
    private static final int MAX_TENTATIVAS = 5;
    private static final int LIMITE_NUMERO = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int numeroSecreto = random.nextInt(LIMITE_NUMERO) + 1; // Número entre 1 e 100
        int tentativas = 0;
        boolean acertou = false;

        System.out.println("=== Jogo de Adivinhação ===");
        System.out.println("Tente adivinhar o número entre 1 e " + LIMITE_NUMERO);
        System.out.println("Você tem " + MAX_TENTATIVAS + " tentativas.\n");

        while (tentativas < MAX_TENTATIVAS && !acertou) {
            System.out.print("Digite seu palpite: ");
            int palpite = obterPalpite(scanner);

            tentativas++;

            if (palpite == numeroSecreto) {
                acertou = true;
                System.out.println("Parabéns! Você adivinhou o número em " + tentativas + " tentativas.");
            } else if (palpite < numeroSecreto) {
                System.out.println("O número secreto é maior. Tentativas restantes: " + (MAX_TENTATIVAS - tentativas));
            } else {
                System.out.println("O número secreto é menor. Tentativas restantes: " + (MAX_TENTATIVAS - tentativas));
            }
        }

        if (!acertou) {
            System.out.println("Que pena! Você não conseguiu adivinhar o número. O número secreto era " + numeroSecreto + ".");
        }

        scanner.close();
    }

    private static int obterPalpite(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.print("Entrada inválida. Digite um número: ");
            scanner.next();
        }
        return scanner.nextInt();
    }
}
