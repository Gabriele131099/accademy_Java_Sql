package concessionaria;

public class Moto extends Veicolo{
    


    private int cilindrata;
    private String tipologia;
    // {"sportiva", "stradale", "etc"};
    private int potenza;

    public Moto(String Marca, String Modello, int annoFabbricazione, int cilindrata, String tipologia, int potenza) {
        super(Marca, Modello, annoFabbricazione);
        this.cilindrata = cilindrata;
        this.potenza = potenza;
        this.tipologia = tipologia;
    }

    public int getCilindrata() {
        return cilindrata;
    }
    public void setCilindrata(int cilindrata) {
        this.cilindrata = cilindrata;
    }
    public String getTipologia() {
        return tipologia;
    }
    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }
    public int getPotenza() {
        return potenza;
    }
    public void setPotenza(int potenza) {
        this.potenza = potenza;
    }


    public void stampaMoto() {
        super.stampa();
        System.out.println("Cilindrata: "+this.cilindrata);
        System.out.println("Tipologia: "+this.tipologia);
        System.out.println("Potenza: "+this.potenza);

    }
}
