package concessionaria;

public class Auto extends Veicolo{
    private int nPorte;
    private String tipoCarburante;
    private int CM100Km;

    public Auto(String Marca, String Modello, int annoFabbricazione,int nPorte,String tipoCarburante,int CM100Km) {
        super(Marca, Modello, annoFabbricazione);
       this.nPorte = nPorte;
       this.tipoCarburante = tipoCarburante;
       this.CM100Km = CM100Km;
    }

    public int getnPorte() {
        return nPorte;
    }
    public void setnPorte(int nPorte) {
        this.nPorte = nPorte;
    }
    public String getTipoCarburante() {
        return tipoCarburante;
    }
    public void setTipoCarburante(String tipoCarburante) {
        this.tipoCarburante = tipoCarburante;
    }
    public int getCM100Km() {
        return CM100Km;
    }
    public void setCM100Km(int cM100Km) {
        CM100Km = cM100Km;
    }


    public void stampaMacchina() {
        super.stampa();
        System.out.println("Numero porte: "+this.nPorte);
        System.out.println("Tipo Carburante: "+this.tipoCarburante);
        System.out.println("Consumo medio di carburante per 100 km: "+this.tipoCarburante);
    }
}
