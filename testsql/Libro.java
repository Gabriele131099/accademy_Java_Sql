package testsql;

import java.util.UUID;

public class Libro {
    // Tabella libro(
    //     ID* Integer
    //     Titolo char(100)
    //     Autore_uid** Integer REFERENCES autore(ID)"
    //     Anno_pubblicazione date not null
// )
private String id = UUID.randomUUID().toString();
private String titolo ;
private String autoreID;
private String annoPublicazione;
Libro(String titolo,String autoreId, String annoPublicazione){
   this.titolo = titolo;
   this.autoreID = autoreId;
   this.annoPublicazione = annoPublicazione;
 
}
public String getId() {
   return id;
}
public String getTitolo() {
    return titolo;
}
public void setTitolo(String titolo) {
    this.titolo = titolo;
}
public String getAutoreID() {
    return autoreID;
}
public void setAutoreID(String autoreID) {
    this.autoreID = autoreID;
}
public String getAnnoPublicazione() {
    return annoPublicazione;
}
public void setAnnoPublicazione(String annoPublicazione) {
    this.annoPublicazione = annoPublicazione;
}
}
