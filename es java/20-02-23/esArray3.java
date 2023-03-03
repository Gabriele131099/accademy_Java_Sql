import java.util.*; // import the Scanner class
import java.util.ArrayList;
import java.util.Arrays;

public class esArray3 {
    public static void main(String[] args) {
        Scanner counter = new Scanner(System.in);

        Scanner lettere = new Scanner(System.in);

        Integer arrNum[] = { 1, 2, 3, 4, 5, 6 };
        ArrayList<Integer> arrayListNum = new ArrayList<Integer>(Arrays.asList(arrNum));

        String arrString[] = { "ciao", "arrivederci", "buongiorno", "addio" };
        ArrayList<String> arrayListString = new ArrayList<String>(Arrays.asList(arrString));
        
        int count = 0;
        do {
            System.out.println("Che array vuoi vedere? 0 num, 1 string, 2 esci");
            count = counter.nextInt();
            switch (count) {
                case 0:
                    arrNum = arrayListNum.toArray(arrNum);
                    System.out.println("Array Numeri: " + Arrays.toString(arrNum));

                    arrString = arrayListString.toArray(arrString);
                    System.out.println("Array Stringhe: " + Arrays.toString(arrString));
                    break;
                case 1:
                    arrString = arrayListString.toArray(arrString);
                    System.out.println("Array Stringhe: " + Arrays.toString(arrString));

                    arrNum = arrayListNum.toArray(arrNum);
                    System.out.println("Array Numeri: " + Arrays.toString(arrNum));
                    break;
                default:
                    break;
            }
            if (count<2) {
                System.out.println("A quale array vuoi aggiungere? 0 num, 1 string, 2 esci");
                count = counter.nextInt();  
            }
            switch (count) {
                case 0:
                    System.out.println("aggiunta di un Intero");
                    Integer intNum = counter.nextInt();
                    arrayListNum.add(intNum);

                    arrNum = arrayListNum.toArray(arrNum);
                    System.out.println("Array Numeri: " + Arrays.toString(arrNum));
                    break;
                case 1:
                    System.out.println("aggiunta di una Stringa");
                    arrayListString.add(lettere.nextLine());

                    arrString = arrayListString.toArray(arrString);
                    System.out.println("Array Stringhe: " + Arrays.toString(arrString));
                    break;
                default:
                    break;
            }
        } while (count <2);
        counter.close();
        lettere.close();

    }

}
