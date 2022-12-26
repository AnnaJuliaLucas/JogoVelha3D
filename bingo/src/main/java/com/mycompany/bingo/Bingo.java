package com.mycompany.bingo;

import java.util.*;
import java.util.Scanner;
    
public class Bingo{
static final List<Integer> listaSorteados = new ArrayList();
static int bingoSize = 75;
static int numeroCartelas;
static int tipoJogo;
static int vencedor;

    public static int Random(){
        int min = 1;
        int max = bingoSize;
        
        return (int)Math.floor(Math.random()*(max-min+1)+min);
    }
    
    public static int RandomBingo(){
        boolean contains;
        
        int newNumber = Random();
        contains = listaSorteados.contains(newNumber);
            
        while(contains){
            newNumber = Random();
            contains = listaSorteados.contains(newNumber);
        }
            
        listaSorteados.add(newNumber);
       
        return newNumber;
    }
    
    public static void ImprimirCartelas(List<Cartela> cartelas){
        int aux;
        for(int x = 0; x < numeroCartelas; x++){
            aux = x+1;
            System.out.println("Cartela " + aux);
            cartelas.get(x).Imprimir();
            System.out.println("");
        }
    }
    
    public static boolean VerificarBingo(List<Cartela> cartelas){
        for(int x = 0; x < numeroCartelas; x++){
            if(tipoJogo == 1){
                if(cartelas.get(x).ChecarLinha()){
                    vencedor = x+1;
                    return true;
                }
            }else{
                if(cartelas.get(x).ChecarCruz()){
                    vencedor = x+1;
                    return true;
                }
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        
        System.out.println("Bem vindo ao Bingo!\nDigite o numero de jogadores:");
        Scanner sc = new Scanner(System.in);
        numeroCartelas = Integer.parseInt(sc.next());
        
        while(numeroCartelas < 0 || numeroCartelas > 100){
            System.out.println("Numero invalido ou muito grande (limite: 100)!\nDigite o numero de jogadores:");
            numeroCartelas = Integer.parseInt(sc.next());
        }
        
        List<Cartela> cartelas = new ArrayList();
        
        for(int x = 0; x < numeroCartelas; x++){
            Cartela cartela = new Cartela();
            cartelas.add(cartela);
        }
        
        System.out.println("Digite o modo de jogo:\n1 - Linha\n2 - Cruz");
        tipoJogo = Character.getNumericValue(sc.next().charAt(0));
        
        while(tipoJogo != 1 && tipoJogo != 2){
            System.out.println("Modo invalido!\nDigite o modo de jogo:\n1 - Linha\n2 - Cruz");
            tipoJogo = Character.getNumericValue(sc.next().charAt(0));
        }
        
        System.out.println("");
        
        ImprimirCartelas(cartelas);
        
        boolean continuar = true;
        char resposta;
        int newNumber = 0;
        
        while(continuar && listaSorteados.size() <= bingoSize){
            System.out.println("Deseja continuar? (S/N)");
            resposta = sc.next().charAt(0);
            
            while(resposta != 'S' && resposta != 's' && resposta != 'n' && resposta != 'N'){
                System.out.println("Entrada invalida");
                resposta = sc.next().charAt(0);
            }
            
            if(resposta == 'N' || resposta == 'n'){
                break;
            }
            
            newNumber = RandomBingo();
            System.out.println("O numero sorteado foi: " + newNumber);
            
            for(int x = 0; x < numeroCartelas; x++){
                cartelas.get(x).Verificar(newNumber, x+1);
            }
            
            System.out.println("");
            
            ImprimirCartelas(cartelas);
            if(VerificarBingo(cartelas)){
                System.out.println("Fim de jogo! Vitoria da cartela " + vencedor);
                break;
            }
        }
    }
}