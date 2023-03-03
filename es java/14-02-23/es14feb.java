import java.util.Scanner; // import the Scanner class

public class es14feb {
    public static void main(String[] args) {

        // ask number
        Scanner myNumberClient = new Scanner(System.in);
        System.out.println("Inserisci un numero");
        int num = (int) myNumberClient.nextInt();
        System.out.println("Numero: " + num);

        // create random number
        double myNumberRandom = (double) Math.random() * 101;
        System.out.println("Il numero scelto dalla macchina è " + myNumberRandom);

        // richiamo le funzioni min e max value
        minVal(num, myNumberRandom);
        maxVal(num, myNumberRandom);
        // System.out.println(minValue);
        // System.out.println(maxValue);

        // operazioni varie
        int somma = (int) num + (int) myNumberRandom;
        System.out.println("somma: " + somma);

        int divisione = (int) num % (int) myNumberRandom;
        System.out.println("divisione: " + divisione);

        int molti = (int) num * (int) myNumberRandom;
        System.out.println("moltiplicazione: " + molti);

        // abs e sqrt
        System.out.println("abs di moltiplicazione: " + Math.abs(molti));
        System.out.println("sqrt di somma: " + Math.sqrt(somma));

        // //stringhe
        // String s1 = new String("Compare two strings in Java");
        // String s2 = new String("Compare two strings in Java");

        // // Restituisce true
        // System.out.println(StringUtils.equals(s1, s2));

        // // Restituisce true
        // System.out.println(StringUtils.compare(s1, s2) == 0);

        // if
        if (num != 18) {
            System.out.println("esatto");
        } else {
            System.out.println("errore");
        }
        if ("ciao".equals("ciao")) {
            System.out.println("esatto");
        } else {
            System.out.println("NON NE HAI PRESA UNA");
        }

        // if concatenati
        if (num != 18) {
            System.out.println("è diverso da 18");
        } else if (num == myNumberRandom) {
            System.out.println("sono uguali");
        } else {
            System.out.println("non sei un vegente");
        }

        // if incapsulate
        if (num != 18) {
            System.out.println("è diverso da 18");
            if (num == myNumberRandom) {
                System.out.println("sono uguali");
            }
        } else {
            System.out.println("non sei un vegente");
        }
    }

    static void minVal(int numClient, double numRan) {
        System.out.println("il numero più basso fra" + numClient + " e " + numRan + ", è " + Math.min(numClient, numRan));

    }

    static void maxVal(int numCli, double numRan) {
        System.out.println("il numero più alto fra" + numCli + " e " + numRan + ", è " + Math.max(numCli, numRan));
    }
}
