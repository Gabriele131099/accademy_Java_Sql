package testsql;
import java.sql.*;
import java.util.*;
public class addLibro {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        Scanner risposta = new Scanner(System.in);
        ArrayList<Libro> arrayLibri = new ArrayList<Libro>();
        try {
            // Stabilisce la connessione al database
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/biblioteca", "root", "Vivident.root");

            // Crea uno statement per recuperare la vista
            String query = "SELECT * FROM Libro";
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery(query);

            String queryAuthor = "SELECT * FROM Autore";
            ResultSet rsAuthor = stmt.executeQuery(queryAuthor);
            String idAutore = "";
            for (int i = 0; i < 10; i++) {
                System.out.println("Inserisci il titolo del libro:");
                String titoloLibro = scanner.nextLine();
                System.out.println("Inserisci il nome dell'autore");
                String nomeAutore = scanner.nextLine();
                boolean flagCheckSiti = false;
                rs.beforeFirst();
               
                while (rs.next()) {
                    String idAutoreTmp = rsAuthor.getString("id");
                    String nomeAutoreColumn = rsAuthor.getString("nome");

                    if (nomeAutoreColumn.equalsIgnoreCase(nomeAutore)) {
                        flagCheckSiti = true;
                        idAutore = idAutoreTmp;
                        break;
                    }
                }
                if (!flagCheckSiti) {
                    System.out.println("L autore non esiste");;
                } else {
                   
                    
                    System.out.println("Inserisci la data di pubblicazione:");
                    String anno_publicazione = scanner.nextLine();
                    
                   
                    Libro libro = new Libro(titoloLibro, anno_publicazione, idAutore);
                    arrayLibri.add(libro);

                    System.out.println("L'autore è stato aggiunto in locale, termina l'inserimento per confermare.");
                }
                System.out.println("Vuoi inserire un'altro libro? (s/n)");
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
                for (Libro libro : arrayLibri) {
                    rs.moveToInsertRow();
                    rs.updateString("id",libro.getId());
                    rs.updateString("titolo", libro.getTitolo());
                    rs.updateString("Anno_pubblicazione", libro.getAnnoPublicazione());
                    rs.updateString("Autore_uid", libro.getAutoreID());
                    rs.insertRow();
                    rs.moveToCurrentRow();
                    System.out.println(libro.getTitolo() + " Aggiunta al db");
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

