import java.util.Scanner; // import the Scanner class

public class switchCalc {
    public static void main(String[] args) {

        // ask operation
        Scanner operation = new Scanner(System.in);
        System.out.println("scegli un operazione, 0 calc, 1 cale, 2 conta");
        int num1;
        int num2;
        // condizioni stampa
        switch (operation.nextInt()) {
            case 0:
                System.out.println("scegli un operazione, 0 Somma, 1 Moltiplicazione, 2 Sottrazione, 3 Divisione");
                int operationSelected = operation.nextInt();
                switch (operationSelected) {
                    case 0:
                        System.out.println("Hai scelto Somma");
                        num1 = askNumber("primo");
                        num2 = askNumber("secondo");
                        System.out.println("La somma è " + (num1 + num2));
                        break;
                    case 1:
                        System.out.println("Hai scelto Moltiplicazione");
                        num1 = askNumber("primo");
                        num2 = askNumber("secondo");
                        System.out.println("La somma è " + (num1 + num2));

                        break;
                    case 2:
                        System.out.println("Hai scelto Divisione");
                        num1 = askNumber("primo");
                        num2 = askNumber("secondo");
                        System.out.println("La sottrazione è " + (num1 - num2));
                        break;
                    case 3:
                        System.out.println("Hai scelto Sottrazione");
                        num1 = askNumber("primo");
                        num2 = askNumber("secondo");
                        System.out.println("La divisione è " + (num1 / num2));
                        break;
                    default:
                        break;
                }

                break;
            case 1:
                System.out.println("Scegli un giorno");
                int operationSelectedCalendar = operation.nextInt();
                switch (operationSelectedCalendar) {
                    case 0:
                        System.out.println("Lunedi");
                        break;
                    case 1:
                        System.out.println("Marte");
                        break;
                    case 2:
                        System.out.println("Merco");
                        break;
                    case 3:
                        System.out.println("Giove");
                        break;
                    case 4:
                        System.out.println("Vene");
                        break;
                    case 5:
                        System.out.println("Sab");
                        break;
                    case 6:
                        System.out.println("Dom");
                        break;
                    default:
                        break;
                }
                break;
            case 2 :
            Scanner choiseObj = new Scanner (System.in);
            Scanner numClientObj = new Scanner (System.in);
            Scanner stringClientObj = new Scanner (System.in);
            int choise = 0;
            
            do {
                System.out.println("inizia la conta? 1 si, 2 no");
                 choise = choiseObj.nextInt();
                 System.out.println("Vuoi numeri o lettere? 1 num, 2 string");
                 int newChoise = choiseObj.nextInt();
                  
                
                 switch (newChoise) {
                    case 1:
                    System.out.println("Dammi un numero");
                    int numClient = numClientObj.nextInt();
                    for (int i = 0; i < numClient; i++) {
                        System.out.println("i " + i);
                    } 
                    System.out.println("Stampa finita");
                    break;
                    case 2:
                    System.out.println("Dammi una striga");
                    String stringClient  =stringClientObj.nextLine();
                    for (int i = 0; i < stringClient.length(); i++) {
                        System.out.println(stringClient.split("")[i]);
                    } 
                    System.out.println("Stampa finita");
                        break;
                    default:
                    System.out.println("conta annullata");
                        break;
                 }
               
            } while (choise==1);
            
            break;
            default:
                break;
        }
    }
    static int askNumber(String args) {
        Scanner numScan = new Scanner(System.in);
        System.out.println("Inserisci il " + args + " numero");
        int num = numScan.nextInt();
        return num;
    }
}
