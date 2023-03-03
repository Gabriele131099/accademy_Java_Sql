package Gabriele_Sanna_test;

import java.util.ArrayList;
import java.util.Scanner;

// CODE RULES: Andare a creare un bool di controllo per ogni ciclo tranne i for ,,
//  Per ogni livello di profondità dei menu aggiungo una condizione , 
//  NON si usano siwtch sotto i 4 casi + def
public class Main {
    public static void main(String[] args) {
        // Scanner
        Scanner nScan = new Scanner(System.in);
        Scanner sScan = new Scanner(System.in);
        //array user
        ArrayList<User> arrayUsers = new ArrayList<User>(); 
        User userAdmin = new User("a", "1234567",true);
        arrayUsers.add(userAdmin);
        // array dei libri
        ArrayList<Libro> arrayLibro = new ArrayList<>();
        System.out.println("Quanti libri vuoi creare?");
        int nLibriCreate = nScan.nextInt();
        for (int i = 0; i < nLibriCreate; i++) {
            System.out.println("aggiungi libro");
            System.err.println("nome");
            String nome = sScan.nextLine();
            System.out.println("quantità");
            int quantity = nScan.nextInt();
            Libro libro = new Libro(nome, quantity);
            arrayLibro.add(libro);
        }
        // biblioteca
        Biblioteca biblioteca = new Biblioteca("La Libreria", arrayLibro);

        System.out.println("Salve utente");
        Boolean flagAvvioProgramma = false;
        String currentUser = "";
        do {
            System.out.println("Vuoi avviare il programma? 0 o 1");
            flagAvvioProgramma = nScan.nextInt() == 0;
            boolean flagLogIn = false;
            if (flagAvvioProgramma) {
                System.out.println("Accedi con un utente o iscriviti 0 o 1");
                int choiseUser = nScan.nextInt();
                Boolean flagEnterInLogIn = choiseUser==0 || choiseUser==1;
                boolean flagLogInChoise = choiseUser==0;
                if (flagEnterInLogIn) {
                     choiseUser = 0;
                
                        if (flagLogInChoise) {
                            System.out.println("LogIn");
                            boolean userExists = false;
                            do {
                                String nomeTmp;
                                String passTmp;
                                System.out.println("Inserisci il tuo username");
                                nomeTmp = sScan.nextLine();

                                userExists= checkUserExist(arrayUsers,nomeTmp);
                                if (userExists) {
                             
                                    boolean correctPass = false;
                                    do {
                                        System.out.println("Inserisci la tua password");
                                        passTmp = sScan.nextLine();
                                        for (int i = 0; i < arrayUsers.size(); i++) {
                                            if (arrayUsers.get(i).getNome().equals(nomeTmp)
                                                    && arrayUsers.get(i).checkPass(passTmp)) {
                                                System.out.println("password corretta");
                                                currentUser = arrayUsers.get(i).getId();
                                                System.out.println("Hai effetutato l'accesso con l'account "
                                                        + arrayUsers.get(i).nome);
                                                correctPass = true;
                                                flagLogIn = true;
                                                arrayUsers.get(i).logIn();
                                                currentUser = arrayUsers.get(i).getNome();
                                                flagEnterInLogIn = false;
                                            }
                                        }
                                    } while (!correctPass);
                                    System.out.println(currentUser + " id utente loggato");
                                  
                                } else {
                                    System.out.println(nomeTmp + " l'username non esiste");
                                   
                                }
                            }while(!flagLogIn);
                        }
                        //sign
                        System.out.println("registrazione");
                      
                        System.out.println(!flagLogInChoise);
                        if (!flagLogInChoise) {
                            System.out.println("Registrati");
                            boolean flagUsernameExist = true;
                            String nomeTmp;
                            do {
                            System.out.println("INSERISCI NOME");
                            nomeTmp = sScan.nextLine();
                            for (int i = 0; i < arrayUsers.size(); i++) {
                                if (arrayUsers.get(i).getNome().equals(nomeTmp)) {
                                    System.out.println("Username presente nel sistema");
                                    flagUsernameExist = false;
                                }
                            }
                            } while (!flagUsernameExist);

                            System.out.println("INSERISCI PASSWORD");
                            String passwordTmp = sScan.nextLine();
                            User user = new User(nomeTmp,passwordTmp);
                            arrayUsers.add(user);
                            flagEnterInLogIn = false;
                        }
                    } while (flagEnterInLogIn);
                }
                Boolean flagEnterMenu = false;
                System.out.println(flagLogIn);
                if (flagLogIn) {
                    do {
                        System.out.println(
                                "Vuoi noleggiare un Libro 0, restituire un Libro 1, aggiungere un Libro2, rimuovere un libro 3, 4 esci?");
                        int choiseAction = nScan.nextInt();
                        flagEnterMenu = choiseAction < 4 && choiseAction >= 0;
                        if (flagEnterMenu) {
                            switch (choiseAction) {
                                case 0:
                                    biblioteca.stampaLibriDisponibili();
                                    System.out.println("Scegli il libro per il noleggio");
                                    int noleggioChoise = nScan.nextInt();
                                    Boolean flagChoiseBookNole = noleggioChoise<=arrayLibro.size();
                                    if (flagChoiseBookNole) {
                                        biblioteca.prestaLibro(arrayLibro.get(noleggioChoise).getUid());
                                    } else {
                                        System.out.println("Sei andato oltre il range");
                                    }
                                    break;
                                case 1:
                                    System.out.println("che libro hai noleggiato?");
                                    biblioteca.stampaLibriDisponibili();
                                    System.out.println("Scegli il libro per il noleggio");
                                    int noleggioRestituitoChoise = nScan.nextInt();
                                    Boolean flagChoiseBookReturn = noleggioRestituitoChoise<=arrayLibro.size();
                                    if (flagChoiseBookReturn) {
                                        biblioteca.restituisciLibro(arrayLibro.get(noleggioRestituitoChoise).getUid());
                                    }else{
                                         System.out.println("Sei andato oltre il range");
                                    }
                                    break;
                                case 2:
                                    System.out.println("Aggiungi un libro");
    
                                    System.err.println("nome");
                                    String nome = sScan.nextLine();
                                    System.out.println("quantità");
                                    int quantity = nScan.nextInt();
                                    biblioteca.aggiungiLibro(nome, quantity);
                                    break;
                                case 3:
                                    System.out.println("Rimuovi un libro");
                                    biblioteca.stampaLibriDisponibili();
                                    System.out.println("Scegli il libro per il noleggio");
                                    int removeChoise = nScan.nextInt();
                                    Boolean flagChoiseBookRemove = removeChoise<=arrayLibro.size();
                                    if (flagChoiseBookRemove) {
                                        biblioteca.rimuoviLibro(arrayLibro.get(removeChoise).getUid());
                                    }else{
                                        System.out.println("Sei andato oltre il range");
                                    }
                                    break;
                                case 4:
                                    System.out.println("Vuoi rimuovi tutti i libri?0 o 1");
                                    Boolean flagRemoveAllBooks = nScan.nextInt() == 0;
                                    if (flagRemoveAllBooks) {
                                        biblioteca.rimuoviLibri();
                                    } else {
                                        System.out.println("Scelta annullata");
                                    }
                                    break;
                                default:
                                    break;
                            }
    
                        }
                    } while (flagEnterMenu);
                    Boolean flagAdminEnter = false;
                    if (userAdmin.getAdmin() && currentUser.equals(userAdmin.getNome())) {
                        
                        System.out.println("Vuoi modifcare un utente? 0 o 1");
                        int choiseActioAdmin = nScan.nextInt();
                        flagAdminEnter = choiseActioAdmin==0;

                        System.out.println("Vuoi modificare o eliminare un user? 0 o 1");
                        int choiseActionMood = nScan.nextInt();
                        if (choiseActionMood==0) {
                            System.out.println("Modifica");
                            for (int i = 0; i < arrayUsers.size(); i++) {
                                arrayUsers.get(i).stampa(i);
                            }
                            System.out.println("Scegli un utente");
                            int nUser = nScan.nextInt();
                            arrayUsers.get(nUser).stampa(nUser);
                            Boolean flagExistUser = false;
                            do {
                                System.out.println("Inserisci ilnuovo nome");
                            String nome= sScan.nextLine();
                            flagExistUser = checkUserExist(arrayUsers,nome);
                            if (!flagExistUser) {
                                arrayUsers.get(nUser).setNome(nome);
                                System.out.println("Nome modificato");
                            }else{
                                System.out.println("Nome gia presente");
                            }
                            } while (!flagExistUser);
                        }
                        if (choiseActionMood==1) {
                            System.out.println("Elimina l'utente");
                            for (int i = 0; i < arrayUsers.size(); i++) {
                                arrayUsers.get(i).stampa(i);
                            }
                            int nUser = nScan.nextInt();
                            arrayUsers.remove(nUser);
                            System.out.println("user eliminato");
                        }

                    }
                }

            
        } while (flagAvvioProgramma);
    }
    public static boolean checkUserExist(ArrayList<User> arrayUsers,String nome){
        boolean userExists = false;
        for (int i = 0; i < arrayUsers.size(); i++) {
            if (arrayUsers.get(i).nome.equals(nome)) {
                System.out.println(nome + " è presente");
                userExists = true;
            }
        }
        return userExists;
       }
}
