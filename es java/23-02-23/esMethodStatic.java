import java.util.Scanner;

public class esMethodStatic {
    static boolean flag = false;
    public static void main(String[] args) {
        // int, duoble, string, bool
        // e far sin che in base alla scelta in input stampi
        // col METODO TIPIZZATO GIUSTO
        
        Scanner nScan = new Scanner(System.in);
        int choiseMenu = 0;
       
       do {
        System.out.println("Scegli un opzione, 0 int, 1 double, 2 string, 3 bool, 4 exit");
        choiseMenu = nScan.nextInt();
        switch (choiseMenu) {
            case 0:
                // int
               System.out.println( myInt(1, 1));
                break;
            case 1:
                // double
                System.out.println(myDouble(3, 2));
                break;
            case 2:
                // string
                System.out.println(myString("ciao"));
                break;
            case 3:
                // bool non static method
                esMethodStatic s = new esMethodStatic();
                s.myBool(); //true
                System.out.println(esMethodStatic.flag); //false
                break;
            default:
                break;
        }
       } while (choiseMenu<4 && choiseMenu>=0);
    }

    static int myInt(int a, int b) {
        return a + b;
    }

    static double myDouble(int a, int b) {
        return (a + b) / 3;
    }

    static String myString(String s) {
        return s.charAt(3) + " " + s.charAt(1);
    }

     void myBool() {
        System.out.println(!flag);
    }
}
