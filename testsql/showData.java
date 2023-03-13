package testsql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class showData {
    public static void main(String[] args) {
        try {

            // Stabilisce la connessione al database
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/biblioteca", "root", "Vivident.root");
    
            // Crea uno statement per recuperare la vista
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String query = "SELECT * FROM Autore";
            ResultSet rs = stmt.executeQuery(query);
    
            String queryLibro = "SELECT * FROM Libro";
            ResultSet rsLibro = stmt.executeQuery(queryLibro);
    
            // Recupera i metadati dalla vista
            ResultSetMetaData rsmd = rs.getMetaData();
            int numColumns = rsmd.getColumnCount();
    
            ResultSetMetaData rsmdLibro = rsLibro.getMetaData();
            int numColumnsLibro = rsmdLibro.getColumnCount();
    
            // Stampa i dati della vista
            while (rs.next()) {
               for (int i = 1; i <= numColumns; i++) {
                  Object value = rs.getObject(i);
                  String columnName = rsmd.getColumnName(i);
                  String columnType = rsmd.getColumnTypeName(i);
                  System.out.println(columnName + " (" + columnType + "): " + value);
               }
               System.out.println();
            }
            while (rsLibro.next()) {
                for (int i = 1; i <= numColumnsLibro; i++) {
                   Object value = rs.getObject(i);
                   String columnName = rsmd.getColumnName(i);
                   String columnType = rsmd.getColumnTypeName(i);
                   System.out.println(columnName + " (" + columnType + "): " + value);
                }
                System.out.println();
             }
          
            // Chiude la connessione
            conn.close();
         } catch (SQLException e) {
            //errore
            e.printStackTrace();
         }
    }
}
