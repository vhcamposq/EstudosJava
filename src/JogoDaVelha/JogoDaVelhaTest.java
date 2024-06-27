package JogoDaVelha;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class JogoDaVelhaTest {
    @Before
    public void setUp() {
        JogoDaVelha.inicializarTabuleiro();
    }

    @Test
    public void testInicializarTabuleiro() {
        char[][] tabuleiro = JogoDaVelha.getTabuleiro();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertEquals(JogoDaVelha.VAZIO, tabuleiro[i][j]);
            }
        }
    }

    @Test
    public void testRealizarJogadaValida() {
        String input = "1\n1\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        JogoDaVelha.realizarJogada();
        char[][] tabuleiro = JogoDaVelha.getTabuleiro();
        assertEquals(JogoDaVelha.JOGADOR_X, tabuleiro[0][0]);
    }

    @Test
    public void testVerificarVitoriaLinha() {
        char[][] tabuleiro = JogoDaVelha.getTabuleiro();
        tabuleiro[0][0] = JogoDaVelha.JOGADOR_X;
        tabuleiro[0][1] = JogoDaVelha.JOGADOR_X;
        tabuleiro[0][2] = JogoDaVelha.JOGADOR_X;
        assertFalse(JogoDaVelha.verificarStatusJogo());
    }

    @Test
    public void testVerificarVitoriaColuna() {
        char[][] tabuleiro = JogoDaVelha.getTabuleiro();
        tabuleiro[0][0] = JogoDaVelha.JOGADOR_X;
        tabuleiro[1][0] = JogoDaVelha.JOGADOR_X;
        tabuleiro[2][0] = JogoDaVelha.JOGADOR_X;
        assertFalse(JogoDaVelha.verificarStatusJogo());
    }

    @Test
    public void testVerificarVitoriaDiagonal() {
        char[][] tabuleiro = JogoDaVelha.getTabuleiro();
        tabuleiro[0][0] = JogoDaVelha.JOGADOR_X;
        tabuleiro[1][1] = JogoDaVelha.JOGADOR_X;
        tabuleiro[2][2] = JogoDaVelha.JOGADOR_X;
        assertFalse(JogoDaVelha.verificarStatusJogo());
    }

    @Test
    public void testVerificarEmpate() {
        char[][] tabuleiro = JogoDaVelha.getTabuleiro();
        tabuleiro[0][0] = JogoDaVelha.JOGADOR_X;
        tabuleiro[0][1] = JogoDaVelha.JOGADOR_O;
        tabuleiro[0][2] = JogoDaVelha.JOGADOR_X;
        tabuleiro[1][0] = JogoDaVelha.JOGADOR_O;
        tabuleiro[1][1] = JogoDaVelha.JOGADOR_X;
        tabuleiro[1][2] = JogoDaVelha.JOGADOR_O;
        tabuleiro[2][0] = JogoDaVelha.JOGADOR_O;
        tabuleiro[2][1] = JogoDaVelha.JOGADOR_X;
        tabuleiro[2][2] = JogoDaVelha.JOGADOR_O;
        assertFalse(JogoDaVelha.verificarStatusJogo());
    }
}
