package asseblatore;

public class Macchina {
    int id ;
    String targa;
    int idFreni;
    int idPistoni;
        public Macchina(int id,String targa,int idFreni, int idPistoni) {
            this.id = id;
            this.targa = targa;
            this.idFreni=idFreni;
            this.idPistoni=idPistoni;
        }
      
       public void stampa() {
         System.out.println(id+"La targa della macchina è: " + targa+ " freni "+ idFreni+" , cilindri" + idPistoni);
       } 
}
