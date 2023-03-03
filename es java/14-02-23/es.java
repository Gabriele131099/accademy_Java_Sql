import java.util.Scanner; // import the Scanner class

public class es {
    public static void main(String[] args) {

        Scanner numClientScanner = new Scanner(System.in);
        System.out.println("inserisci un numero");
        int numClient = numClientScanner.nextInt();

        Scanner textClientScanner = new Scanner(System.in);
        System.out.println("inserisci un testo");
        String textClient = textClientScanner.nextLine();

        Scanner boolClientScanner = new Scanner(System.in);
        System.out.println("inserisci un boolean");
        boolean flagClient = boolClientScanner.nextBoolean();

        Scanner operation = new Scanner(System.in);
        System.out.println("Scegli 1 per Funzioni Matematiche, 2 per Funzioni Stringa, 3 per Casting");
        int operationSelected = operation.nextInt();

        switch (operationSelected) {
            case 1:
                // funzioni matematiche
                System.out.println("scegli un operazione, 0 Somma, 1 Moltiplicazione, 2 Sottrazione, 3 Divisione");
                Scanner matSelected = new Scanner(System.in);
                int selected = matSelected.nextInt();
                operationMatMethod(selected, numClient);
                System.out.println(Math.min(10, numClient)+ ", sono il valore minimo");
                System.out.println(Math.max(10, numClient) + ", sono il valore massimo");
                System.out.println(Math.abs(numClient) + ", sono un numero positivo");
                System.out.println(Math.sqrt((double)numClient)+ ", sono una radice quadratta");
                break;
            case 2:
                //subString e conc
                System.out.println(textClient + ", sono una concatenazione");
                System.out.println(textClient.substring(0,2)+ ", sono una sub stringa");
                break;
            case 3:
                // Casting
                System.out.println((double) numClient + ", sono diventato un double");
                System.out.println((float) numClient + ", sono un float");
                System.out.println(textClient.charAt(0) + ", sono una char della stringa");
                System.out.println(!flagClient + ", sono l'opposto di prima");
                break;

            default:
            System.out.println("Scelta errata");
                break;
        }
    }

    static void operationMatMethod(int choise, int num) {
        if (choise == 0) {
            System.out.println("La somma è " + (20 + num));
        } else if (choise == 1) {
            System.out.println("La moltiplicazione è " + (5 * num));
        } else if (choise == 2) {
            System.out.println("La sottrazione è " + (5 - num));
        } else if (choise == 3) {
            System.out.println("La divisione è " + (2 / num));
        }else{
            System.out.println("scelta errata");
        }
    }
}
