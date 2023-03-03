package asseblatore;

public class Motore {
    int id;
    String ci;
    String pi;
        public Motore(int id,String ci, String pi) {
            this.id = id;
            this.ci=ci;
            this.pi=pi;
        }
        public void stampa() {
            System.out.println(id + "La cilindrata della macchina è: " + ci +  ", ed ha "+pi+" pistoni");
          } 
        
}

