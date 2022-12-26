package dcc025.aula3;
 


public class Caderno {

    String modelo;
    String marca;
    int tamanho;
    float usado;
    boolean aberto;
    
    

    void status() {
        System.out.println("Um caderno " + this.modelo + " da " + this.marca + " de tamanho " + this.tamanho + " cm, já foi usado " + this.usado + "%");
        System.out.println("Esta aberto? " + this.aberto);

    }
   
    void abrir(){
        this.aberto = true;
    }
    
    void fechar(){
        this.aberto = false;
    }
    
      void rabiscarCaderno(){
        if(this.aberto==true){
            Caneta c1 = new Caneta();
            c1.rabiscar();
            System.out.println("Rabiscando no caderno!");
        }else{
            System.out.println("Erro! Não é possível rabiscar, caderno fechado.");
        }
    }
    

}
