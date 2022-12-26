package dcc025.jogovelha;

import java.util.Random;
import java.util.Scanner;

public class Tabuleiro {

    char[][][] tabuleiro = new char[3][3][3];
    Scanner teclado = new Scanner(System.in);

    public Tabuleiro() {
        for (int i = 0; i < this.tabuleiro.length; i++) {
            for (int j = 0; j < this.tabuleiro.length; j++) {
                for (int k = 0; k < tabuleiro.length; k++) {
                    this.tabuleiro[i][j][k] = ' ';
                }
            }
        }
    }

    public char getValorPosicao(int camada, int linha, int coluna) {
        char posicao = this.tabuleiro[camada][linha][coluna];
        return posicao;
    }

    public void setValorPosicao(int camada, int linha, int coluna, char simbolo) {
        tabuleiro[camada][linha][coluna] = simbolo;
    }

    public void imprime() {
        for (int i = 0; i < this.tabuleiro.length; i++) {

            System.out.printf("%d# ", i + 1);
            for (int k = 0; k < this.tabuleiro.length; k++) {
                for (int j = 0; j < this.tabuleiro.length; j++) {
                    System.out.printf("%c   ", this.tabuleiro[i][j][k]);
                }
                System.out.printf("   ");
            }

            System.out.println("");
        }

        System.out.println("");
        System.out.println("Jogador Atual: ");
    }

    public boolean adicionarJogada(Jogador jg) {
        int camada;
        int linha;
        int coluna;
        System.out.println("Para adicionar um jogada digite: ");
        System.out.println("(camada,linha,coluna) ");
        System.out.println("EXEMPLO: (1,2,0)");

        String jogada = "(0,0,0)";
        jogada = teclado.nextLine();
        jogada = jogada.trim();
        return false;
    }

    public void bot(Jogador j2) {
        Random gerador = new Random();
        int cam;
        int lin;
        int col;
        System.out.println("Bot fazendo jogada...");
        lin = gerador.nextInt(3);
        col = gerador.nextInt(3);
        cam = gerador.nextInt(3);
        while (getValorPosicao(cam, lin, col) != '0') {
            lin = gerador.nextInt(3);
            col = gerador.nextInt(3);
            cam = gerador.nextInt(3);
        }

        setValorPosicao(cam, lin, col, j2.getSimbolo());
        System.out.println("Jogada feita pelo bot - camada[ " + (cam + 1) + "] linha [ " + (lin + 1) + "] camada [ " + (cam + 1) + "]");
    }
}


