package dcc025.aula2;

import java.util.Scanner;

public class Aula2 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        
        //Instaciando objetos a partir da classe
        
        Caneta c1 = new Caneta();
        System.out.println("Informe a cor da 1ª caneta: ");
        c1.cor = teclado.next();
        c1.modelo = "bic";
        c1.carga = 93;
        c1.ponta = 0.5f;
        //c1.tampada = false;
        c1.destampar();  
        c1.status();
        c1.rabiscar();
        
        /*Caneta c2 = new Caneta();
        System.out.println("Informe a cor da 2ª caneta: ");
        c2.cor = teclado.next();
        c2.modelo = "Faber-Castell";
        c2.carga = 97;
        c2.ponta = 0.5f;
        c2.tampar();
        c2.status();
        c2.rabiscar();*/
        
        Caderno b1 = new Caderno();
        b1.marca = "Tilibra";
        b1.modelo = "Aspiral";
        b1.tamanho = 5;
        b1.usado = 45.2f;
        b1.abrir();
        b1.status();
        b1.rabiscarCaderno();
        
    
        

    }
}
