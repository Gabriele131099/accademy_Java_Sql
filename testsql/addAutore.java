package testsql;

import java.sql.*;
import java.util.*;

public class addAutore {
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
        Scanner scanner = new Scanner(System.in);
        Scanner risposta = new Scanner(System.in);
        ArrayList<Autore> arrayAutori = new ArrayList<Autore>();
        try {
            // Stabilisce la connessione al database
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/biblioteca", "root", "Vivident.root");

            // Crea uno statement per recuperare la vista
            String query = "SELECT * FROM Autore";
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery(query);

           
            for (int i = 0; i < 10; i++) {
                System.out.println("Inserisci il nome dell autore:");
                String nomeAutore = scanner.nextLine();
                boolean flagCheckSiti = false;
                rs.beforeFirst();
                while (rs.next()) {
                    String nomeAutoreColumn = rs.getString("nome");
                    if (nomeAutoreColumn.equalsIgnoreCase(nomeAutore)) {
                        flagCheckSiti = true;
                        break;
                    }
                }
                if (flagCheckSiti) {
                    System.out.println("L autore è gia presente");;
                } else {
                    System.out.println("Inserisci la data di nascita:");
                    String dataNascita = scanner.nextLine();
                    
                    System.out.println("Inserisci la data di morte:");
                    String dataMorte = scanner.nextLine();
                    
                    System.out.println("Inserisci la nazionalità:");
                    String nazionalitaAutore = scanner.nextLine();
                    Autore autore = new Autore(nomeAutore, dataNascita, dataMorte,
                            nazionalitaAutore);
                    arrayAutori.add(autore);

                    System.out.println("L'autore è stato aggiunto in locale, termina l'inserimento per confermare.");
                }
                System.out.println("Vuoi inserire un'altro autore? (s/n)");
                String risposta2 = risposta.nextLine().toLowerCase();
                if (!risposta2.equals("s")) {
                    break;
                }
            }
           //conferma
                System.out.println("Vuoi inserire gli autori? (s/n)");
                String risposta3 = risposta.nextLine().toLowerCase();
                if (risposta3.equals("s")) {
                    // aggiunge tutte le città
                for (Autore autore : arrayAutori) {
                    rs.moveToInsertRow();
                    rs.updateString("id",autore.getId());
                    rs.updateString("nome", autore.getNome());
                    rs.updateString("anno_nascita", autore.getAnno_nascita());
                    rs.updateString("anno_morte", autore.getAnno_morte());
                    rs.updateString("nazionalita", autore.getNazione());
                    rs.insertRow();
                    rs.moveToCurrentRow();
                    System.out.println(autore.getNome() + " Aggiunta al db");
                }
            }else{
                System.out.println("Inserimento annullato");
            }
            conn.close();
           
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
}