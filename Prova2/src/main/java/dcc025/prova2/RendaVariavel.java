/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dcc025.prova2;

/**
 *
 * @author anna
 */
public class RendaVariavel extends Investimento {

    private double taxaDeJuros;

    public Double getTaxaDeJuros() {
        return taxaDeJuros * 0.08;
    }

    RendaVariavel(String titulo, double valor, Data dataContratacao, double taxaDejuros) {
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
