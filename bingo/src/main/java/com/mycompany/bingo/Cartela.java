package com.mycompany.bingo;

import java.util.*;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

public class Cartela {
    
    List<Numero> columnB = new ArrayList();
    List<Numero> columnI = new ArrayList();
    List<Numero> columnN = new ArrayList();
    List<Numero> columnG = new ArrayList();
    List<Numero> columnO = new ArrayList();
    
    public static int Random(int min, int max){
        return (int)Math.floor(Math.random()*(max-min+1)+min);
    }
    
    public static List<Numero> PreencherColuna(int min, int max, boolean central){
        List<Numero> listaNumero = new ArrayList();
        
        List<Integer> list = new ArrayList();
        boolean contains;
        int number = 0;
        
        System.out.print("ANTES DO FOR");
        for(int i = 0; i < 5; i++){
            number = Random(min,max);
            contains = list.contains(number);
            while(contains){
                number = Random(min,max);
                contains = list.contains(number);
            }
            
            list.add(number);
        }
        
        Collections.sort(list);
        
        for(int i = 0; i < 5; i++){
            if(central && i == 2){
                Numero numero = new Numero(0);
                numero.marcado = true;
                listaNumero.add(numero);
            }else{
                Numero numero = new Numero(list.get(i)); 
                listaNumero.add(numero); 
            }
        }
        
        return listaNumero;
    }
    
    public static boolean ChecarColuna(List<Numero> lista){
        for(int i = 0; i < 5; i++){
            if(!(lista.get(i).marcado)){
                return false;
            }
        }
        return true;
    }
    
    public boolean ChecarVertical()
    {           
        if(ChecarColuna(columnB)){
            return true;
        }
        if(ChecarColuna(columnI)){
            return true;
        }
        if(ChecarColuna(columnN)){
            return true;
        }
        if(ChecarColuna(columnG)){
            return true;
        }
        return ChecarColuna(columnO);
    }
    
    public boolean ChecarHorizontal(){
        for(int i = 0; i < 5; i++){
            if(columnB.get(i).marcado && columnI.get(i).marcado && columnN.get(i).marcado && columnG.get(i).marcado && columnO.get(i).marcado){
                return true;
            }
        }
        return false;
    }
    
    public boolean ChecarLinha(){
        return ChecarHorizontal() || ChecarVertical();
    }
    
    public boolean ChecarCruz(){
        boolean linhaCentral = (columnB.get(2).marcado && columnI.get(2).marcado && columnN.get(2).marcado && columnG.get(2).marcado && columnO.get(2).marcado);
        return linhaCentral && ChecarColuna(columnN);
    }
    
    public void ImprimirElemento(List<Numero> lista, int i){
        if(lista.get(i).numero == 0){
            System.out.print("       ");
        }else{
            System.out.print("[");
            if(lista.get(i).marcado){
                System.out.print("x");
            }else{
                System.out.print(" ");
            }
            
            if(lista.get(i).numero < 10){
                System.out.print("]0" + lista.get(i).numero + "  ");
            }else{
                System.out.print("]" + lista.get(i).numero + "  ");
            } 
        }     
    }
    
    public void Imprimir(){
        
        System.out.println("  B       I     N      G      O");
       
        for(int i = 0; i < 5; i++){
            ImprimirElemento(columnB, i);
            ImprimirElemento(columnI, i);
            ImprimirElemento(columnN, i);
            ImprimirElemento(columnG, i);
            ImprimirElemento(columnO, i);
            System.out.println("");
        }
    }
    
    public void VerificarColuna(List<Numero> lista, int valor, int numJogador){
        for(int i = 0; i < 5; i++){
            if(lista.get(i).numero == valor){
                lista.get(i).marcado = true;
                System.out.println("O jogador " + numJogador + " marcou");
                return;
            }   
        }
    }
    
    public void Verificar(int valor, int numJogador){
        if(valor <= 15){
            VerificarColuna(columnB, valor, numJogador);
        }else if(valor <= 30){
            VerificarColuna(columnI, valor, numJogador);
        }else if(valor <= 45){
            VerificarColuna(columnN, valor, numJogador);
        }else if(valor <= 60){
            VerificarColuna(columnG, valor, numJogador);
        }else if(valor <= 75){
            VerificarColuna(columnO, valor, numJogador);
        }
    }
    
    public Cartela(){
        
        columnB = PreencherColuna(1,15, false);
        columnI = PreencherColuna(16,30, false);
        columnN = PreencherColuna(31,45, true);
        columnG = PreencherColuna(46,60, false);
        columnO = PreencherColuna(61,75, false);   
    }
    
}