package dcc025.jogodavelha3d;

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

    public char getValorPosicao(int linha, int coluna, int profundidade) {
        char posicao = this.tabuleiro[linha][coluna][profundidade];
        return posicao;
    }

    public void setValorPosicao(int linha, int coluna, int profundidade, char simbolo) {
        tabuleiro[linha][coluna][profundidade] = simbolo;
    }

    public void imprime() {
        for (int i = 0; i < this.tabuleiro.length; i++) {
            for (int j = 0; j < this.tabuleiro.length; j++) {
                for (int k = 0; k < this.tabuleiro.length; k++) {
                    System.out.print(this.tabuleiro[i][j][k]);
                    if (this.tabuleiro[i][j][k] == '0') {
                        System.out.print(" | ");
                    } else {
                        System.out.print(this.tabuleiro[i][j][k] + " | ");
                    }
                }
                System.out.println("  ");
            }
        }
    }

    public boolean adicionarJogada(Jogador jg) {
        int linha;
        int coluna;
        int profundidade;
        System.out.println("Para adicionar um jogada digite: ");
        System.out.println("camada: , linha: , coluna: ");
        System.out.println("EXEMPLO: (1,2,0)");

        String jogada = "(0,0,0)";
        jogada = teclado.nextLine();
        jogada = jogada.trim();

        if (jogada.matches("\\(\\d{1}+,\\d{1}+,\\d{1}+\\)")) {
            linha = (Integer.parseInt(String.valueOf(jogada.charAt(1)))) - 1;
            coluna = (Integer.parseInt(String.valueOf(jogada.charAt(3)))) - 1;
            profundidade = (Integer.parseInt(String.valueOf(jogada.charAt(5)))) - 1;

            if (linha >= 0 && linha <= 2 && coluna >= 0 && coluna <= 2 && profundidade >= 0 && profundidade <= 2) {
                if (this.tabuleiro[linha][coluna][profundidade] == ' ') {
                    this.tabuleiro[linha][coluna][profundidade] = jg.getSimbolo();
                    return true;
                } else {
                    System.out.println("Posição já ocupada");
                    return false;
                }

            } else {
                System.out.println("Linha ou coluna ou profundidade selecionada nao existe");
                return false;
            }
        } else {
            System.out.println("Digite no formato solicitado");
            return false;
        }
    }

    public void bot(Jogador jg) {
        Random gerador = new Random();
        int lin;
        int col;
        int prof;
        System.out.println("Bot fazendo jogada...");
        lin = gerador.nextInt(3);
        col = gerador.nextInt(3);
        prof = gerador.nextInt(3);
        while (getValorPosicao(lin, col, prof) != '0') {
            lin = gerador.nextInt(3);
            col = gerador.nextInt(3);
            prof = gerador.nextInt(3);
        }

        setValorPosicao(lin, col, prof, jg.getSimbolo());
        System.out.println("Jogada feita pelo bot - linha[ " + (lin + 1) + "] coluna [ " + (col + 1) + "] profundidade [ " + (prof + 1) + "]");
    }
}
