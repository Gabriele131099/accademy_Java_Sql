import java.util.Scanner;
import java.util.ArrayList;

public class login3 {
    public static void main(String[] args) {
          // array dessert
          ArrayList<String> arraydessert = new ArrayList<String>();
          arraydessert.add("formagelle");
          arraydessert.add("seadas");
          arraydessert.add("ricotelle");
        // array Piatto
        ArrayList<String> arrayPlateName = new ArrayList<String>();
        arrayPlateName.add("carbonara");
        arrayPlateName.add("amatriciana");
        arrayPlateName.add("ragu");
        // array quantity
        ArrayList<Integer> arrayQuantity = new ArrayList<Integer>();
        arrayQuantity.add(1);
        arrayQuantity.add(10);
        arrayQuantity.add(10);
        // array Prezzi
        ArrayList<Integer> arrayPrice = new ArrayList<Integer>();
        arrayPrice.add(20);
        arrayPrice.add(15);
        arrayPrice.add(10);
        // array ingredienti
        ArrayList<String> arrayIngredienti = new ArrayList<String>();
        arrayIngredienti.add("uovo,pecorino,guanciale");
        arrayIngredienti.add("pomodoro,cipolla,guanciale");
        arrayIngredienti.add("pomodoro,manzo");
        // tot visitatori
        int nVis = 0;
        // nome
        String name = "Filippo";
        String password = "123456";
        // budget cliente
        int budgetSingleClient = 0;
        // incasso
        int incasso = 0;
        //flag ordine dessert
        boolean flagDessert = false;
        int counterOrder = 0;
        // Scanner
        Scanner dataStringPlate = new Scanner(System.in);
        Scanner nScan = new Scanner(System.in);
        int choiseMenu = 0;

        do {
            nVis++;
            System.out.println("Sei il visitatore numero " + nVis);
            System.out.println("0 Ordina, 1 Visualizza, 2 Modifica Menu, 3 Esci");
            choiseMenu = nScan.nextInt();
            switch (choiseMenu) {
                // Ordina
                case 0:
                    System.out.println("Ordina");
                    if (counterOrder>=2) {
                        System.out.println("I nostri dolci");
                        viewPlate(arraydessert);
                        System.out.println("Vuoi ordinare un dolce? 1 si 2 no");
                        if (nScan.nextInt()==1) {
                           int indexDessert = searchPlate(arraydessert);
                           System.out.println("hai scelto il dessert " + arraydessert.get(indexDessert));
                           budgetSingleClient-= arrayQuantity.get(indexDessert);
                           incasso+=arrayQuantity.get(indexDessert);
                        }
                        
                    }
                    budgetSingleClient = (int) (Math.random() * 101);
                    System.out.println("Il tuo budget è " + budgetSingleClient);
                    // mostra i piatti
                    viewPlate(arrayPlateName);
                    // trova il piatto
                    // System.out.println(arrayPlateName.size());
                    if (arrayPlateName.size() != 0) {
                        int indexPlate = searchPlate(arrayPlateName);
                        System.out.println(indexPlate);
                        int choiseBuyPlate = nScan.nextInt();
                        // acquisto
                        if (choiseBuyPlate == 1 && budgetSingleClient >= arrayPrice.get(indexPlate) && arrayQuantity.get(indexPlate)>0) {
                            System.out.println("Acquisto effetuato");
                            counterOrder++;
                            budgetSingleClient -= arrayPrice.get(indexPlate);
                            incasso += arrayPrice.get(indexPlate);
                            arrayQuantity.set(indexPlate, arrayQuantity.get(indexPlate)-1);
                            System.out.println("ti rimangono " + budgetSingleClient);
                        } else {
                            if (budgetSingleClient < arrayPrice.get(indexPlate)) {
                                System.out.println("non hai abbastanza soldi");
                            }
                            if (choiseBuyPlate != 1) {
                                System.out.println("hai annullato il tuo acquisto");
                            }
                            if (arrayQuantity.get(indexPlate)<1) {
                                System.out.println("Quantità esaurita, mi dispiace");
                            }
                        }
                    } else {
                        System.out.println("Il menu dei piatti è vuoto");
                    }
                    break;
                // Visualizza
                case 1:
                    System.out.println("Visualizza");
                    viewPlateFull(arrayPlateName, arrayPrice, arrayIngredienti,arrayQuantity);
                    break;
                // modifica
                case 2:
                    System.out.println("Modifica");
                    int choiseModify = 0;
                    System.out.println("Inserisci i tuoi dati per l'accesso");
                    System.out.println("username");
                    String user = dataStringPlate.nextLine();
                    System.out.println("password");
                    String passwordUser = dataStringPlate.nextLine();
                    if (passwordUser.equals(password) && user.toLowerCase().equals(name.toLowerCase())) {
                        do {
                            System.out.println("0 modifica, 1 aggiungi, 2 elimina");
                            choiseModify = nScan.nextInt();
                        } while (choiseModify > 2);
                        switch (choiseModify) {
                            case 0:
                                // modifica i piato
                                System.out.println("Modifica un piatto");
                                viewPlate(arrayPlateName);
                                int indexPlateModify = searchPlate(arrayPlateName);
                                // System.out.println(indexPlateModify);
                                int choiseModifyPlate = nScan.nextInt();
                                // inserimento dati piatto
                                if (choiseModifyPlate == 1) {
                                    System.out.println("Modifica " + arrayPlateName.get(indexPlateModify));
                                    System.out.println("Inserisci il nome");
                                    arrayPlateName.set(indexPlateModify, dataStringPlate.nextLine());
                                    System.out.println("Inserisci un nuovo prezzo");
                                    arrayPrice.set(indexPlateModify, nScan.nextInt());
                                    String ingredients = insertIngredients();
                                    arrayIngredienti.set(indexPlateModify, ingredients);
                                    viewSinglePlateFull(indexPlateModify, arrayPlateName, arrayPrice, arrayIngredienti,arrayQuantity);
                                } else {
                                    if (choiseModifyPlate != 1) {
                                        System.out.println("hai annullato");
                                    }
                                }
                                break;
                            case 1:
                                // dati del piato da aggiungere
                                System.out.println("Aggiungi un piatto");
                                System.out.println("nome");
                                String nomePlate = dataStringPlate.nextLine();
                                System.out.println("prezzo");
                                int pricePlate = nScan.nextInt();
                                System.out.println("Quantità");
                                int quantity = nScan.nextInt();
                                String ingredients = insertIngredients();
                                System.out.println("Confermi i dati? 0 si, 1 no");
                                // aggiungi piatto
                                if (nScan.nextInt() == 0) {
                                    arrayPlateName.add(nomePlate);
                                    arrayPrice.add(pricePlate);
                                    arrayQuantity.add(quantity);
                                    arrayIngredienti.add(ingredients);
                                    viewPlate(arrayPlateName);
                                } else {
                                    System.out.println("annullato");
                                }
                                break;
                            case 2:
                                // elimina piatto
                                System.out.println("Elimina un piatto");
                                viewPlate(arrayPlateName);
                                int indexPlateRemove = searchPlate(arrayPlateName);
                                System.out.println(
                                        "hai scelto " + arrayPlateName.get(indexPlateRemove) + ", 1 elimina 2 annulla");
                                if (nScan.nextInt() == 1) {
                                    arrayPlateName.remove(indexPlateRemove);
                                    arrayIngredienti.remove(indexPlateRemove);
                                    arrayQuantity.remove(indexPlateRemove);
                                    arrayPrice.remove(indexPlateRemove);
                                    System.out.println("Eliminato");
                                    viewPlate(arrayPlateName);
                                } else {
                                    System.out.println("Annullato");
                                }
                                break;
                            default:
                                break;
                        }
                    } else {
                        System.out.println("Credenziale errate");
                    }

                    break;
                default:
                    break;
            }
            // incasso
            System.out.println("Incasso di " + incasso);
        } while (choiseMenu < 3);
    }

