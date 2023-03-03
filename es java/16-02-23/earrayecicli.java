import java.util.*; // import the Scanner class

public class earrayecicli {
    public static void main(String[] args) {
        Scanner macchinaObj = new Scanner (System.in);
       
        String[] arrayString = {"Volvo","Fiat","Mercedes","Alfa Romeo"};  
        int[] arrayPower = {1000,2000,3000,2200};
        boolean[] arrayBool = {true,false,true,false};

        System.out.println("Dammi il nome di una macchina");
        String nomeAuto = macchinaObj.nextLine();
        boolean flag = false;
        int j=0;
        for (int i = 0; i < arrayString.length; i++) {
            if ((arrayString[i].toLowerCase()).equals(nomeAuto.toLowerCase())) {
                flag = true;
                j++;
            }else{
                flag = false;
            }
            System.out.println("La marca è: "+arrayString[i] + ", Potenza: " +arrayPower[i]+(flag?"SONO QUA":""));
        }
        System.out.println(j==0?"Non Ho trovato niente":"");
        for (boolean b : arrayBool) {
            System.out.println("Booleano: "+b);
        }
    }
}
