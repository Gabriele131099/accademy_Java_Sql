import java.text.DecimalFormat;
import java.util.*; // import the Scanner class

public class es1 {
    public static void main(String[] args) {
        // standar numeri decimali
        DecimalFormat df = new DecimalFormat("###.##");
        // scanner per scelta piatto
        Scanner newPlateIntObj = new Scanner(System.in);
        // scanner per scelta piatto
        Scanner newPlateStringObj = new Scanner(System.in);
        // scanner per scelta piatto
        Scanner choisePlate = new Scanner(System.in);
        // scanner per scelte menu
        Scanner firstMenuObj = new Scanner(System.in);
        int firstMenuCondition = 0;
        // numero dei clienti
        int totClient = 0;
        // totale spese client
        double totBudgetClient = 0;
        // Badget casuale utente
        double budgetClient = 0;
        // password
        Scanner passwordObj = new Scanner(System.in);
        String password = "ciao";
        // array dati piatti
        // dati carne
        String firstName = "Carne Al Forno";
        int firstQuantity = 10;
        int firstPrice = 10;
        String[] firstArrayIngredients = { "patate", "Fassona", "olio", "alloro" };
        // dati carbonara
        String secondName = "Pasta Carbonara";
        int secondQuantity = 10;
        int secondPrice = 20;
        String[] secondArrayIngredients = { "Uova", "Guanciale", "Pecorino" };
        // dati caccio e pepe
        String thirdName = "Pasta Caccio e Pepe";
        int thirdQuantity = 10;
        int thirdPrice = 15;
        String[] thirdArrayIngredients = { "Pecorino", "Pepe" };
        // dati caccio e pepe
        String clientName = "";
        int clientQuantity = 0;
        int clientPrice = 0;
        String[] clientArrayIngredients = { "", "", "", "" };
        do {
            // accesso menu

            do {
                System.out.println("Vuoi entrare nel menu? 1 entrare , 2 uscire");
                firstMenuCondition = firstMenuObj.nextInt();
            } while (firstMenuCondition < 1 || firstMenuCondition >= 3);
            if (firstMenuCondition == 1) {
                int seconMenu = 0;
                do {
                    // Scelta del menu azioni

                    do {
                        System.out.println("Scegli se vuoi 1 Comprare, 2 Vedi, 3 Aggiungi, 4 Esci");
                        seconMenu = firstMenuObj.nextInt();
                    } while (seconMenu < 1 || seconMenu > 4);
                    // valorizzo il budget del client
                    budgetClient = Math.random() * 101;

                    switch (seconMenu) {
                        case 1:
                            // lista piatti
                            stampaPiatti(firstArrayIngredients, firstName, firstQuantity, firstPrice);
                            stampaPiatti(secondArrayIngredients, secondName, secondQuantity, secondPrice);
                            stampaPiatti(thirdArrayIngredients, thirdName, thirdQuantity, thirdPrice);
                            if (!clientName.equals("")) {
                                stampaPiatti(clientArrayIngredients, clientName, clientQuantity, clientPrice);
                            }
                            System.out.println("Inserire il nome del piatto scelto");
                            double carrello = 0;
                            boolean flagBuy = false;
                            switch (choisePlate.nextLine()) {
                                case "Carne Al Forno":
                                    // acquisto di un piatto
                                    if (firstQuantity > 0 && firstPrice <= budgetClient) {
                                        budgetClient = budgetClient - firstQuantity;
                                        carrello = firstPrice;
                                        System.out.println("Acquisto avvenuto con successo, ti rimagono ancora "
                                                + df.format(budgetClient) + " $");
                                        flagBuy = true;
                                    } else {
                                        System.out.println("Acquisto non possibile");
                                    }
                                    break;
                                case "Pasta Carbonara":
                                    if (secondQuantity > 0 && secondPrice <= budgetClient) {
                                        budgetClient = budgetClient - secondQuantity;
                                        carrello = secondPrice;
                                        System.out.println("Acquisto avvenuto con successo, ti rimagono ancora "
                                                + df.format(budgetClient) + " $");
                                        flagBuy = true;
                                    } else {
                                        System.out.println("Acquisto non possibile");
                                    }
                                    break;
                                case "Pasta Caccio e Pepe":
                                    if (thirdQuantity > 0 && thirdPrice <= budgetClient) {
                                        budgetClient = budgetClient - thirdQuantity;
                                        carrello = thirdPrice;
                                        System.out.println("Acquisto avvenuto con successo, ti rimagono ancora "
                                                + df.format(budgetClient) + " $");
                                        flagBuy = true;
                                    } else {
                                        System.out.println("Acquisto non possibile");
                                    }
                                    break;
                                default:
                                    System.out.println("Scelta non valida");
                                    flagBuy = false;
                                    break;
                            }
                            if (flagBuy) {
                                thirdQuantity -= 1;
                                totClient++;
                                totBudgetClient += carrello;
                            }
                            break;
                        case 2:
                            System.out.println("Il nostro menu");
                            stampaPiatti(firstArrayIngredients, firstName, firstQuantity, firstPrice);
                            stampaPiatti(secondArrayIngredients, secondName, secondQuantity, secondPrice);
                            stampaPiatti(thirdArrayIngredients, thirdName, thirdQuantity, thirdPrice);
                            if (!clientName.equals("")) {
                                stampaPiatti(clientArrayIngredients, clientName, clientQuantity, clientPrice);
                            }
                            break;
                        case 3:
                            System.out.println("Inserisci la password per continuare");
                            if (passwordObj.nextLine().toLowerCase().equals(password)) {

                                System.out.println("Vuoi  1 aggiungere un piatto o 2 resettare le quantita ");

                                switch (firstMenuObj.nextInt()) {
                                    case 1:
                                        String allIngredients = "";
                                        System.out.println("Inserisci il nome del piatto");
                                        clientName = newPlateStringObj.nextLine();
                                        System.out.println("Inserisci gli ingredienti");
                                        for (int index = 0; index < clientArrayIngredients.length; index++) {
                                            System.out.println("ingrediente " + (index + 1));
                                            clientArrayIngredients[index] = newPlateStringObj.nextLine();
                                            allIngredients += clientArrayIngredients[index] + ", ";
                                        }
                                        System.out.println("Inserisci la quantita di porzioni");
                                        clientQuantity = newPlateIntObj.nextInt();
                                        System.out.println("Inserisci il prezzo");
                                        clientPrice = newPlateIntObj.nextInt();

                                        System.out.println(
                                                "Il nome del piatto è " + clientName + ", costa: "
                                                        + Math.floor(clientPrice)
                                                        + ", rimangono: " + clientQuantity
                                                        + " porzioni, gli ingredienti sono");
                                        System.out.println(allIngredients);
                                        break;
                                    case 2:
                                        firstQuantity = 10;
                                        secondQuantity = 10;
                                        thirdQuantity = 10;
                                        System.out.println("reset avvenuto, ora tutte le quantità sono a 10");
                                        break;
                                    default:
                                        System.out.println("scelta non esistemte, tornerai al menu");
                                        break;
                                }
                            } else {
                                System.out.println("password errata");
                            }
                            break;
                        default:
                            System.out.println("scelta non valida");
                            break;
                    }
                } while (seconMenu != 4);
            } else {
                System.out.println(
                        "I clienti hanno speso " + df.format(totBudgetClient) + ", sono " + totClient + " clienti");
                System.out.println("sono uscito");
            }
        } while (firstMenuCondition == 1);
    }

    public static void stampaPiatti(String[] arrayIngredients, String name, int quantity, int price) {
        // stampa nomi piatti

        System.out.println(
                "Il nome del piatto è " + name + ", costa: " + Math.floor(price) + ", rimangono: " + quantity
                        + " porzioni");

        for (String string : arrayIngredients) {
            System.out.println(string + ", ");
        }
    }
}
