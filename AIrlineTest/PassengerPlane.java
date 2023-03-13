package AIrlineTest;

import java.util.ArrayList;

public class PassengerPlane extends Airplane{
    // Crea due sottoclassi della classe Airplane: PassengerPlane e CargoPlane. 
    // Per ogni sottoclasse, definisci un costruttore che accetta i valori per tutti i campi, inclusi quelli ereditati dalla classe Airplane.

  // La classe PassengerPlane deve avere un campo aggiuntivo che rappresenta il numero di servizi di bordo disponibili, 
 
  ArrayList<Servizio> arrayServizi;
    PassengerPlane(String nome, int nPosti, int cc,ArrayList<Servizio>arrayService) {
        super(nome, nPosti, cc);
       this.arrayServizi = arrayService;
    }
    public ArrayList<Servizio> getArrayServizi() {
        return arrayServizi;
    }
    public void setArrayServizi(ArrayList<Servizio> arrayServizi) {
        this.arrayServizi = arrayServizi;
    }

    public void stampa() {
      
        System.out.println( super.toString());
        System.out.println("Servizi:");
        for (Servizio servizio : arrayServizi) {
            System.out.println(servizio.getNome());
        }
    }
}
