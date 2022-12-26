/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon;
/**
 *Classe que determina como a batalha funciona
 * @author ice
 */
public class Batalha {

    private Pokemon p1;
    private Pokemon p2;
    private Treinador t1;
    private Treinador t2;
    private int vez = 1;
     
    /**
     *inicializa os treinadores
     * @param t1 time 1
     * @param t2 time 2
     */
    public Batalha(Treinador t1 , Treinador t2) {
        this.t1 = t1;
        this.t2 = t2;
    }
    
    /**
     *
     */
    
    public Batalha(){
        
    }
    
    /**
     *funcao que roda a batalha
     */
    public void comecarBatalha(){
        System.out.println(" ☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆ Vamos começar! ☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆ ");
        pokemonAtual();
        
        
        
        /*
        System.out.println("Total de vida: "+ "Treinador 1: "+ t1.getVidaTotal()+"Treinadora 2: "+t2.getVidaTotal());  
        if(t1.getVidaTotal()>t2.getVidaTotal())
            System.out.println(" ☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆ TREINADOR 1 GANHOU ☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆ ");
        else if(t2.getVidaTotal()>t1.getVidaTotal())
            System.out.println(" ☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆ TREINADOR 2 GANHOU ☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆ ");
        else 
            System.out.println(" ☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆ EMPATOU ☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆ ");*/
    }
    
    /**
     *retorna  o 1 pokemon
     * @return pokemon
     */
    public Pokemon getPokemon1(){
        return p1;
    }

    /**
     *retorna o segundo pokemon
     * @return pokemon
     */
    public Pokemon getPokemon2(){
        return p2;
    }
    
    /**
     *pega a vez para determinar quem comeca atacando
     * @return pokemon
     */
    public Pokemon getPokemonVez(){
        if(vez==1){
            return p1;
        }
        else{
            return p2;
        }
    }
    
    /**
     *retorna qual treinador ataca
     * @return o treinador
     */
    public Treinador getTreinadorVez(){
        if(vez==1){
            return t1;
        }
        else{
            return t2;
        }
    }
    
    /**
     *verifica qual o pokemon atual ,sua vida e se morreu
     */
    public void pokemonAtual(){
        for(int i = 0 ; i < t1.time.pokemons.size() ; i++){
            if(t1.time.pokemons.get(i).getHealthPoints() > 0){ // Ve se o Pokemon tem vida maior que 0, se não tiver muda para o proximo.
                p1 = t1.time.pokemons.get(i);
                break;
            }
            if(p1.getHealthPoints()==0){
                           System.out.println(" ††† Treinador 1 O Pokemon "+p1.getNome()+" morreu!, próximo ††† ");
            }
        }
        
        for(int i = 0 ; i < t2.time.pokemons.size() ; i++){
            if(t2.time.pokemons.get(i).getHealthPoints() > 0){ // Ve se o Pokemon tem vida maior que 0, se não tiver muda para o proximo.
                p2 = t2.time.pokemons.get(i);
                break;
            }
            if(p2.getHealthPoints()==0){
            System.out.println(" ††† Treinador 2 O Pokemon "+p2.getNome()+" morreu!, próximo ††† ");
            }
        }
    }
    
    /**
     *verifica se tem vantagem contra algum tipo
     */
    public void checaVantagem(){
     
        boolean flag = false;
        System.out.println(p1.nome);
        System.out.println(p1.vantagens.size());
        for(int i=0; i<p1.vantagens.size() ; i++){
            if(p1.vantagens.get(i) == p2.getTipo()){
                p1.setDanoAtual((float) (p1.getDanoPadrao() * (1.5)));
                flag = true;
                break;
            }
        }
        
        if(flag == false){
            p1.setDanoAtual((float)(p1.getDanoPadrao()));
            for(int i=0; i<p2.vantagens.size() ; i++){
               if(p2.vantagens.get(i) == p1.getTipo()){
                    p2.setDanoAtual((float) (p2.getDanoPadrao()* (1.5)));
                    flag = true;
                    break;
                }
           }
        }
        if(!flag){
            p2.setDanoAtual((float)(p2.getDanoPadrao()));
        }
    }
    
    /**
     *determina quem vai atacar no round da batalhha
     */
    public void round(){
        checaVantagem();
        
        /*
        System.out.println("=======================================================================");
        System.out.println("Ataque treinador 1:  ");
        System.out.println("Pokemon - " + p1.getNome());
        System.out.println("dano - " + p1.getDanoAtual());*/
        
        ataque(1);
        
        System.out.println("=======================================================================");
        System.out.println("Ataque treinador 2:  ");
        System.out.println("Pokemon - " + p2.getNome());
        System.out.println("dano - " + p2.getDanoAtual());
        ataque(2);
        pokemonAtual();
        System.out.println("=======================================================================");
        System.out.println("***********************************************************************");
        System.out.println("Treinadores recuperem 20 de mana!");
        recuperaManaPoints(t1,t2);
        System.out.println("***********************************************************************");
    }
     
