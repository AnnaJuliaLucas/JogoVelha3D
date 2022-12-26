package dcc025.jv;

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

  
    public void Jogar()
    {
       menu.inicio(j1,j2);
        int rodada = 0;
        int opt = 0;

        while (!verificaJogo()) {
            if (rodada % 2 == 0) {
                tabuleiro.imprime();
                System.out.println("Jogador: " + j1.getNome());
                System.out.println("Rodada: " + rodada / 2);
                while(!tabuleiro.adicionarJogada(j1))
                {
                    System.out.println("Tente adicionar jogada novamente: ");
                }

            } else {
                tabuleiro.imprime();
                System.out.println("Jogador: " + j2.getNome());
                System.out.println("Rodada: " + rodada / 2);
                if(j2.nome.equals("Computador"))
                    tabuleiro.bot(j2);
                else 
                {
                    while(!tabuleiro.adicionarJogada(j2))
                {
                    System.out.println("Tente adicionar jogada novamente: ");
                }
                }

            }
            rodada++;


        }
        System.out.println("Deseja jogar novamente? ");
        System.out.println("SIM [1]  SAIR[2]");
        opt = teclado.nextInt();
        if(opt == 1)
        {
            resetarJogo();
            Jogar();
        }else{
            System.exit(0);
        }
    }
    
    public void resetarJogo()
    {
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
                System.out.println("Parabens, " + j1.getNome()+" voce venceu");
                return true;
            }
            if (primeiro == simbolo2) {
                tabuleiro.imprime();
                System.out.println("Parabens, " + j2.getNome()+" voce venceu");
                return true;
            }
        }

        return false;

    }


    public  boolean verificaJogo() {
        int cont = 0;
        int compl = 0;
        int prof1 = 0;
        char[] n = new char[3];

        //Verifica Linha
        for (int linha = 0; linha < tabuleiro.tabuleiro.length; linha++) {
            for (int col = 0; col < tabuleiro.tabuleiro.length; col++) {

                n[cont] = tabuleiro.tabuleiro[linha][col][prof1];

                cont++;

                if (col == 2) {
                    if (valorIgual(n, j1.simbolo, j2.simbolo)) {

                        return true;
                    }

                    cont = 0;
                }

            }
        }
        cont = 0;


        //Verifica Coluna
        
        for (int coluna = 0; coluna < tabuleiro.tabuleiro.length; coluna++) {
            for (int lin = 0; lin < tabuleiro.tabuleiro.length; lin++) {

                n[cont] = tabuleiro.tabuleiro[lin][coluna][prof1];

                cont++;

                if (lin == 2) {
                    if (valorIgual(n, j1.simbolo, j2.simbolo)) {

                        return true;
                    }

                    cont = 0;
                }

            }
        }

        // verifica campo

        cont = 0;
        //Verifica diagonal principal
        for (int linha = 0; linha < tabuleiro.tabuleiro.length; linha++) {
            for (int col = 0; col < tabuleiro.tabuleiro.length; col++) {

                if (linha == col) {
                    n[cont] = tabuleiro.tabuleiro[linha][col][prof1];
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

            n[cont] = tabuleiro.tabuleiro[linha][colu][prof1];

            cont++;
            colu--;

        }
        if (valorIgual(n, j1.simbolo, j2.simbolo)) {
                    return true;
                }

        for (int i = 0; i < tabuleiro.tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro.tabuleiro.length; j++) {
                for (int k = 0; k <tabuleiro.tabuleiro.length;k++){
                    if (tabuleiro.tabuleiro[i][j][k] != '0') {
                        compl++;

                    }
                }
            }
        }
        if (compl == 9) {
            System.out.println("Deu velha!");
            return true;
        }

        return false;
    }
}
