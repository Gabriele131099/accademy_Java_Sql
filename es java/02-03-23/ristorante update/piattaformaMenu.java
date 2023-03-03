package ristorante;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public class piattaformaMenu {
    public static void main(String[] args) {
        ArrayList<User> arrayUser = piattaformaLog.main(args);
        // scanner
        Scanner sScan = new Scanner(System.in); // stringhe
        Scanner nScan = new Scanner(System.in); // numeri
        // ingredienti da aggiungere
        String[] arrayIngredientiAdd = { "olio piccante", "grana" };
        // // Ingredienti
        ArrayList<String> arrayIngredienti = new ArrayList<String>();
        ArrayList<String> arrayIngredientiStatici = new ArrayList<String>();
        String[] arrayIngredientiPrev = { "Pasta", "Pecorino" };
        for (String string : arrayIngredientiPrev) {
            arrayIngredientiStatici.add(string);
        }
        // // Piatti
        ArrayList<Piatto> arrayPiatto = new ArrayList<Piatto>();
        arrayIngredienti.clear();
        arrayIngredienti.add("sugo");
        arrayIngredienti.add("origano");
        Piatto piattoRosso = new Piatto(arrayPiatto.size(), "Pasta rossa", 23, arrayIngredienti,
                arrayIngredientiStatici);
        arrayPiatto.add(piattoRosso);

        arrayIngredienti.clear();
        arrayIngredienti.add("basilico");
        arrayIngredienti.add("patate");
        arrayIngredienti.add("olio");
        Piatto piattoGreen = new Piatto(arrayPiatto.size(), "Pasta pesto", 30, arrayIngredienti,
                arrayIngredientiStatici);
        arrayPiatto.add(piattoGreen);

        arrayIngredienti.clear();
        arrayIngredienti.add("aglio");
        arrayIngredienti.add("prezzemolo");
        arrayIngredienti.add("olio");
        Piatto piattoWhite = new Piatto(arrayPiatto.size(), "Pasta bianca", 26, arrayIngredienti,
                arrayIngredientiStatici);
        arrayPiatto.add(piattoWhite);

        // // Ordini
        ArrayList<Ordine> arrayOrdini = new ArrayList<Ordine>();
        Ordine ordine = new Ordine(0, 0, 0);
        arrayOrdini.add(ordine);
        boolean flagEnterInMenu = false;
        do {
            System.out.println("Vuoi usare il menu? 0 e 1 ");
            flagEnterInMenu = nScan.nextInt() == 0;
            System.out.println("Vuoi ordinare o eseguire un altra azione?0 e 1");
            int optionMenu = nScan.nextInt();
            switch (optionMenu) {
                case 0:
                    System.out.println("Preparati ad ordine");
                    for (Piatto ordine2 : arrayPiatto) {
                        ordine2.stampa();
                    }
                    System.out.println("Scegli un piatto");
                    int optionPlate = nScan.nextInt();
                    for (Piatto plate : arrayPiatto) {
                        if (plate.id == optionPlate) {
                            System.out.println("hai scelto il piatto " + plate.nome);
                            Boolean addIngredientsFlag = false;
                            int pricePlate = 0;
                            int countAddIngredienti = 0;
                            do {
                                System.out.println("Vuoi aggiungere qualcosa?0 e 1");
                                addIngredientsFlag = nScan.nextInt() == 0;
                                if (addIngredientsFlag) {
                                    System.out.println("Scegli uno degli ingredienti");
                                    for (String aggiunta : arrayIngredientiAdd) {
                                        System.out.println(aggiunta);
                                    }
                                    int choisePlate = nScan.nextInt();
                                    countAddIngredienti++;
                                    plate.idIngredienti.add(arrayIngredientiAdd[choisePlate]);
                                }
                            } while (addIngredientsFlag);
                            System.out.println("Scegli una pasta");
                            System.out.println("1 fusilli, 2 pennette,3 spaghetti, altro decisione dello chef");
                            int choisePasta = nScan.nextInt();
                            String typePasta = "pasta";
                            if (choisePasta == 1) {
                               typePasta = "fusilli";
                            }
                            if (choisePasta == 2) {
                                typePasta = "pennette";
                             }
                             if (choisePasta == 3) {
                                typePasta = "spaghetti";
                             }
                            plate.setIngredient(0,typePasta);
                            System.out.println("Prezzo del piatto " + plate.prezzo);
                            System.out.println("Prezzo delle aggiunte " + (countAddIngredienti*2));
                            System.out.println("Prezzo pasta scelta " + choisePasta);
                            System.out.println("Il Piatto costa " + (plate.prezzo + choisePasta + (countAddIngredienti*2)));
                            System.out.println("Buon apetito");
                            for (User user : arrayUser) {
                                if (user.log) {
                                    user.update(plate.prezzo + choisePasta + (countAddIngredienti*2));
                                    System.out.println("Il tuo budget rimanente è pari a " + user.getBudget());
                                }
                            }
                        }
                    }
                    break;
                case 1:
                    System.out.println("Ricordiamo che per effettuare altre operazioni, serve un profile admin");
                    boolean admin = false;
                    for (User user : arrayUser) {
                        if (user.log) {
                            admin = user.admin;
                            System.out.println("Il tuo account è di tipo " + (user.admin ? "admin" : "user"));
                        }
                    }
                    if (admin) {
                        System.out.println("puoi fare le modifiche");
                        for (Piatto piatto : arrayPiatto) {
                            piatto.stampa();
                        }
                        System.out.println("Scegli un piatto");
                        optionPlate = nScan.nextInt();
                        for (Piatto plate : arrayPiatto) {
                            if (plate.id == optionPlate) {
                                System.out.println("hai scelto il piatto " + plate.nome);
                                System.out.println("Inserisci il nome");
                                String nomePLate = sScan.nextLine();
                                System.out.println("Inserisci il prezzo");
                                int price = nScan.nextInt();
                                System.out.println("Inserisci i nuovi ingredienti");
                                ArrayList<Ingrediente> arrayIngredientiTmp = new ArrayList<Ingrediente>();
                                do {
                                    String nomeIngrediente = sScan.nextLine();

                                } while (nScan.nextInt() == 0);

                            }
                        }
                    } else {
                        System.out.println("Fai l'accesso con un profilo admin");
                    }
                    break;

                default:
                    break;
            }
        } while (flagEnterInMenu);
    }
}
