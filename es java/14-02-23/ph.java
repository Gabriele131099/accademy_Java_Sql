import java.util.Scanner; // import the Scanner class

class ph {
    public static void main(String[] args) {

        Scanner myObj = new Scanner(System.in);
        System.out.println("Inserisci una Stringa");
        String a = myObj.nextLine();
        System.out.println("String: " + a);
         System.out.println("String convertita in char: " + (char)a.charAt(0));
         char b = 'a';
        // System.out.println("char convertita in String: " + ((String)b));
        // myObj.close();

        Scanner myNumber = new Scanner(System.in);
        System.out.println("Inserisci un numero");
        int num = myNumber.nextInt();
        System.out.println("Numero: " + num);
        System.out.println("Int convertita in double: " + (double)num);
        System.out.println("Int convertita in float: " + (float)num);
        // myNumber.close();

        boolean flag = false;
        Scanner myBool = new Scanner(System.in);
        System.out.println("booleano ");
        flag = myBool.nextBoolean();
        System.out.println("bool: " + flag);
        // myBool.close();

       
    }
}