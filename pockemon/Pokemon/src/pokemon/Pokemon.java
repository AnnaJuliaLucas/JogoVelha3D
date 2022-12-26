package pokemon;

import java.util.ArrayList;

/**
 *Classe pokemon contem todos atributos vida,mana,tipo
 * @author joao
 */
public class Pokemon {
	
    /**
     *Nome do pokemon
     */
    protected String nome;

    /**
     *string do tipo fogo,agua,terra
     */
    protected String nomeTipo;

    /**
     *fogo,agua,terra
     */
    protected int tipo;

    /**
     *vetor dos nomes das abilidades
     */
    protected String[] habilidades = new String[4];

    /**
     *vetor que multiplica de acordo com a vantagem
     */
    protected float[] multiHabilidades = {2,1.5f,1,0};

    /**
     *custo de usa da habilidade
     */
    protected int[] manaPoints = {75,50,25,0};

    /**
     *
     */
    protected float healthPoints;

    /**
     *
     */
    protected float danoAtual = 10;

    /**
     *
     */
    protected float danoPadrao = 10;

    /**
     *dano do pokemon
     */
    protected float dano;
    
    /**
     *vida maxima do pokemon
     */
    protected int maxHealthPoints;

    /**
     *
     */
    public String imagem;

    /**
     *array de vantagens contra outros pokemons
     */
    public ArrayList<Integer> vantagens = new ArrayList();
    private int habilidadeEscolhida;
    
    /**
     *vida maxima do pokemon
     * @return o hp maximo
     */
    public int getMaxHP(){
        return maxHealthPoints;
    }
    
    /**
     *nome do pokemon
     * @return nome
     */
    public String getNome(){
        return nome;
    }
    
    /**
     *nome do pokemon
     * @param nome nome do pokemon
     */
    public void setNome(String nome){
        this.nome=nome;
    }
    
    /**
     *string do tipo dele
     * @return string
     */
    public String getNomeTipo(){
        return nomeTipo;
    }
    
    /**
     *determina a string do tipo
     * @param nomeTipo string do tipo
     */
    public void setNomeTipo(String nomeTipo){
        this.nomeTipo=nomeTipo;
    }
    
    /**
     *get do tipo
     * @return o tipo
     */
    public int getTipo(){
        return tipo;
    }
    
    /**
     *
     * @param tipo string do tipo do pokemon
     */
    public void setTipo(int tipo){
        this.tipo=tipo;
    }
    
    /**
     *get de habilidade
     * @return string habilidade
     */
    public String[] getHabilidades(){
        return habilidades;
    }
    
    /**
     *get de vida
     * @return vida
     */
    public float getHealthPoints(){
        return healthPoints;
    }
    
    /**
     *determina a vida
     * @param healthPoints vida
     */
    public void setHealthPoints(float healthPoints){
        this.healthPoints=healthPoints;
    }

    /**
     *dano com multiplicador
     * @param index posicao no vetor
     * @return
     */
    public float calculaAtaque(int index){
            dano = danoAtual;
            dano = dano * multiHabilidades[index];
            return dano;
        }
    
    /**
     *dano se multiplicador
     * @return o dano
     */
    public float getDanoAtual(){
        return danoAtual;
    }
    
    /**
     *
     * @param danoAtual dano sem mult
     */
    public void setDanoAtual(float danoAtual){
       this.danoAtual = danoAtual;
    }
    
    /**
     *declara as vantagens do pokemon
     */
    public void setVantagens(){
        
    }
    
    /**
     *
     * @param i index do vetor
     */
    public void setHabilidadeEscolhida(int i){
        habilidadeEscolhida = i-1;
    }
    
    /**
     *
     * @return posicao da habilidade
     */
    public int getHabilidadeEscolhida(){
        return habilidadeEscolhida;
    }
    
    /**
     *
     * @return dano
     */
    public float getDanoPadrao(){
        return danoPadrao;
    }
}
