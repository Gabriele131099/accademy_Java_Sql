import java.util.Scanner; // import the Scanner class

public class ripet {
    public static void main(String[] args) {
        
        Scanner myNumberUno = new Scanner(System.in);
        System.out.println("Inserisci il primo numero");
        double numA = myNumberUno.nextDouble();
        System.out.println("Numero: " + numA );
        System.out.print("il primo numero è pari?");
        System.out.println((numA%2)==0);
        // System.out.println((numA%2)==0? "si" : "no");

        Scanner myNumberDue = new Scanner(System.in);
        double numB = myNumberDue.nextDouble();
        while (numA<numB) {
            System.out.println("il valore è troppo piccolo, inserisci un altro numero");
             numB = myNumberDue.nextDouble();
        }
        System.out.println("Inserisci il secondo numero");
        System.out.println("Numero: " + numB);
        
        myNumberUno.close();
        myNumberDue.close();

        int result = (int)(numA/numB);
        System.out.println("result: " + result + ", con resto:" + numA%numB);


        String name = "filippo";
        String surname = "canu";
        System.out.println(name.concat(" " + surname));
        
    }
}