package ristorante;

import java.util.UUID;

public class Ordine {
    private UUID id = UUID.randomUUID();
    int idPiatto;
    int idUser;
    public Ordine(  int idPiatto, int idUser) {
        this.idPiatto=idPiatto;
        this.idUser = idUser;
    }
    public UUID getId() {
        return id;
    }
    public int getIdPiatto() {
        return idPiatto;
    }
    public void setIdPiatto(int idPiatto) {
        this.idPiatto = idPiatto;
    }
    public int getIdUser() {
        return idUser;
    }
    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
}
