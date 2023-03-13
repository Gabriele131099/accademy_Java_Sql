package testsql;

import java.sql.Date;
import java.util.UUID;
public class Autore {
    
// Tabella autore(
    //     ID* Integer
    //     Nome Char(30) not null
    //     Anno_nascita date not null 
    //     Anno_morte date
    //     Nazione Char (50)
// )

 private String id = UUID.randomUUID().toString();
 private String nome ;
 private String anno_nascita;
 private String anno_morte;
 private String nazione;
 Autore(String nome,String dataNascita, String dataMorte,String nazione){
    this.nome = nome;
    this.anno_nascita = dataNascita;
    this.anno_morte = dataMorte;
    this.nazione = nazione;
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
public String getAnno_nascita() {
    return anno_nascita;
}
public void setAnno_nascita(String anno_nascita) {
    this.anno_nascita = anno_nascita;
}
public String getAnno_morte() {
    return anno_morte;
}
public void setAnno_morte(String anno_morte) {
    this.anno_morte = anno_morte;
}
public String getNazione() {
    return nazione;
}
public void setNazione(String nazione) {
    this.nazione = nazione;
}

}
