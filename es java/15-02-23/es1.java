import java.util.Scanner; // import the Scanner class

public class es1 {
    public static void main(String[] args) {
        Scanner newObj = new Scanner(System.in);
        System.out.println("Preferisci che i numeri siano casuali? 1 si, 2 no");

        int randomNumbers = newObj.nextInt(); 
        int num1 = 0;
        int num2 = 0;
        if (randomNumbers==1) {//bonus
             num1 = (int) (Math.random()*101);
             num2 = (int) (Math.random()*101);
             System.out.println("num1 "+ num1);
             System.out.println("num2 "+ num2);
        } // bonus

        System.out.println(
                "Scegli un operazione, 0 somma, 1 somma di radici, 2 somma delle radici con valore più piccolo e più grande");
        int choise = newObj.nextInt();
        while (choise > 2 || choise < 0) {
            System.out.println("Numero non idoneo, riprova");
            choise = newObj.nextInt();
        }

        if (randomNumbers!=1) {
            System.out.println("scegli due numeri per le operazioni");
             num1 = newObj.nextInt();
             num2 = newObj.nextInt();
        }

        double somma ;
        switch (choise) {
            case 0:
                // somma
                somma = num1+num2;
                System.out.println("Sono la somma, "+num1+" + "+num2+" = "+somma);
                checkValue(somma);
                break;
            case 1:
                // somma di radici
                somma = Math.sqrt(num1) + Math.sqrt(num1);
                System.out.println("Sono la somma di radici, "+Math.sqrt(num1) +" + "+Math.sqrt(num2) +" = "+somma);
                checkValue(somma);
                break;
            case 2:
                // somma delle radici con valore più piccolo e più grande2
                if (num1>num2) {
                    somma = num1-Math.sqrt(num2);
                    System.out.println("Sono la sottrazione, "+num1 +" - "+Math.sqrt(num2) +" = "+(somma));
                    
                } else {
                    somma = num2-Math.sqrt(num1);
                    System.out.println("Sono la sottrazione, "+Math.sqrt(num1) +" - "+num2 +" = "+(somma));
                }
                checkValue(somma);
                break;

            default:
            System.out.println("errore");
                break;
        }
        
    }
    static void checkValue(double num){
        //positivo e negativo
        if (num>=0) {
            System.out.println("La somma risulta positiva, " + num);
        }else{
            System.out.println("La somma risulta negativa, " + num);
        }
       
        //intero o decimale
        if (num == (int)num) {
            System.out.println("è un intero");
           
        } else {
            System.out.println("Non è un intero");
        }

        //pari dispari e rimmozione decimale
        if ((num%2)==0) {
            System.out.println("Il numero è pari");
        }else{
            num -= (int)num;
            System.out.println("Il numero non è Pari, sono il decimale rimosso, "+num);
        }
    }

}
