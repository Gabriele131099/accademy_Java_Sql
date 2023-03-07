package concessionaria;

import java.util.UUID;

public class Veicolo {
    private String id = UUID.randomUUID().toString();
    private String Marca;
    private String Modello;
    private int annoFabbricazione;

    public Veicolo(String Marca,  String Modello, int annoFabbricazione) {
        this.Marca=Marca;
        this.Modello = Modello;
        this.annoFabbricazione = annoFabbricazione;
    }


    public String getId() {
        return id;
    }
    public String getMarca() {
        return Marca;
    }
    public void setMarca(String marca) {
        Marca = marca;
    }
    public String getModello() {
        return Modello;
    }
    public void setModello(String modello) {
        Modello = modello;
    }
    public int getAnnoFabbricazione() {
        return annoFabbricazione;
    }
    public void setAnnoFabbricazione(int annoFabbricazione) {
        this.annoFabbricazione = annoFabbricazione;
    }

    public void stampa() {
        System.out.println("Marca: "+this.Marca);
        System.out.println("Moodello: "+this.Modello);
        System.out.println("Anno di fabbricazione: "+this.annoFabbricazione);
    }
}
