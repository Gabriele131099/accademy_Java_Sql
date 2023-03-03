
import java.util.Scanner; // import the Scanner class

public class es2 {
    public static void main(String[] args) {
        int i = 0;
        
        while (i<10) {
            System.out.println(i);
            i++;
        }

        boolean flag = i==10;
        while (flag) {
            System.out.println(i);
            i++;
            if (i==20) {
                flag=false;
            }
        }

        boolean flagBis;
        
        Scanner objText = new Scanner(System.in);
        System.out.println("Inserisci nome e cognome");
        String text = objText.nextLine();
        String[] result = text.split(" ");
        System.out.println(result[1] + " " + result[0]);
        
        int num ;

        Scanner obj = new Scanner(System.in);
       
        
        

        do  { 
            System.out.println("Entra nel ciclo?? 1 si, 2 no");
            int choise =obj.nextInt();
            flagBis = choise == 1;
            if (choise==2) {
                flagBis=false;
                break;
            }
            System.out.println("Scegli un numero da 1 a 10");
            num = obj.nextInt();
            while (num<0 || num>10) {
                System.out.println("Scegli un numero da 1 a 10");
            num = obj.nextInt();
            }

            if ((num%2) == 0) {
                num = num/2;
                System.out.println("Il numero è pari" + num);
            }else{
                num = num%2;
                System.out.println("Il numero è dispari, il resto è" + num);
            }
           
            System.out.println("Entra nel ciclo?? 1 si, 2 no");
            choise= obj.nextInt();
            
        }while(flagBis);
    }
}
