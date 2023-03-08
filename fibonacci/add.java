package fibonacci;

import java.sql.*;
import java.util.*;

public class add {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Scanner risposta = new Scanner(System.in);
        ArrayList<City> arrayCity = new ArrayList<City>();

        try {
            // Stabilisce la connessione al database
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/world", "root", "Vivident.root");

            // Crea uno statement per recuperare la vista
            String query = "SELECT * FROM city";
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery(query);

            // Chiedi all'utente di inserire la città e la regione da aggiungere
            for (int i = 0; i < 10; i++) {

                // Chiedi all'utente di inserire il nome della città da aggiungere
                System.out.println("Inserisci il nome della città:");
                String nomeCitta = scanner.nextLine();
                 // Chiedi all'utente di inserire La regione della città da aggiungere
                System.out.println("Inserisci la regione della città:");
                String nomeRegione = scanner.nextLine();

                // check citta esiste
                boolean flagCheckSiti = false;
                rs.beforeFirst();
                while (rs.next()) {
                    String nomeCittaTmp = rs.getString("Name");
                    String nomeDistrictTmp = rs.getString("District");
                    if (nomeCittaTmp.equalsIgnoreCase(nomeCitta) && nomeDistrictTmp.equalsIgnoreCase(nomeRegione)) {
                        flagCheckSiti = true;
                        break;
                    }
                }

                if (flagCheckSiti) {
                    System.out.println("La città esiste già.");
                } else {
                    // dati città
                    System.out.println("Inserisci la sigla della nazione: Es ITA,ENG,ALB");
                    String countryCode = scanner.nextLine();
                    System.out.println("Inserisci il conto della popolazione:");
                    int popolazione = scanner.nextInt();
                    City city = new City(nomeCitta, countryCode, nomeRegione,
                            popolazione);
                    arrayCity.add(city);

                    System.out.println("La città è stata aggiunta in locale.");
                }
                
                
                System.out.println("Vuoi inserire un'altra città? (s/n)");
                String risposta2 = risposta.nextLine().toLowerCase();
                if (!risposta2.equals("s")) {
                    break;
                }
            }
           //conferma
                System.out.println("Vuoi inserire le citta? (s/n)");
                String risposta3 = risposta.nextLine().toLowerCase();
                if (risposta3.equals("s")) {
                    // aggiunge tutte le città
                for (City city : arrayCity) {
                    rs.moveToInsertRow();
                    rs.updateString("Name", city.getName());
                    rs.updateString("CountryCode", city.getCountryCode());
                    rs.updateString("District", city.getDistrict());
                    rs.updateInt("Population", city.getPopulation());
                    rs.insertRow();
                    rs.moveToCurrentRow();
                    System.out.println(city.Name + " Aggiunta al db");
                }
            }else{
                System.out.println("Inserimento annullato");
            }
            conn.close();
            fibonacci.main(args);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
