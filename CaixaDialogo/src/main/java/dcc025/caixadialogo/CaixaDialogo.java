package dcc025.caixadialogo;

import javax.swing.JOptionPane;

public class CaixaDialogo {

    public static void main(String[] args) {
        //Erro com ok
        JOptionPane.showConfirmDialog(null, "Área sensivel para emocionados", "Coração",
                JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null);

        //Erro com sim e não
        JOptionPane.showConfirmDialog(null, "Deseja Continuar?", "Pense bem", JOptionPane.YES_NO_OPTION,
                JOptionPane.ERROR_MESSAGE, null);

        //Entrada do usuário        
        String nome = JOptionPane.showInputDialog(null, "Digite o seu nome:", "Nome", JOptionPane.QUESTION_MESSAGE);
        //System.out.println("Olá emocionada, " + nome + "!");

        JOptionPane.showMessageDialog(null, "Olá, " + nome + "!", "Seja bem emocionada", JOptionPane.INFORMATION_MESSAGE);

        String[] options = {"Intensa", "Sensitiva", "Dramatica"};
        int option = JOptionPane.showOptionDialog(null, "Escolha sua terrinha:", "Localização", JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        //
        //for (int i = 0; i < 3; i++) {
        switch (option) {
            case 0 -> JOptionPane.showMessageDialog(null, "Você é do time que leva uma samambaia pro 2º encontro.", "Florista", JOptionPane.INFORMATION_MESSAGE, null);
            case 1 -> JOptionPane.showMessageDialog(null, "Você é do time que faz o mapa astral no 1º encontro", "Astrologa", JOptionPane.INFORMATION_MESSAGE, null);
            default -> JOptionPane.showMessageDialog(null,"Você é do time que joga pelo sentimental", "Jogadora",JOptionPane.INFORMATION_MESSAGE,null);
        }
        //}
        
    }

}
