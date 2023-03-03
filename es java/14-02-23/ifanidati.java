import java.util.Scanner; // import the Scanner class

public class ifanidati {
    public static void main(String[] args) {
        Scanner anagrafica = new Scanner(System.in);
        System.out.println("Inserisci il tuo nome");
        String name = anagrafica.nextLine();

        System.out.println("Inserisci il tuo cognome");
        String surname = anagrafica.nextLine();

        Scanner eta = new Scanner(System.in);
        System.out.println("Inserisci la tua età");
        int age = eta.nextInt();
        if (age>=18) {
            System.out.println("Sei maggiorenne!!");
            System.out.println("Dove sei nato?");
            String where = anagrafica.nextLine();
            if (!where.equals("Sassari")){
                System.out.println("Registrazione avvenuta");
                System.out.println(name + " " + surname+ ", hai "+age);
            }else if(where.equals("Sorso")){
                System.out.println("non possiamo accettarti");
            }else{
                System.out.println("La registrazione non è andata a buon fine");
            }
        } else{
            System.out.println("i minnorenni non possono ");
        }
       
    }
}
