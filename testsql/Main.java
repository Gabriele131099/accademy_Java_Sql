package testsql;

import java.sql.*;
import java.util.*;

public class Main {
// a) Creare uno schema relazionale che rappresenta gli autori e i vari romanzi scritti.
// Per ogni autore deve essere indicato: nome(P.K.), l’anno di nascita, l’anno morte(se è deceduto) e la nazione.
// Per ogni libro deve essere indicato: il titolo del libro, l’autore(F.K.) e l’anno di pubblicazione.
// Nelle note deve essere specificato per ogni colonna il tipo di dato e il vincolo attribuito o come deve essere gestito.

// b) Sfruttando JDBC creare uno script JAVA che vada a creare il database “biblioteca” inserendo le tabelle con i vincoli recuperati dallo schema relazionale creato in precedenza nel punto a.

// c) Una volta creato il database, creare uno script JAVA che permette all’utente:
// di inserire nuovi autori e nuovi libri se l’autore è presente (è obbligatorio utilizzare i metodi della classe ResultSet);
// di stampare tutti gli autori;
// di stampare i libri di un autore.

// Tabella autore(
    //     ID* Integer
    //     Nome Char(30) not null
    //     Anno_nascita date not null 
    //     Anno_morte date
    //     Nazione Char (50)
// )
// Tabella libro(
    //     ID* Integer
    //     Titolo char(100)
    //     Autore_uid** Integer REFERENCES autore(ID)"
    //     Anno_pubblicazione date not null
// )
   
    public static void main(String[] args) {
    //editore
        try {
            // Stabilisce la connessione al database
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/BIBLIOTECA", "root", "Vivident.root");
            Statement stmt = conn.createStatement();

            String sqlCreateDb = "CREATE DATABASE BIBLIOTECA";
            System.out.println("Database created successfully...");
            String sqlCreateAutori = "CREATE TABLE Autore " +
                    "(id  VARCHAR(255) not NULL , " +
                    " nome VARCHAR(255), " + 
                    " anno_nascita VARCHAR(255), " + 
                    " anno_morte VARCHAR(255), " + 
                    " nazionalita  VARCHAR(255), " + 
                    " PRIMARY KEY ( id ))"; 
            String sqlCreateLibri = "CREATE TABLE Libro " +
                    "(id VARCHAR(255) not NULL , " +
                    " titolo VARCHAR(255), " + 
                    " Anno_pubblicazione VARCHAR(255), " + 
                    " Autore_uid Integer REFERENCES autore(Id), " + 
                    " PRIMARY KEY ( id ))"; 
 
          stmt.executeUpdate(sqlCreateLibri);
          System.out.println("Create");   	  
       } catch (SQLException e) {
          e.printStackTrace();
       } 

      

    }

    
}
