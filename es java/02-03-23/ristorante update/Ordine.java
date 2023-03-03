package ristorante;

public class Ordine {
    int id;
    int idPiatto;
    int idUser;
    public Ordine(int id,  int idPiatto, int idUser) {
        this.id = id;
        this.idPiatto=idPiatto;
        this.idUser = idUser;
    }
}