    /**
     *determina qual ataque vai ser usado ao clicar o botao
     * @param t treinador
     */
    
    public void ataque(Treinador t){
        System.out.println("Ataue escolhido:  " + t.getAtaqueEscolhido());
        if(vez==1){
            float dano = p1.calculaAtaque(t.getAtaqueEscolhido());
            p2.setHealthPoints(p2.getHealthPoints() - dano);
            t2.setVidaTotal(t2.getVidaTotal() - dano);
            t1.setMana(t1.getMana() - p1.manaPoints[t.getAtaqueEscolhido()]);
            vez = 2;
        }
        else{
            float dano = p2.calculaAtaque(t.getAtaqueEscolhido());
            p1.setHealthPoints(p1.getHealthPoints() - dano);
            t1.setVidaTotal(t1.getVidaTotal() - dano);
            t2.setMana( t2.getMana() - p2.manaPoints[t.getAtaqueEscolhido()]);
            vez = 1;
        }
    }
    
    /**
     *funcao que roda o ataque
     * @param numTreinador
     */
    public void ataque(int numTreinador){       
        int choice = -1;
        float dano = 0;
        /*
        if(numTreinador == 1){
            System.out.println("♥ Vida do pokemon inimigo "+p2.getNome()+": " +p1.getHealthPoints());
            System.out.println("♦ ManaPoint(mp) Atual:"+t1.getMana());
            choice=t1.escolheAtaque(p1);
            if(p1.manaPoints[choice] <= t1.getMana()){
               dano = p1.calculaAtaque(choice);
               p2.setHealthPoints(p2.getHealthPoints() - dano);
               t2.setVidaTotal(t2.getVidaTotal() - dano);
               t1.setMana(t1.getMana() - p1.manaPoints[choice]);
               System.out.println("♠ Dano feito no pokemon inimigo: "+dano);
               System.out.println("♦ ManaPoint(mp) Restante:"+t1.getMana());
               System.out.println("♥ Vida do pokemon inimigo "+p2.getNome()+" apos o meu ataque pokemon " +p1.getNome() +": " +p2.getHealthPoints());
            }
            else{
                 while(p1.manaPoints[choice]>t1.getMana()){
                     System.out.println("♦♦♦ ManaPoint(mp) insuficiente,voce tem "+t1.getMana()+"ManaPoint(mp) Jogue novamente ♦♦♦");
                     choice=t1.escolheAtaque(p1);
                 }
             }
        }    
        
        else{
            System.out.println("♥ Vida do pokemon inimigo "+p1.getNome()+": " +p1.getHealthPoints());
            System.out.println("♦ ManaPoint(mp) Atual:"+t2.getMana());
            choice=t2.escolheAtaque(p2);
             if(p2.manaPoints[choice] <= t2.getMana()){
               dano = p2.calculaAtaque(choice);
               p1.setHealthPoints(p1.getHealthPoints() - dano);
               t1.setVidaTotal(t1.getVidaTotal() - dano);
               t2.setMana( t2.getMana() - p2.manaPoints[choice]);
               System.out.println("♠ Dano feito no pokemon inimigo: "+dano);
               System.out.println("♦ ManaPoint(mp) Restante:"+t2.getMana());
               System.out.println("♥ Vida do pokemon inimigo "+p1.getNome()+" apos o meu ataque pokemon " +p2.getNome() +": " +p1.getHealthPoints());
            }
             else{
                 while(p2.manaPoints[choice]>t2.getMana()){
                     System.out.println("♦♦♦ ManaPoint(mp) insuficiente,voce tem "+t2.getMana()+"ManaPoint(mp) Jogue novamente ♦♦♦");
                     choice=t2.escolheAtaque(p2);
                 }
                 
             }        
        }*/
             
    }
    
    /**
     *funcao que aumenta a mana a cada round
     * @param t1 treinador1
     * @param t2 treinador2
     */
    public void recuperaManaPoints(Treinador t1, Treinador t2){
        t1.setMana(t1.getMana()+20);
        t2.setMana(t2.getMana()+20);
    }
    
    /**
     *verifica se acabou a funcao
     * @return vida total
     */
    public boolean verificaFim(){
        return (t1.getVidaTotal()<=0 || t2.getVidaTotal()<=0);
    }
    
    /**
     *quantidade de pokemons
     * @return vetor quantos pokemons tem
     */
    public float[] getPorcentagem(){
        float[] porcentagens = new float[6];
        for(int i=0; i<t1.time.pokemons.size(); i++){
            porcentagens[i] = (t1.time.pokemons.get(i).getHealthPoints() /t1.time.pokemons.get(i).getMaxHP())*100;
        }
        for(int i=0; i<t2.time.pokemons.size(); i++){
            porcentagens[i+3] = (t2.time.pokemons.get(i).getHealthPoints() /t2.time.pokemons.get(i).getMaxHP())*100;
        }
        return porcentagens;
        
    }

    
}
    
    
             

