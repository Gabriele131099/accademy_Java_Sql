package asseblatore;

import java.util.ArrayList;
import java.util.Scanner;

public class assembla {
    public static void main(String[] args) {
        Scanner nScan = new Scanner(System.in);
        int choiseUser = 0;

        ArrayList<Motore> arrayMotori = new ArrayList<>();
        ArrayList<Freni> arrayFreni = new ArrayList<>();
        ArrayList<Macchina> arrayMacchine = new ArrayList<>();

        Motore motore = new Motore(0, "2000", "2");
        arrayMotori.add(motore);
        Motore motore2 = new Motore(1, "3000", "3");
        arrayMotori.add(motore2);

        Freni freni = new Freni(0, "1000", "5");
        arrayFreni.add(freni);
        Freni freni2 = new Freni(1, "3000", "3");
        arrayFreni.add(freni2);

        do {
            System.out.println("0 Ripeti o 1 esci");
            choiseUser = nScan.nextInt();

            if (choiseUser == 0) {
                System.out.println("Scegli l'id di un Motore");
                for (int i = 0; i < arrayMotori.size(); i++) {
                    arrayMotori.get(i).stampa();
                }
                int idCc = nScan.nextInt();

                System.out.println("Scegli l'id di un freno");
                for (int i = 0; i < arrayFreni.size(); i++) {
                    arrayFreni.get(i).stampa();
                }
                int idFreni = nScan.nextInt();

                Macchina macchina = new Macchina(0, createTarga(), arrayFreni.get(idFreni).id,
                        arrayMotori.get(idCc).id);
                arrayMacchine.add(macchina);
                arrayMacchine.get(0).stampa();

                System.out.println("La targa del veicolo è " + macchina.targa + ", con potenza frenante "
                        + arrayFreni.get(macchina.idFreni).ne + ", con cilindrata "
                        + arrayMotori.get(macchina.idPistoni).ci);
            }
        } while (choiseUser == 0);

        for (int i = 0; i < arrayMacchine.size(); i++) {
            System.out.println("La targa del veicolo è " + arrayMacchine.get(i).targa + ", con potenza frenante "
                    + arrayFreni.get(arrayMacchine.get(i).idFreni).ne + ", con cilindrata "
                    + arrayMotori.get(arrayMacchine.get(i).idPistoni).ci);

        }
    }

    public static String createTarga() {
        Scanner rng = new Scanner(System.in);
        System.out.println("Come ti chiami?");
        String nome = rng.nextLine();
        String targa = "";
        targa = nome.charAt(0)
                + nome.charAt(1) + "" + (int) Math.random() * 999 + "" + nome.charAt(nome.length() - 1)
                + nome.charAt(nome.length() - 2);
        return targa;
    }
}
