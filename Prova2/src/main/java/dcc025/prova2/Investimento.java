package dcc025.prova2;

/**
 *
 * @author anna
 */
public abstract class Investimento implements Rendimento{
    private String titulo;
    private double valor;
    private Data dataContratacao;
    
    public Investimento(String titulo, double valor, Data dataContratacao){
        this.titulo = titulo;
        this.valor = valor;
        this.dataContratacao = dataContratacao;
    }
    
    public String getTitulo() {
        return this.titulo;
    }

    public Double getValor() {
        return this.valor;
    }

    public Data getDataContratacao() {
        return this.dataContratacao;
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setDataContratacao(Data dataContratacao) {
        this.dataContratacao = dataContratacao;
    }
    
    
    
}
