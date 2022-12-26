
package dcc025.jogodavelha3d;
import java.util.Scanner;

public class Menu {
    Scanner teclado = new Scanner(System.in);

    public Menu() {

    }

    public void inicio(Jogador j1,Jogador j2)
    {
        String opcao;
        System.out.println("Seja bem-vindo ao jogo da velha!");
        System.out.println("Você deseja jogar contra um humano[1] ou contra um bot [2]? ");
        opcao = teclado.nextLine();
        if (Integer.parseInt(opcao) == 1) {
            System.out.println("Jogador 1 : Digite seu nome");
            j1.setNome(teclado.nextLine());
            System.out.println("Jogador 1 : Digite seu simbolo");
            j1.setSimbolo(teclado.nextLine().charAt(0));

            System.out.println("Jogador 2 : Digite seu nome");
            j2.setNome(teclado.nextLine());
            System.out.println("Jogador 2 : Digite seu simbolo");
            j2.setSimbolo(teclado.nextLine().charAt(0));
            while(j1.getSimbolo() == j2.getSimbolo())
            {
                System.out.println("Simbolo ja escolhido favor escolher diferente: ");
                j2.setSimbolo(teclado.nextLine().charAt(0));
            }
            
            
            

        } else {
            if (Integer.parseInt(opcao) == 2) {
                System.out.println("Jogador 1 : Digite seu nome");
                j1.setNome(teclado.nextLine());
                System.out.println("Jogador 1 : Digite seu simbolo");
                j1.setSimbolo(teclado.nextLine().charAt(0));
                while(j1.getSimbolo() != 'x' && j1.getSimbolo() != 'o')
                {
                    System.out.println("Favor escolher entre x ou o : ");
                    j1.setSimbolo(teclado.nextLine().charAt(0));
                }
               j2.setNome("Computador");
                if(j1.getSimbolo() == 'x')j2.setSimbolo('o');
                if(j1.getSimbolo() == 'o')j2.setSimbolo('x');
                
            } else {
                System.out.println("Opcao Invalida, digite 1 ou 2");
            }
        }
        
    }
}
