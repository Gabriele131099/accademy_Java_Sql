import java.util.*; // import the Scanner class
import java.time.*;

public class es3 {
    public static void main(String[] args) {
        // Scanner per password tmp
        Scanner passObj = new Scanner(System.in);
        //Scanner anagrafiche string
        Scanner anagrafica = new Scanner(System.in);
        //scanner anagrafiche int
        Scanner obj = new Scanner(System.in);
        //flag per cicli while
        boolean flagBis = false;
        //nome user
        String nome = "";
        //dati data di nascita
        int aa;
        int mm;
        int gg;
        //password
        String password = "";
        do {
            //entra o ese dal ciclo e controlli
            System.out.println("Entra nel ciclo Anagrafiche?? 1 si, 2 no");
            int choise = obj.nextInt();
            flagBis = choise == 1;
            if (choise != 1) {
                flagBis = false;
                break;
            }
            if (nome != "") {
                //utente gia registrato, modifica dati
                System.out.println("Esiste già una registrazione, vuoi modificarla? 1 si, 2 no");
                choise = obj.nextInt();
                if (choise == 2) {
                    break;
                }
                //inserimento password
                System.out.println("Inserisci la password per modificare i tuoi dati");
                String tmp = passObj.nextLine();
                if (password.equals((String) tmp)) {
                    //modifica dati
                    System.out.println("Password corretta");
                    System.out.println("Inserisci il tuo nome e cognome");
                    nome = anagrafica.nextLine();
                    System.out.println("Inserisci la tua data di nascita");
                    System.out.println("anno");
                    aa = obj.nextInt();
                    System.out.println("mese");
                    mm = obj.nextInt();
                    System.out.println("giorno");
                    gg = obj.nextInt();
                } else {
                    System.out.println("password non corrispondente, arrivederci");
                    break;
                }
            } else {
                //nuovo utente
                System.out.println("Inserisci il tuo nome e cognome");
                nome = anagrafica.nextLine();
                System.out.println("Inserisci la tua data di nascita");
                System.out.println("anno");
                aa = obj.nextInt();
                System.out.println("mese");
                mm = obj.nextInt();
                System.out.println("giorno");
                gg = obj.nextInt();
                System.out.println("Inserisci una password ");
                password = passObj.nextLine();
            }
            //anni dell utente
            LocalDate dob = LocalDate.of(aa, mm, gg); //data user
            LocalDate curDate = LocalDate.now(); //data attuale
            Period period = Period.between(dob, curDate); // sottrazione fra le due date
            // stampa anni user
            System.out.printf("La tua età è %d Anni %d Mesi e %d Giorni.", period.getYears(), period.getMonths(),
                    period.getDays());
            System.out.println("");
        } while (flagBis);
    }

}
