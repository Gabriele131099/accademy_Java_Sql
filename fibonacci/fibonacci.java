package fibonacci;

import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class fibonacci {
    static ArrayList<Integer> numsGenerated = new ArrayList<Integer>();

    public static void main(String[] args) {
        boolean keep = true;
        while (keep) {
            int userChoice = requestInput(
                    "Vuoi\n[1] Stampare la serie\n[2] Verificare un numero\n[3] Prova connessione\n[4] Uscire", 4);
            switch (userChoice) {
                case 1:
                    printSequence();
                    // inputScanner.close();
                    break;
                case 2:
                    searchNumberInSequence();
                    break;
                case 3:
                    connectionView();
                    break;
                case 4:

                    System.out.println("Esci");
                    keep = false;
                    break;
                default:
                    System.out.println("non disponibile");
            }

        }

    }
//con limite
    public static int requestInput(String request, int choiseMax) {
        Boolean flagChoise = false;
        int inputNumber = 0;
        do {
            Scanner nScan = new Scanner(System.in);
            System.out.println(request);
            inputNumber = nScan.nextInt();
            flagChoise = (inputNumber >= 0 && inputNumber <= choiseMax);
        } while (!flagChoise);
        return inputNumber;
    }
//generic int input
    public static int requestInput(String request) {
        Boolean flagChoise = false;
        int inputNumber = 0;
        do {
            Scanner nScan = new Scanner(System.in);
            System.out.println(request);
            inputNumber = nScan.nextInt();
            flagChoise = inputNumber >= 0;
        } while (!flagChoise);
        return inputNumber;
    }
//stampa
    public static void printSequence() {
        int num1 = 0;
        int num2 = 1;
        int num3;

        int userInput = requestInput("Quale serie vuoi stampare?");
        // stampo 0 e 1 che sono sempre i primi due numeri della serie
        System.out.println(num1);
        System.out.println(num2);

        for (int i = 0; i < userInput; i++) {
            num3 = num1 + num2;
            System.out.println(num3);
            num1 = num2;
            num2 = num3;
        }
    }
//cerca numero
    public static void searchNumberInSequence() {

        int numSearch = requestInput("Inserisci il numero che vuoi cercare nella serie");
        int index = 0;
        int n1 = 0;
        int n2 = 1;
        int n3;

        while (index < 30) {
            n3 = n1 + n2;
            n1 = n2;
            n2 = n3;
            numsGenerated.add(n3);
            index++;
        }
        // controlla se il numero fa parte della serie
        if (numsGenerated.contains(numSearch)) {
            System.out.println("Il numero " + numSearch + " fa parte della serie");
        } else {
            System.out.println("Il numero " + numSearch + " non fa parte della serie");
        }
    }
//connessione 
    public static void connection() {
        // Connessione database --------------------------------------------
        String DB_URL = "jdbc:mysql://localhost:3306/world";
        String DB_USERNAME = "root";
        String DB_PASSWORD = "Vivident.root";
        String DB_DRIVER = "com.mysql.cj.jdbc.Driver";

        Connection conn = null;
        try {
            Class.forName(DB_DRIVER);
            conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            if (conn != null) {
                System.out.println("Connessione eseguita");

            } else {
                System.out.println("Connessione fallita");
            }
            Statement stm = conn.createStatement();
            int choiseQuery = requestInput("Scegli una query casualmente, inserisci un numero fra 0 e 4", 4);
            String query = returnChoiseQuery(choiseQuery);
            ResultSet rs = stm.executeQuery("Select city.name,city popolazione From world Where city.name=='Italia'  AND city.popolazione >100k ");
            while (rs.next()) {
                String stringa = String.format("ID: %d; Name: %s;  ",
                        rs.getInt(1),
                        rs.getString(2));
                System.out.println(stringa);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//sceglie la  query
    public static String returnChoiseQuery(int choise) {
        String s = "";
        switch (choise) {
            case 0:
                s = query1();
                break;
            case 1:
                s = query2();
                break;
            case 2:
                s = query3();
                break;
            case 3:
                s = query4();
                break;
            case 4:
                s = query5();
                break;
            case 5:
                s = query6();
                break;
            default:
                break;
        }

        return s;
    }
//varie query
    public static String query1() {
        // Lingua e Nazione di Ogni Città
        System.out.println("Lingua e Nazione di Ogni Città");
        return "SELECT co.code, c.name, co.name, cl.language, cl.percentage FROM city as c INNER JOIN country as co ON c.CountryCode = co.code INNER JOIN countrylanguage as cl on co.code = cl.countryCode order by c.name ASC;";
    }

    public static String query2() {
        // Numero di Città per Nazione
        System.out.println("Numero di Città per Nazione");
        return "SELECT co.Code, co.name, COUNT(city.name) FROM country as co INNER JOIN city ON co.Code = city.CountryCode GROUP BY co.name ORDER BY COUNT(city.name);";
    }

    public static String query3() {
        // Repubbliche con aspettativa di vita maggiore 70 e lingua
        System.out.println("Repubbliche con aspettativa di vita maggiore 70 e lingua");
        return "SELECT co.Code, co.name, co.GovernmentForm, cl.Language, co.LifeExpectancy FROM country as co inner join countrylanguage as cl on co.Code = cl.CountryCode where co.LifeExpectancy>70 AND co.GovernmentForm like 'Republic' and cl.IsOfficial='T' ORDER BY co.LifeExpectancy desc";
    }

    public static String query4() {
        // 5 cita da city
        System.out.println("5 cita da city");
        return "select * from city Limit 5";
    }

    public static String query5() {
        // Creare una view di city del database world su una query che mostra le città
        // italiane. Su questa VIEW eseguire una query che mostra solo le città con una
        // popolazione inferiore ai 100k.
        System.out.println(
                "Creare una view di city del database world su una query che mostra le città italiane. Su questa VIEW eseguire una query che mostra solo le città con una popolazione inferiore ai 100k.");
        return "Create View cityView Select city.name,city popolazione From world Where city.name=='Italia'  AND city.popolazione >100k ";
    }

    public static String query6() {
        // view
        System.out.println("mostra la view");
        return "SELECT * FROM cityViewita ";
    }
    public static void connectionView() {
        try {
            // Stabilisce la connessione al database
            Connection conn = DriverManager.getConnection(
               "jdbc:mysql://localhost:3306/world", "root", "Vivident.root");
   
            // Crea uno statement
            Statement stmt = conn.createStatement();
            // String query = "SELECT * FROM cityViewita ";
            int choiseQuery = requestInput("Scegli una query casualmente, inserisci un numero fra 0 e 5", 5);
            //Fa la query
            ResultSet rs = stmt.executeQuery(returnChoiseQuery(choiseQuery));
   
            // Recupera i metadati dalla vista
            ResultSetMetaData rsmd = rs.getMetaData();
            int numColumns = rsmd.getColumnCount();
   
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
   
            // Chiude la connessione
            conn.close();
         } catch (SQLException e) {
            //errore
            e.printStackTrace();
         }
    }
}