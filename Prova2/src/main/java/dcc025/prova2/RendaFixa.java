package dcc025.prova2;

/**
 *
 * @author anna
 */
public class RendaFixa extends Investimento {

    private double taxaDeJuros;
    
    public Double getTaxaDeJuros() {
        return taxaDeJuros * 0.05;
    }

    RendaFixa(String titulo, double valor, Data dataContratacao, double taxaDejuros) {
        super(titulo, valor, dataContratacao);
        this.taxaDeJuros = taxaDejuros;
    }

    @Override
    public double calcularRendimento(Data data) {
        try {
            return this.getValor() * this.getTaxaDeJuros() * data.diferenca(this.getDataContratacao());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

 
}
