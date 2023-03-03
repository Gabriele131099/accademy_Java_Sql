package fibonacci;

import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.sql.Statement;
import java.sql.ResultSet;

public class fibonacci {
    static ArrayList<Integer> numsGenerated = new ArrayList<Integer>();

    public static void main(String[] args) {
        connection();
        // ------------------------------------------------------------------

        boolean keep = true;
        while (keep) {
            Scanner choiceScanner = new Scanner(System.in);
            System.out.println("Vuoi\n[1] Stampare la serie\n[2] Verificare un numero\n[3] Uscire");
            int userChoice = choiceScanner.nextInt();

            switch (userChoice) {
                case 1:
                    printSequence();
                    // inputScanner.close();
                    break;
                case 2:
                    searchNumberInSequence();
                    break;
                case 3:
                    System.out.println("Uscita...");
                    keep = false;
                    break;
                default:
                    System.out.println("Opzione non disponibile");
            }

        }

    }

    public static void printSequence() {
        int num1 = 0;
        int num2 = 1;
        int num3;

        Scanner inputScanner = new Scanner(System.in);
        System.out.println("Quante volte vuoi stampare la serie?");
        int userInput = inputScanner.nextInt();
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

    public static void searchNumberInSequence() {
        Scanner numScanner = new Scanner(System.in);
        System.out.println("Inserisci il numero che vuoi ricercare");
        int numToCheck = numScanner.nextInt();
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
        // controllo se il numero fa parte della serie
        if (numsGenerated.contains(numToCheck)) {
            System.out.println("Il numero " + numToCheck + " fa parte della serie");
        } else {
            System.out.println("Il numero " + numToCheck + " non fa parte della serie");
        }
    }

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
                System.out.println("Connessione eseguita con successo");

            } else {
                System.out.println("Connessione fallita");
            }
            Statement stm = conn.createStatement();

            ResultSet rs = stm.executeQuery(query3());
            while (rs.next()) {
                String stringa = String.format("ID: %d; Name: %s;  ",
                        rs.getInt(1),
                        rs.getString(3));
                System.out.println(stringa);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String query1() {
        // Lingua e Nazione di Ogni Città
        return "SELECT co.code, c.name, co.name, cl.language, cl.percentage FROM city as c INNER JOIN country as co ON c.CountryCode = co.code INNER JOIN countrylanguage as cl on co.code = cl.countryCode order by c.name ASC;";
    }

    public static String query2() {
        // Numero di Città per Nazione
        return "SELECT co.Code, co.name, COUNT(city.name) FROM country as co INNER JOIN city ON co.Code = city.CountryCode GROUP BY co.name ORDER BY COUNT(city.name);";
    }

    public static String query3() {
        // Repubbliche con aspettativa di vita maggiore 70 e lingua
        return "SELECT co.Code, co.name, co.GovernmentForm, cl.Language, co.LifeExpectancy FROM country as co inner join countrylanguage as cl on co.Code = cl.CountryCode where co.LifeExpectancy>70 AND co.GovernmentForm like 'Republic' and cl.IsOfficial='T' ORDER BY co.LifeExpectancy desc";
    }

    public static String query4() {
        // 5 cita da city
        return "select * from city Limit 5";
    }
}