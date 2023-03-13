package AIrlineTest;

import java.util.ArrayList;

public class AereoportoMain {
// Crea una classe di test che crea un'istanza della classe Airline, aggiunge alcuni aerei all'elenco e invoca i metodi per calcolare 
// la capacità totale di carico degli aerei, recuperare un elenco di aerei con un determinato numero di posti a sedere e recuperare un 
// elenco di aerei cargo con una capacità di carico massima per singolo capacità di peso maggiore di un determinato valore.
    public static void main(String[] args) {
        Airline aereoporto = new Airline();
        Servizio ser1 = new Servizio("Pranzo");
        ArrayList<Servizio> arraySer = new ArrayList<>();
        arraySer.add(ser1);
        // Aeri passeggeri
        PassengerPlane passPlane1 = new PassengerPlane("passener1", 5, 9, arraySer);
        PassengerPlane passPlane2 = new PassengerPlane("passener2", 15, 6, arraySer);
        PassengerPlane passPlane3 = new PassengerPlane("passener3", 12, 7, arraySer);
        //carico gli aeri nell array
        aereoporto.addAirplane(passPlane1);
        aereoporto.addAirplane(passPlane2);
        aereoporto.addAirplane(passPlane3);
        // Aeri Cargo
        CargoPlane cargoPlane1 = new CargoPlane("cargo1", 8, 50, 90);
        CargoPlane cargoPlane2 = new CargoPlane("cargo2", 4, 70, 40);
        CargoPlane cargoPlane3 = new CargoPlane("cargo3", 9, 30, 60);
        //carico gli aeri nell array
        aereoporto.addAirplane(cargoPlane1);
        aereoporto.addAirplane(cargoPlane2);
        aereoporto.addAirplane(cargoPlane3);
        //stampo gli aeri
        System.out.println("Tutti gli aeri ordinati per tipo");
        aereoporto.getAllPrintPlane(passPlane1);
        aereoporto.getAllPrintPlane(cargoPlane1);
        //capacità di carico totale degli aeri
        System.out.println("capacità di carico totale degli aeri");
        aereoporto.capCarico();
        //recuperare un elenco di aerei con un determinato numero di posti a sedere
        System.out.println("/aeri con n posti");
        for (Airplane airplane : aereoporto.getAllPlaneForNposti(5)) {
            airplane.toString();
        }
        //recuperare un elenco di aerei cargo con una capacità di carico massima per singolo capacità di peso maggiore di un determinato valore
        System.out.println("/recuperare un elenco di aerei cargo con una capacità di carico massima");
        aereoporto.getAllCargoPlaneForCmax(60);
    }
}
