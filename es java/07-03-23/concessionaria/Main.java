package concessionaria;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // array moto e macchina
        ArrayList<Auto> arrayAuto = new ArrayList<>();
        ArrayList<Moto> arrayMoto = new ArrayList<>();
        // Macchine Auto
        Auto mac1 = new Auto("Ford", "Focus", 2000, 3,
                "Disel", 26);
        Auto mac2 = new Auto("Opel", "Corsa", 2006, 5,
                "Benzina", 23);
        arrayAuto.add(mac1);
        arrayAuto.add(mac2);

        // Moto
        Moto moto1 = new Moto("Aprilia", "X12", 2008, 400,
                "Sportiva", 200);
        Moto moto2 = new Moto("BMW", "Y2", 2015, 600,
                "Strada", 500);
        arrayMoto.add(moto1);
        arrayMoto.add(moto2);

        Boolean flagChoiseUser = false;
        String allTypeMoto ="Scegli il tipo di moto: ";
        String[] typeMoto  = {"sportiva","strada","cross"};
        for (int i = 0; i < typeMoto.length; i++) {
            allTypeMoto+=(i==0?"":", ")+i+" "+typeMoto[i].toUpperCase();
        }
        do {
            int choiseUser = requestInput("Vuoi creae un Auto o una moto? 0 o 1, 2 esci", 3);
            flagChoiseUser = choiseUser < 2;
            if (choiseUser == 0) {
                System.out.println("Crea una macchina");
                Auto mac = new Auto(requestInputString("Marca"), requestInputString("Modello"), requestInputInt("Anno Fabbricazione"), requestInputInt("Numero Porte"),
                requestInputString("Tipo Carburante"), requestInputInt("Consumo per 100km"));
                
                arrayAuto.add(mac);
                System.out.println("Hai creato un Auto");
                mac.stampaMacchina();
            }
            if (choiseUser == 1) {
                System.out.println("Crea una moto");
                Moto moto = new Moto(requestInputString("Marca"), requestInputString("Modello"), requestInputInt("Anno Fabbricazione"), requestInputInt("Cilindrata"),
                        typeMoto[requestInput(allTypeMoto,typeMoto.length-1)], requestInputInt("Potenza"));

                arrayMoto.add(moto);
                System.out.println("Hai creato una moto");
                moto.stampaMoto();
            }
            if (choiseUser > 1) {
                System.out.println("Ciao amico");
            }
        } while (flagChoiseUser);

        System.out.println("Tutte le nostre Moto".toUpperCase());
        for (Moto moto : arrayMoto) {
            moto.stampaMoto();
            System.out.println();
        }

        System.out.println("Tutte le nostre Auto".toUpperCase());
        for (Auto mac : arrayAuto) {
            mac.stampaMacchina();
            System.out.println();
        }
        
    }

    public static int requestInput(String request, int choiseMax) {
        Scanner nScan = new Scanner(System.in);
        Boolean flagChoise = false;
        int inputNumber = 0;
        do {
            System.out.println(request);
            inputNumber = nScan.nextInt();
            flagChoise = (inputNumber >= 0 && inputNumber <= choiseMax);
        } while (!flagChoise);
        return inputNumber;
    }
    public static int requestInputInt(String request) {
        Scanner nScan = new Scanner(System.in);
        int inputNumber = 0;
            System.out.println(request);
            inputNumber = nScan.nextInt();
        return inputNumber;
    }
    public static String requestInputString(String request) {
        Scanner sScan = new Scanner(System.in);
        String inputString;
            System.out.println(request);
            inputString = sScan.nextLine();
        return inputString;
    }
}
