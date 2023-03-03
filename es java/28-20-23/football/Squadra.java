package football;

import java.util.ArrayList;

public class Squadra {
    int id;
    String nome;
    ArrayList<Dirigenza> dirigenti;
    ArrayList<Giocatore> giocatori;
        public Squadra(int id,String nome,ArrayList<Dirigenza> dirigenti, ArrayList<Giocatore> giocatori) {
            this.id = id;
            this.nome = nome;
            this.dirigenti=dirigenti;
            this.giocatori=giocatori;
        }

      public void stampaAll() {
        System.out.println("Il nome della squadra è " + nome);
        stampaBoss();
        stampaPlayer();
       } 
       public void stampaPlayer(){
        System.out.println("I giocatori sono");
        for (int i = 0; i <giocatori.size(); i++) {
          if (giocatori.get(i).panchina) {
            System.out.println(giocatori.get(i).id+" Sono nella rosa, " + giocatori.get(i).nome);
          } else {
            System.out.println(giocatori.get(i).id+" Sono in panchina " + giocatori.get(i).nome);
          } 
        }
       }
       public void stampaBoss(){
        System.out.println("i dirigenti sono");
        for (int i = 0; i <dirigenti.size(); i++) {
          if (!dirigenti.get(i).boss) {
            System.out.println("Sono il dirigente " + dirigenti.get(i).dirigente);
          } else {
            System.out.println("Sono il boss " + dirigenti.get(i).dirigente);
          }
        }
       }
}
