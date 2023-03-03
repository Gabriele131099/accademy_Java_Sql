package ristorante;

import java.util.ArrayList;
import java.util.Scanner;

public class menu {
    public static ArrayList<Ingrediente> addIngredientInternalMethod(String[] array) {
        ArrayList<Ingrediente> arrayTmp = new ArrayList<Ingrediente>();
        for (int i = 0; i < array.length; i++) {
            Ingrediente ingrediente = new Ingrediente(array[i]);
            arrayTmp.add(ingrediente);
        }
        return arrayTmp;
    }

    public static ArrayList<Piatto> main(ArrayList<Piatto> arrayPiatto, ArrayList<User> arrayUser) {

        // scanner
        Scanner sScan = new Scanner(System.in); // stringhe
        Scanner nScan = new Scanner(System.in); // numeri
        // ingredienti da aggiungere
        String[] arrayIngredientiAdd = { "olio piccante", "grana" };
        // // Ingredienti
        ArrayList<Ingrediente> arrayIngredienti = new ArrayList<Ingrediente>();
        ArrayList<Ingrediente> arrayIngredientiStatici = new ArrayList<Ingrediente>();
        String[] arrayIngredientiPrev = { "Pasta", "Pecorino" };
        arrayIngredientiStatici = addIngredientInternalMethod(arrayIngredientiPrev);
        // // Piatti
        String[] arrayTypePasta = { "fusilli", "pennette", "spagetti", "pasta dello chef" };

        // // Ordini
        ArrayList<Ordine> arrayOrdini = new ArrayList<Ordine>();
        Ordine ordine = new Ordine(0, 0);
        arrayOrdini.add(ordine);
        boolean flagEnterInMenu = false;

        do {
            System.out.println("Vuoi Ordinare? 0, altro 1 ");
            flagEnterInMenu = (nScan.nextInt() == 0);
            System.out.println("Vuoi ordinare o eseguire un altra azione? 0 o 1");
            int optionMenu = nScan.nextInt();
            switch (optionMenu) {
                case 0:
                    double pricePLate = ordina(nScan, arrayPiatto, arrayIngredientiAdd, arrayTypePasta);
                    for (User user : arrayUser) {
                        // && user.getId().equals(idUser
                        if (user.getLog()) {
                            System.out.println(user.pay((int) pricePLate));
                        }
                    }
                    break;
                case 1:

                    boolean admin = false;
                    for (User user : arrayUser) {
                        if (user.getLog()) {
                            admin = user.getAdmin();
                            System.out.println(
                                    "Il tuo account è di tipo " + (user.getAdmin() ? "admin" : "user"));
                        }
                    }
                    if (admin) {
                        modifyPlate(arrayPiatto, nScan, sScan);
                    } else {
                        System.out.println("Fai l'accesso con un profilo admin");
                    }
                    break;

                default:
                    break;
            }

        } while (flagEnterInMenu);

        return arrayPiatto;
    }

    public static double ordina(Scanner nScan, ArrayList<Piatto> arrayPiatto, String[] arrayIngredientiAdd,
            String[] arrayTypePasta) {
        System.out.println("Scegli il tuo ordine");
        for (int i = 0; i < arrayPiatto.size(); i++) {
            arrayPiatto.get(i).stampa(i);
        }
        int pricePlate = 0;
        int pricePasta = 0;
        // cerca piatto
        Piatto choisePlate = foundPlate(nScan, arrayPiatto);
        int price = choisePlate.getPrezzo();
        System.out.println(choisePlate);
        boolean checkPlate = choisePlate != null;
        // scelta del tipo di pasta
        if (checkPlate) {
            int countAddIngredienti = 0;
            System.out.println("hai scelto il piatto " + choisePlate.getNome());
            pricePasta = choisePastaType(nScan, arrayTypePasta, choisePlate);
            countAddIngredienti = returnNIngredient(nScan, arrayIngredientiAdd, choisePlate);
            pricePlate = price + countAddIngredienti + (pricePasta) + (countAddIngredienti * 2) ;
            stampaOrdine(choisePlate, countAddIngredienti, pricePasta, pricePlate);
        }
        return pricePlate;
    }

