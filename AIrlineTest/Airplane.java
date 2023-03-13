package AIrlineTest;

import java.util.ArrayList;
import java.util.UUID;

public class Airplane {
    // andiamo a creare un programma per la gestione di un'azienda di trasporto aereo, 
    // in cui ogni aereo ha un nome, un numero di posti a sedere e una capacità di carico. 
    // Inoltre, ci sono due tipi di aerei: aerei passeggeri e aerei cargo.

    // Crea una classe Airplane che incapsula i campi nome, posti a sedere e capacità di carico, 
    // e che fornisce i metodi getter e setter per questi campi.
    private String id = UUID.randomUUID().toString();
    private String nome ;
    private int nPosti;
    private int cc;

    Airplane(String nome, int nPosti, int cc){
        this.nome = nome;
        this.nPosti =nPosti;
        this.cc = cc;
    }

    public String getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getnPosti() {
        return nPosti;
    }
    public void setnPosti(int nPosti) {
        this.nPosti = nPosti;
    }
    
    public int getCc() {
        return cc;
    }
    public void setCc(int cc) {
        this.cc = cc;
    }

    @Override
    public String toString() {
       
        return this.nome + ", con posti: "+this.nPosti+ ", con capacità di carico "+this.cc;
    }

   

   
    
}
