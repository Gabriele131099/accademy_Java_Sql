import java.util.*; // import the Scanner class

public class es2 {
    public static void main(String[] args) {
        Scanner choiseObj = new Scanner (System.in);
        // Scanner numClientObj = new Scanner (System.in);
        Scanner stringClientObj = new Scanner (System.in);
        int choise = 0;
        
        do {
            System.out.println("inizia la conta? 1 si, 2 no");
             choise = choiseObj.nextInt();
             System.out.println("Dammi una stringa");
            //  int numClient = numClientObj.nextInt();
             String stringClient  =stringClientObj.nextLine();
             
            if (choise==1) {
                for (int i = 0; i < stringClient.length(); i++) {
                    System.out.println(stringClient.split("")[i]);
                } 
                System.out.println("Stampa finita");
            }else{
                System.out.println("conta annullata");
                break;
            }
           
        } while (choise==1);
        
    }
}
