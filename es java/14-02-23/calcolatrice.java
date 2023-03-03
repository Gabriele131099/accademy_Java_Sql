import java.util.Scanner; // import the Scanner class
public class calcolatrice {
    public static void main(String[] args) {

        // ask operation
        Scanner operation = new Scanner(System.in);
        System.out.println("scegli un operazione, 0 Somma, 1 Moltiplicazione, 2 Sottrazione, 3 Divisione");
        int operationSelected = operation.nextInt();

        //condizioni stampa
        if (operationSelected==0) {
            System.out.println("Hai scelto Somma");
        } else  if (operationSelected == 1){
            System.out.println("Hai scelto Moltiplicazione");
        }else  if (operationSelected == 2){
            System.out.println("Hai scelto Sottrazione");
        }else  if (operationSelected == 3){
            System.out.println("Hai scelto Divisione");
        }else{
            System.out.println("scelta errata");
        }

       
        int num1 = askNumber("primo");
        int num2 = askNumber("secondo");
        

        if (operationSelected==0) {
            System.out.println("La somma è " + (num1+num2));
        } else  if (operationSelected == 1){
            System.out.println("La moltiplicazione è " + (num1*num2));
        }else  if (operationSelected == 2){
            System.out.println("La sottrazione è " + (num1-num2));
        }else  if (operationSelected == 3){
            System.out.println("La divisione è " + (num1/num2));
        }
    }
    static int askNumber(String args){
        Scanner numScan = new Scanner(System.in);
        System.out.println("Inserisci il "+args+" numero");
        int num = numScan.nextInt();
        return num;
    }
}
