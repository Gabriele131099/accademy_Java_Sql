package AIrlineTest;

public class CargoPlane extends Airplane{
    // Crea due sottoclassi della classe Airplane: PassengerPlane e CargoPlane. 
    // Per ogni sottoclasse, definisci un costruttore che accetta i valori per tutti i campi, inclusi quelli ereditati dalla classe Airplane.

    // la classe CargoPlane dovrebbe avere un campo aggiuntivo che rappresenta la capacità di carico massima .
    private int cMax;
        CargoPlane(String nome, int nPosti, int cc, int cMax) {
        super(nome, nPosti, cc);
        this.cMax = cMax;
      
    }
    public int getcMax() {
        return cMax;
    }
    public void setcMax(int cMax) {
        this.cMax = cMax;
    }
    

   public void stampa() {
      
       System.out.println( super.toString()+ ", capienza massima "+getcMax());
   }


}
