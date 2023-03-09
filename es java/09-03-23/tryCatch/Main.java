package tryCatch;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner nScan = new Scanner(System.in);
        Calcolatrice calc = new Calcolatrice(0, 0);
        ArrayList<Integer> arrayValori = new ArrayList<Integer>();
        try {

            int choise = 0;
            Boolean flagChoise = choise <= 4 && choise >= 0;

            do {
                System.out.println("1 Somma, 2 Divisione, 3 Moltiplicazione, 4 sottrazione, 5 Esci");
                choise = checkNumber();
                if (flagChoise) {
                    System.out.println("SCEGLI I DUE NUMERI");
                    int num1 = checkNumber();
                    int num2 = checkNumber();
                    System.out.println("Numeri inseriti");
                    calc.setNum1(num1);
                    calc.setNum2(num2);
                }
                switch (choise) {
                    case 1:
                        calc.setTot(calc.somma());
                        break;
                    case 2:
                        calc.setTot(calc.divisione());
                        break;
                    case 3:
                        calc.setTot(calc.moltiplicazione());
                        ;
                        break;
                    case 4:
                        if (calc.getNum1() >= calc.getNum2()) {
                            calc.setTot(calc.sottrazione());
                        } else {
                            System.out.println("Il primo numero è minore del secondo");
                        }
                        break;

                    default:
                        break;
                }
                System.out.println("Il risultato dell operazione è: ");
                System.out.println(calc.getTot());
                arrayValori.add((int) calc.getTot());
                System.out.println("Tutti irisultati ottenuti");
                for (Integer double1 : arrayValori) {
                    System.out.println(double1.toString());
                }
            } while (flagChoise);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            System.out.println("Fuori");
        }

    }

    public static int checkNumber() {
        Scanner nScan = new Scanner(System.in);
        int num = 0;
        boolean flagCheck = true;

            do {
                try {
                    System.out.println("Inserisci un numero");
                    num = nScan.nextInt();
                    flagCheck = false;
                } catch (Exception e) {
                    flagCheck = true;  
                    num = 0;              
                    System.out.println("Il carattere inserito ha valore "+0);
                    continue;
                }
               
            } while (!flagCheck);

            return num;
        
       
    }    
}