    public static Piatto foundPlate(Scanner nScan, ArrayList<Piatto> arrayPiatto) {
        int optionPlate;
        do {
            System.out.println("Scegli il piatto");
            optionPlate = nScan.nextInt();
        } while (optionPlate >= arrayPiatto.size());
        Piatto choisePlate = arrayPiatto.get(optionPlate);
        System.out.println(arrayPiatto.get(optionPlate));
        return choisePlate;
    }

    public static int choisePastaType(Scanner nScan, String[] arrayTypePasta, Piatto choisePlate) {
        System.out.println("Scegli una pasta");
        for (int i = 0; i < arrayTypePasta.length; i++) {
            System.out.println((i == (arrayTypePasta.length - 1) ? arrayTypePasta.length + " altro" : i) + " "
                    + arrayTypePasta[i]);
        }
        int choisePasta = nScan.nextInt();
        int pricePasta = choisePasta > 3 ? 3 : choisePasta;
        String typePasta = arrayTypePasta[pricePasta];
        // choisePlate.setIngredient(0, typePasta);

        return pricePasta;
    }

    public static int returnNIngredient(Scanner nScan, String[] arrayIngredientiAdd, Piatto choisePlate) {
        Boolean addIngredientsFlag = false;
        int countAddIngredienti = 0;
        do {
            System.out.println("Vuoi aggiungere qualcosa? 0 o 1");
            addIngredientsFlag = nScan.nextInt() == 0;
            if (addIngredientsFlag) {
                System.out.println("Scegli uno degli ingredienti");
                for (String aggiunta : arrayIngredientiAdd) {
                    System.out.println(aggiunta);
                }

                if (nScan.nextInt() <= arrayIngredientiAdd.length) {
                    countAddIngredienti++;
                    System.out.println("aggiunto");
                    // choisePlate.addIngredient(arrayIngredientiAdd[choiseAdd]);
                }
            }
        } while (addIngredientsFlag);

        return countAddIngredienti;
    }

    public static void stampaOrdine(Piatto choisePlate, int countAddIngredienti, int pricePasta, int pricePlate) {
        System.out.println("Prezzo del piatto " + choisePlate.prezzo);
        System.out.println("Prezzo delle aggiunte " + (countAddIngredienti * 2));
        System.out.println("Prezzo pasta scelta " + (pricePasta));
        System.out.println("Il Piatto costa "
                + (pricePlate));
        System.out.println("Buon apetito");
    }

    public static Piatto requestDataPlate(Piatto plate, Scanner nScan, Scanner sScan) {
        System.out.println("hai scelto il piatto " + plate.getNome());
        System.out.println("Inserisci il nome");
        String nomePLate = sScan.nextLine();
        System.out.println("Inserisci il prezzo");
        int price = nScan.nextInt();
        System.out.println("Inserisci i nuovi ingredienti");
        ArrayList<Ingrediente> arrayIngredientiTmp = new ArrayList<Ingrediente>();
        Boolean flagAddIngredient = false;
        do {
            if (arrayIngredientiTmp.size() > 2) {
                System.out.println("Vuoi inserire un ingrediente?0 o 1");
                flagAddIngredient = nScan.nextInt() == 0;
            } else {
                System.out.println("Inserisci " + (2 - arrayIngredientiTmp.size()) + "ingredienti");
            }
            if (flagAddIngredient) {
                String nomeIngrediente = sScan.nextLine();
                Ingrediente nome = new Ingrediente(nomeIngrediente);
                arrayIngredientiTmp.add(nome);
            }
        } while (flagAddIngredient);
        plate.setNome(nomePLate);
        plate.setPrezzo(price);
        plate.setIdIngredienti(arrayIngredientiTmp);
        return plate;
    }

    public static void modifyPlate(ArrayList<Piatto> arrayPiatto, Scanner nScan, Scanner sScan) {
        System.out.println("puoi fare le modifiche");
        for (int i = 0; i < arrayPiatto.size(); i++) {
            arrayPiatto.get(i).stampa(i);
        }
        System.out.println("Scegli un piatto");
        Piatto plate = foundPlate(nScan, arrayPiatto);

        if (plate != null) {
            plate = requestDataPlate(plate, nScan, sScan);
        }

    }
}
