package AIrlineTest;

import java.util.ArrayList;
import java.util.UUID;

public class Airline {
        //Crea una classe Airline che incapsula un elenco di aerei e fornisce metodi per aggiungere e rimuovere aerei dall'elenco.
    private String id  = UUID.randomUUID().toString();
    private String nome;
    private ArrayList<Airplane> arrayAerei = new ArrayList<Airplane>();
    private ArrayList<CargoPlane> arrayAereiCargo = new ArrayList<CargoPlane>();
    private ArrayList<PassengerPlane> arrayAereiPassengers = new ArrayList<PassengerPlane>();

    public String getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public ArrayList<Airplane> getArrayAerei() {
        return arrayAerei;
    }
    public void setArrayAerei(ArrayList<Airplane> arrayAerei) {
        this.arrayAerei = arrayAerei;
    }
    // Crea una classe Airline che incapsula un elenco di aerei e fornisce metodi per aggiungere e rimuovere aerei dall'elenco.

    //aggiunge aereo
    public void addAirplane(Airplane plane){
        System.out.println(getArrayAerei().size());
        getArrayAerei().add(plane);
        System.out.println(getArrayAerei().size());
    }
     //aggiunge aereo Passegeri
     public void addAirplane(CargoPlane plane){
        System.out.println(this.arrayAereiCargo.size());
        this.arrayAereiCargo.add(plane);
        System.out.println(this.arrayAereiCargo.size());
    }
     //aggiunge aereo Cargo
     public void addAirplane(PassengerPlane plane){
        System.out.println(this.arrayAereiPassengers.size());
        this.arrayAereiPassengers.add(plane);
        System.out.println(this.arrayAereiPassengers.size());
    }
    //elimina aereo
    public void removeAirplane(Airplane plane){
        System.out.println(getArrayAerei().size());
        getArrayAerei().remove(plane);
        System.out.println(getArrayAerei().size());
    }
    public void removeAirplane(CargoPlane plane){
        System.out.println(arrayAereiCargo.size());
        arrayAereiCargo.remove(plane);
        System.out.println(arrayAereiCargo.size());
    }
    public void removeAirplane(PassengerPlane plane){
        System.out.println(this.arrayAereiPassengers.size());
        this.arrayAereiPassengers.remove(plane);
        System.out.println(this.arrayAereiPassengers.size());
    }

    //Crea un metodo nella classe Airline che calcola la capacità totale di carico degli aerei presenti nell'elenco.
    public void capCarico(){
        int capCaricoTot=0;
        for (Airplane airplane : arrayAerei) {
            capCaricoTot += airplane.getCc();
        }
        for (PassengerPlane airplane : arrayAereiPassengers) {
            capCaricoTot += airplane.getCc();
        }
        for (CargoPlane airplane : arrayAereiCargo) {
            capCaricoTot+=airplane.getCc();
        }
        System.out.println(capCaricoTot);
    }

    //Crea un altro metodo nella classe Airline che restituisce un elenco di tutti gli aerei con un determinato numero di posti a sedere.
    public ArrayList<Airplane> getAllPlaneForNposti(int nPosti){
        ArrayList<Airplane> arrayTmpAeri = new ArrayList<>();
        for (Airplane airplane : arrayAerei) {
            if (airplane.getnPosti()>=nPosti) {
                System.out.println(airplane.toString());
                arrayTmpAeri.add(airplane);
            }
        }
        for (PassengerPlane airplane : arrayAereiPassengers) {
            if (airplane.getnPosti()>=nPosti) {
                airplane.stampa();
                arrayTmpAeri.add(airplane);
            }
        }
        for (CargoPlane airplane : arrayAereiCargo) {
            if (airplane.getnPosti()>=nPosti) {
                airplane.stampa();
                arrayTmpAeri.add(airplane);
            }
        }
        return arrayTmpAeri;
    }

    // Crea un altro metodo nella classe Airline che restituisce un elenco di tutti gli aerei cargo con una capacità di carico massima per 
    // singolo collo maggiore di un determinato valore.
    public ArrayList<CargoPlane> getAllCargoPlaneForCmax(int cMax){
        ArrayList<CargoPlane> arrayTmpAeri = new ArrayList<>();
        for (CargoPlane airplane : arrayAereiCargo) {
            if (airplane.getcMax()<=cMax) {
                airplane.toString();
                arrayTmpAeri.add(airplane);
            }
        }
       
        return arrayTmpAeri;
    }

    // Crea un metodo nella classe Airline in modo da restituire una rappresentazione testuale dell'elenco degli aerei
    public void getAllPrintPlane(Airplane plane){
        for (Airplane airplane : arrayAerei) {
            System.out.println(airplane.toString());
        }
    }
    public void getAllPrintPlane(CargoPlane plane){
        for (CargoPlane airplane : arrayAereiCargo) {
            airplane.stampa();
        }
    }
    public void getAllPrintPlane(PassengerPlane plane){
        for (PassengerPlane airplane : arrayAereiPassengers) {
            airplane.stampa();
        }
    }
}
