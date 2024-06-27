package JogoDaVelha;

import java.util.Scanner;

public class JogoDaVelha {
    public static final char VAZIO = ' ';
    public static final char JOGADOR_X = 'X';
    public static final char JOGADOR_O = 'O';
    private static char[][] tabuleiro = new char[3][3];
    private static char jogadorAtual = JOGADOR_X;

    public static void main(String[] args) {
        inicializarTabuleiro();
        boolean jogoAtivo = true;

        while (jogoAtivo) {
            imprimirTabuleiro();
            realizarJogada();
            jogoAtivo = verificarStatusJogo();
            alternarJogador();
        }

        imprimirTabuleiro();
        System.out.println("Fim do jogo!");
    }

    public static void inicializarTabuleiro() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tabuleiro[i][j] = VAZIO;
            }
        }
    }

    public static void imprimirTabuleiro() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(tabuleiro[i][j] + " | ");
            }
            System.out.println("\n-------------");
        }
    }

    public static void realizarJogada() {
        Scanner scanner = new Scanner(System.in);
        int linha, coluna;

        while (true) {
            System.out.println("Jogador " + jogadorAtual + ", faça sua jogada (linha e coluna): ");
            linha = scanner.nextInt() - 1;
            coluna = scanner.nextInt() - 1;

            if (linha >= 0 && linha < 3 && coluna >= 0 && coluna < 3 && tabuleiro[linha][coluna] == VAZIO) {
                tabuleiro[linha][coluna] = jogadorAtual;
                break;
            } else {
                System.out.println("Esta posição está inválida ou já ocupada. Tente novamente.");
            }
        }
    }

    public static boolean verificarStatusJogo() {
        // Verificar linhas
        for (int i = 0; i < 3; i++) {
            if (tabuleiro[i][0] == jogadorAtual && tabuleiro[i][1] == jogadorAtual && tabuleiro[i][2] == jogadorAtual) {
                System.out.println("Jogador " + jogadorAtual + " venceu!");
                return false;
            }
        }

        // Verificar colunas
        for (int i = 0; i < 3; i++) {
            if (tabuleiro[0][i] == jogadorAtual && tabuleiro[1][i] == jogadorAtual && tabuleiro[2][i] == jogadorAtual) {
                System.out.println("Jogador " + jogadorAtual + " venceu!");
                return false;
            }
        }

        // Verificar diagonais
        if (tabuleiro[0][0] == jogadorAtual && tabuleiro[1][1] == jogadorAtual && tabuleiro[2][2] == jogadorAtual) {
            System.out.println("Jogador " + jogadorAtual + " venceu!");
            return false;
        }
        if (tabuleiro[0][2] == jogadorAtual && tabuleiro[1][1] == jogadorAtual && tabuleiro[2][0] == jogadorAtual) {
            System.out.println("Jogador " + jogadorAtual + " venceu!");
            return false;
        }

        // Verificar empate
        boolean empate = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tabuleiro[i][j] == VAZIO) {
                    empate = false;
                    break;
                }
            }
        }

        if (empate) {
            System.out.println("O jogo terminou em empate!");
            return false;
        }

        return true;
    }

    public static void alternarJogador() {
        jogadorAtual = (jogadorAtual == JOGADOR_X) ? JOGADOR_O : JOGADOR_X;
    }

    // Métodos auxiliares para testes
    public static char[][] getTabuleiro() {
        return tabuleiro;
    }

    public static char getJogadorAtual() {
        return jogadorAtual;
    }
}
