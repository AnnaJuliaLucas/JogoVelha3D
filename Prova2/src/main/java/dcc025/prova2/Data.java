package dcc025.prova2;

/**
 *
 * @author anna
 */
public class Data {

    private int mes;
    private int ano;

    public Data(int mes, int ano) {
        this.mes = mes;
        this.ano = ano;
    }

    public int getMes() {
        return mes;
    }

    public int getAno() {
        return ano;
    }
    
    public int diferenca(Data outraData) throws Exception{
        int diferencaMeses = 0;
        
        int totalDeMesesData1 = this.getAno() * 12 /*Calcula quant de dias no ano*/+ this.getMes();
        int totalDeMesesData2 = outraData.getAno() * 12 + outraData.getMes();

        if (totalDeMesesData1 > totalDeMesesData2) {
            throw new Exception("DATA INVALIDA!\n A data2 é maior que data1");
        }

        diferencaMeses = totalDeMesesData1 - totalDeMesesData2;

        return diferencaMeses;
    }

   
}
