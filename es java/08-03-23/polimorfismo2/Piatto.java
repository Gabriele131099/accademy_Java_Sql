package polimorfismo2;

import java.util.UUID;

public class Piatto extends Menu{
    private String id = UUID.randomUUID().toString();
    String[] ingrdienti;
    int prezzo;
    String chef;

    Piatto(String[] ingredienti, int prezzo, String chef, String nomeMenu){
        super(nomeMenu);
        this.ingrdienti = ingredienti;
        this.prezzo = prezzo;
        this.chef = chef;
    }

    public String getId() {
        return id;
    }
    public String[] getIngrdienti() {
        return ingrdienti;
    }
    public void setIngrdienti(String[] ingrdienti) {
        this.ingrdienti = ingrdienti;
    }
    public int getPrezzo() {
        return prezzo;
    }
    public void setPrezzo(int prezzo) {
        this.prezzo = prezzo;
    }
    public String getChef() {
        return chef;
    }
    public void setChef(String chef) {
        this.chef = chef;
    }
}
