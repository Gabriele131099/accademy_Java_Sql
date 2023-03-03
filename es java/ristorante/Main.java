package ristorante;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static ArrayList<Ingrediente> addIngredientInternalMethod(String[] array) {
        ArrayList<Ingrediente> arrayTmp = new ArrayList<Ingrediente>();
        for (int i = 0; i < array.length; i++) {
            Ingrediente ingrediente = new Ingrediente(array[i]);
            arrayTmp.add(ingrediente);
        }
        return arrayTmp;
    }

    public static void main(String[] args) {
        //array user
        ArrayList<User> arrayUser = new ArrayList<>();
        // scanner
        Scanner nScan = new Scanner(System.in); // numeri
        // ingredienti da aggiungere
        // // Ingredienti
        ArrayList<Ingrediente> arrayIngredienti = new ArrayList<Ingrediente>();
        ArrayList<Ingrediente> arrayIngredientiStatici = new ArrayList<Ingrediente>();
        String[] arrayIngredientiPrev = { "Pasta", "Pecorino" };
        arrayIngredientiStatici = addIngredientInternalMethod(arrayIngredientiPrev);
        // // Piatti
        ArrayList<Piatto> arrayPiatto = new ArrayList<Piatto>();
        arrayIngredienti.clear();
        String[] arrTmp = { "sugo", "origano" };
        arrayIngredienti = addIngredientInternalMethod(arrTmp);
        Piatto piattoRosso = new Piatto("Pasta rossa", 23, arrayIngredienti,
                arrayIngredientiStatici);
        arrayPiatto.add(piattoRosso);

        arrayIngredienti.clear();
        String[] arrTmp2 = { "basilico", "Olio", "pinoli" };
        arrayIngredienti = addIngredientInternalMethod(arrTmp2);
        Piatto piattoGreen = new Piatto("Pasta pesto", 30, arrayIngredienti,
                arrayIngredientiStatici);
        arrayPiatto.add(piattoGreen);

        arrayIngredienti.clear();
        String[] arrTmp3 = { "prezzemolo", "Olio", "aglio" };
        arrayIngredienti = addIngredientInternalMethod(arrTmp3);
        Piatto piattoWhite = new Piatto("Pasta bianca", 26, arrayIngredienti,
                arrayIngredientiStatici);
        arrayPiatto.add(piattoWhite);

        // // Ordini
        ArrayList<Ordine> arrayOrdini = new ArrayList<Ordine>();
        Ordine ordine = new Ordine(0, 0);
        arrayOrdini.add(ordine);
        boolean flagEnterInWhile = false;

        do {
            System.out.println("Avvio programma? 0 si 2 no");
            flagEnterInWhile = (nScan.nextInt() == 0);
            if (flagEnterInWhile) {
               arrayUser = login.main(arrayUser);
              
                boolean log = false;
                String idUser = "";
                for (User user : arrayUser) {
                    if (user.getLog()) {
                        log = user.getLog();
                        idUser = user.getId();
                        System.out.println("Il tuo account è di tipo " + (user.getAdmin() ? "admin" : "user"));
                    }
                }
                if (log) {
                   arrayPiatto = menu.main(arrayPiatto,arrayUser);
                }
            }
        } while (flagEnterInWhile);
    }
}
