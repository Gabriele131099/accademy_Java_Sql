package polimorfismo2;

import java.util.UUID;

public class Ordinazione {
    private String id = UUID.randomUUID().toString();
    private String idPiatto;
    Ordinazione(String idPiatto){
        this.idPiatto = idPiatto;
    }
    public String getId() {
        return id;
    }
    public String getIdPiatto() {
        return idPiatto;
    }
    public void setIdPiatto(String idPiatto) {
        this.idPiatto = idPiatto;
    }
    
}