    static void viewPlate(ArrayList<String> array) {
        // visualizza solo i nomi dei piatti
        for (int j = 0; j < array.size(); j++) {
            System.out.println(array.get(j) + ", ");
        }
    }

    static void viewPlateFull(ArrayList<String> array1, ArrayList<Integer> array2, ArrayList<String> array3, ArrayList<Integer> array4) {
        // visualizza nomiprezzieingredienti dei piatti
        for (int j = 0; j < array1.size(); j++) {
            System.out.println("Piatto " + j + ": " + array1.get(j) + ", Prezzo: "
                    + array2.get(j) + ", Ingredient: " + array3.get(j)+", quantità: "+array4.get(j));
        }
    }

    static void viewSinglePlateFull(int j, ArrayList array1, ArrayList array2, ArrayList array3, ArrayList<Integer> array4) {
        // visualizza un piatto per intero
        System.out.println("Piatto " + j + ": " + array1.get(j) + ", Prezzo: "
                + array2.get(j) + ", Ingredient: " + array3.get(j)+", quantità: "+array4.get(j));

    }

    static int searchPlate(ArrayList<String> array) {
        // cerca piatto e ne restituisce il suo indice
        Scanner dataString = new Scanner(System.in);
        int indexPlate = 0;
        if (array.size() > 0) {
            do {
                System.out.println("Scegli uno dei piatti");
                indexPlate = array.indexOf(dataString.nextLine().toLowerCase());
                if (indexPlate >= 0) {
                    System.out.println(
                            "Vuoi scegliere il Piatto " + array.get(indexPlate) + " ? 1 si 2 no");
                } else {
                    System.out.println("Scelta errata, scegliere un piatto esistente");
                }
            } while (indexPlate < 0);
        }
        return indexPlate;
    }

    static String insertIngredients() {
        // inserisce gli ingredienti in una variabile e li restituisce
        Scanner dataStringIngredients = new Scanner(System.in);
        Scanner dataIntIngredScanner = new Scanner(System.in);
        System.out.println("inserisci gli ingredienti");
        int choiseModifyIngredient = 0;
        String ingredients = "";
        int i = 0;
        do {
            if (i > 1) {
                System.out.println("Vuoi aggiungere un ingrediente? 0 si 1 no");
                choiseModifyIngredient = dataIntIngredScanner.nextInt();
                if (choiseModifyIngredient == 0) {
                    System.out.println("nome");
                    ingredients += dataStringIngredients.nextLine() + ", ";
                    i++;
                }
            } else {
                System.out.println("Inserisci almeno " + (2 - i) + " ingredienti");
                System.out.println("nome");
                ingredients += dataStringIngredients.nextLine() + ", ";
                i++;
            }

        } while (choiseModifyIngredient == 0);
        return ingredients;
    }
    static int checkQuantity(ArrayList<Integer> array, int j){
        return j;
    }
}
