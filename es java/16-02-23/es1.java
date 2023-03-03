
import java.util.*; // import the Scanner class

public class es1 {
    public static void main(String[] args) {
        Scanner choiseMenu = new Scanner(System.in);
        int choise = 0;
      
        int password = 123456789;

        // dati carne
        String firstName = "Carne Al Forno";
        int firstQuantity = 5;
        int firstPrice = 10;
        String[] firstArrayIngredients = { "patate", "Fassona", "olio", "alloro" };
        // dati Pasta
        String secondName = "Pasta Carbonara";
        int secondQuantity = 9;
        int secondPrice = 20;
        String[] secondArrayIngredients = { "Uova", "Guanciale", "Pecorino" };
        // dati Formaggio
        String thirdName = "Pasta Caccio e Pepe";
        int thirdQuantity = 7;
        int thirdPrice = 15;
        String[] thirdArrayIngredients = { "Pecorino", "Pepe" };
        do {
            System.out.println("Scegli un piatto fra, Carne 1, Pasta 2, Formaggio 3. 0 chiudi");
            choise = choiseMenu.nextInt();
            switch (choise) {
                case 1:
               showChoise(firstName, firstQuantity, firstArrayIngredients);
                    // ordina
                    System.out.println("Vuoi ordinare il piatto? 1 ordina, 2 indietro,3 modifica");
                    firstArrayIngredients = choiseMenuMethod(choiseMenu.nextInt(),firstQuantity,firstPrice,password,firstArrayIngredients);
                    break;
                    case 2:
                    showChoise(secondName, secondQuantity, secondArrayIngredients);
                    // ordina
                    System.out.println("Vuoi ordinare il piatto? 1 ordina, 2 indietro,3 modifica");
                    firstArrayIngredients = choiseMenuMethod(choiseMenu.nextInt(),secondQuantity,secondPrice,password,secondArrayIngredients);
                    break;
                    case 3:
                    showChoise(thirdName, thirdQuantity, thirdArrayIngredients);
                    // ordina
                    System.out.println("Vuoi ordinare il piatto? 1 ordina, 2 indietro,3 modifica");
                    firstArrayIngredients = choiseMenuMethod(choiseMenu.nextInt(),thirdQuantity,thirdPrice,password,thirdArrayIngredients);
                    break;

                default:
                    break;
            }
        } while (choise > 0 && choise < 4);
    }

    private static void showChoise(String name, int quantity, String[] array) {
        System.out.println("Hai scelto la " + name);
        System.out.println("Sono disponibili  " + quantity);
        System.out.println("Il piatto è composto da ");
        int i = 0;
        while (i < array.length) {
            System.out.print(array[i] + " ,");
            i++;
        }
        System.out.println("");
    }

    private static String[] choiseMenuMethod(int choise,int quantity,int price, int password, String[ ] array) {
        Scanner passwordObj = new Scanner(System.in);
        Scanner modifyObjScanner = new Scanner(System.in);

        switch (choise) {
            case 1:
                if (quantity > 0) {
                    quantity -= 1;
                    System.out.println("Piatto ordinato");
                } else {
                    System.out.println("Son finite le porzioni");
                    break;
                }
                break;
            case 2:
                System.out.println("Torno alla scelta menu");
                break;
            case 3:
                System.out.println("Inserisci la password per modificare i dati del piatto");
                if (password == passwordObj.nextInt()) {
                    System.out.println("Modifica il prezzo di "+price);
                    price = passwordObj.nextInt();
                    System.out.println("Modifica gli ingredienti 1  o aggiungi 2");
                    
                    switch (passwordObj.nextInt()) {
                        case 1:
                        int i = 0;
                        while (i<array.length) {
                            System.out.println("Modifica " + array[i]);
                            array[i] = modifyObjScanner.nextLine();
                            i++;
                        }
                        int f = 0;
                        while (i<array.length) {
                            System.out.println( array[i]);
                           
                         f ++;
                        }
                            break;
                        case 2 :
                        System.out.println("Aggiungi un ingrediente");
                            // array. = modifyObjScanner.nextLine();
                        break;
                        default:
                            break;
                    }
                   
                }
                break;
            default:
                break;
        }
        return array;
     

    }
}
