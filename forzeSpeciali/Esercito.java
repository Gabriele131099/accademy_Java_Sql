package forzeSpeciali;

import java.util.ArrayList;
import java.util.Scanner;


abstract class ForzeSpeciali {
   public void  GradiSpeciali(int anniServizio){
    String grado ="Recluta";
        if (anniServizio>=11 && anniServizio<3) {
            grado =  "Sergente";
        }else
        if (anniServizio>=3 && anniServizio<5) {
            grado = "Capitano";
        }else
        if (anniServizio>=5) {
            grado = "Caporale";
        }else{
            grado = "Recluta";
        }
       System.out.println(grado);
    }
    public void Annodiinizio(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("da quanti anni sei nell esercito");
        int anniServizio =scanner.nextInt();
        GradiSpeciali(anniServizio);
    }

    public void specializzazione (String s){
        System.out.println("ciao "+s);
    }
}
public class Esercito {
    int nSoldati=0;
    private ArrayList<Soldato> soldati= new ArrayList<>();
    private class Soldato extends ForzeSpeciali{
        Soldato(String nome, int annoNascita){
            this.nome = nome;
            this.AnnodiNascita = annoNascita;
            Annodiinizio();
            specializzazione(nome);
        }
        String nome ;

        int AnnodiNascita;
        Boolean forzeSpeciali = false;
    }
    public static void main(String[] args) {
        Esercito esercito = new Esercito();
        Esercito.Soldato soldato = esercito.new Soldato("jack", 2000);
    }
}
