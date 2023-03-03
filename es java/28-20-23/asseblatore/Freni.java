package asseblatore;

public class Freni {
    int id;
    String ne;
    String pf;
        public Freni(int id,String ne, String pf) {
            this.id = id;
            this.ne=ne;
            this.pf=pf;
        }
        public void stampa() {
            System.out.println(id+"La potenza frenante della macchina è: " + pf +  ", ed ha "+ne+" pastiglie");
          } 
}
