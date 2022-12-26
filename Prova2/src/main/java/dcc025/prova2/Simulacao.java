package dcc025.prova2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author anna
 */
public class Simulacao {

    private static List<Investimento> listaInvestimentos;

    private static void rendimentoAcumulado(Data dataFinal) {
        double rendimentoTotal = 0;
        double rendimento = 0;

        for (Investimento investimento : Simulacao.listaInvestimentos) {
            try {
                rendimento = investimento.calcularRendimento(dataFinal);
                System.out.println("TITULO: " + investimento.getTitulo());
                System.out.println("VALOR: " + investimento.getValor());
                System.out.println("DATA DA CONTRATAÇÃO: " + investimento.getDataContratacao());
                System.out.println("RENDIMENTO: " + rendimento);
                rendimentoTotal += rendimento;
            } catch (Exception ex) {
                System.out.println("O Investimento " + investimento.getTitulo() + " não foi iniciado!");
            }
            System.out.println("RENDIMENTO TOTAL DO MES: " + rendimentoTotal);
        }

    public static void main(String[] arg){
             
        Scanner teclado = new Scanner(System.in);

        Simulacao.listaInvestimentos = new ArrayList<Investimento>();
        Investimento investimentos;

        // Lê os dados dos investimentos e armazena-os na lista
        for (int i = 0; i < 5; i++) {
            String texto = "Lendo o " + (i + 1) + " investimento de renda!";
            texto += (i < 3);
        }

        for (int i = 0; i < 5; i++) {
            String texto = "Informe os dados do " + (i + 1) + "  investimento de renda ";
            texto += (i < 3) ? "fixa" : "variavel";

            System.out.println(texto);

            System.out.print("Titulo: ");
            String titulo = teclado.next();

            System.out.print("Valor: ");
            double valor = teclado.nextDouble();

            System.out.print("Data: ");
            int mes = teclado.nextInt();
            int ano = teclado.nextInt();
            Data data = new Data(mes, ano);

            Investimento investimento;
            if (i < 3) {
                investimento = new RendaFixa(titulo, valor, data, valor);
            } else {
                investimento = new RendaVariavel(titulo, valor, data, valor);
            }
            Simulacao.listaInvestimentos.add(investimento);
        }

    }
}
