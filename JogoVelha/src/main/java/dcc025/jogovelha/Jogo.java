package dcc025.jogovelha;

import java.util.Scanner;

public class Jogo {

    Menu menu;
    Tabuleiro tabuleiro;
    Jogador j1;
    Jogador j2;
    Scanner teclado = new Scanner(System.in);

    public Jogo() {
        this.tabuleiro = new Tabuleiro();
        this.j1 = new Jogador(1);
        this.j2 = new Jogador(2);
        this.menu = new Menu();
    }

    public void Jogar() {
        menu.inicio(j1, j2);
        int rodada = 0;
        int opt = 0;

        while (!verificaJogo()) {
            if (rodada % 2 == 0) {
                tabuleiro.imprime();
                System.out.println("Jogador: " + j1.getNome());
                System.out.println("Rodada: " + rodada / 2);
                while (!tabuleiro.adicionarJogada(j1)) {
                    System.out.println("Tente adicionar jogada novamente: ");
                }

            } else {
                tabuleiro.imprime();
                System.out.println("Jogador: " + j2.getNome());
                System.out.println("Rodada: " + rodada / 2);
                if (j2.nome.equals("Computador")) {
                    tabuleiro.bot(j2);
                } else {
                    while (!tabuleiro.adicionarJogada(j2)) {
                        System.out.println("Tente adicionar jogada novamente: ");
                    }
                }

            }
            rodada++;

        }
        System.out.println("Deseja jogar novamente? ");
        System.out.println("SIM [1]  SAIR[2]");
        opt = teclado.nextInt();
        if (opt == 1) {
            resetarJogo();
            Jogar();
        } else {
            System.exit(0);
        }
    }

    public void resetarJogo() {
        this.tabuleiro = new Tabuleiro();
        this.j1 = new Jogador(1);
        this.j2 = new Jogador(2);
        this.menu = new Menu();
    }

    public boolean valorIgual(char[] valCol, char simbolo1, char simbolo2) {

        char primeiro = valCol[0];
        int cont = 0;
        for (int i = 0; i < valCol.length; i++) {

            if (primeiro == valCol[i]) {
                cont++;

            }

        }
        if (cont == 3) {
            if (primeiro == simbolo1) {
                tabuleiro.imprime();
                System.out.println("Parabens, " + j1.getNome() + " voce venceu!");
                return true;
            }
            if (primeiro == simbolo2) {
                tabuleiro.imprime();
                System.out.println("Parabens, " + j2.getNome() + " voce venceu!");
                return true;
            }
        }

        return false;

    }

    //------------
    public boolean verificaJogo() {
        boolean fim = false;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                for (int k = 0; k < 9; k++) {
                    if (verificaLinhas(i, j, k)) {
                        return true;
                    }

                    if (verificaDiagonais(i, j, k)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean verificaLinhas(int i, int j, int k) {

        int valorP1H = 0, valorP2H = 0;
        int valorP1V = 0, valorP2V = 0;
        int valorP1P = 0, valorP2P = 0;
        for (int c = 0; c < 3; c++) {
            if (tabuleiro.getValorPosicao(c, j, k) == j1.simbolo) {
                valorP1H++;
            } else if (tabuleiro.getValorPosicao(c, j, k) == j1.simbolo) {
                valorP2H++;
            }

            if (tabuleiro.getValorPosicao(i, c, k) == j1.simbolo) {
                valorP1V++;
            } else if (tabuleiro.getValorPosicao(i, c, k) == j1.simbolo) {
                valorP2V++;
            }

            if (tabuleiro.getValorPosicao(i, j, c) == j1.simbolo) {
                valorP1P++;
            } else if (tabuleiro.getValorPosicao(i, j, c) == j1.simbolo) {
                valorP2P++;
            }
        }

        if (valorP1H == 3 || valorP1V == 3 || valorP1P == 3) {
            //jogador 1 venceu 
            return true;
        }

        if (valorP2H == 3 || valorP2V == 3 || valorP2P == 3) {
            //jogador 2 venceu 
            return true;
        }

        return false;
    }

    private boolean verificaDiagonais(int i, int j, int k) {
        int cont = 0;
        int compl = 0;
        int cam = 0;
        char[] n = new char[3];
        
        //Verifica diagonal principal
        for (int linha = 0; linha < tabuleiro.tabuleiro.length; linha++) {
            for (int col = 0; col < tabuleiro.tabuleiro.length; col++) {

                if (linha == col) {
                    n[cont] = tabuleiro.tabuleiro[cam][linha][col];
                    cont++;

                }
            }

        }
        if (valorIgual(n, j1.simbolo, j2.simbolo)) {
            return true;
        }
        cont = 0;
        //Verifica diagonal secundaria
        int colu = tabuleiro.tabuleiro.length - 1;
        for (int linha = 0; linha < tabuleiro.tabuleiro.length; linha++) {

            n[cont] = tabuleiro.tabuleiro[cam][linha][colu];

            cont++;
            colu--;

        }
        if (valorIgual(n, j1.simbolo, j2.simbolo)) {
            return true;
        }

        for (char[][] tabuleiro1 : tabuleiro.tabuleiro) {
            for (int linha = 0; linha < tabuleiro.tabuleiro.length; linha++) {
                for (int col = 0; col < tabuleiro.tabuleiro.length; col++) {
                    if (tabuleiro1[linha][col] != '0') {
                        compl++;
                    }
                }
            }
        }
        if (compl == 26) {
            System.out.println("Deu velha!");
            return true;
        }
        return false;

    }
    
}
