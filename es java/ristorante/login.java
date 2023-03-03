package ristorante;

import java.util.ArrayList;
import java.util.Scanner;

public class login {
    public static ArrayList<User> main(ArrayList<User> arrayUsers) {
        // scanner
        Scanner sScan = new Scanner(System.in); // stringhe
        Scanner nScan = new Scanner(System.in); // numeri
        String passwordAdmin="131099";
        // user
       
        User user = new User("user1", "password",true);
        arrayUsers.add(user);
        // variabili tmp
        String nomeTmp = "";
        String passTmp;
        String currentUser = "";
      
        
        // condizione login
       
                boolean flagLogIn = false;
                do {
                    System.out.println("Hai gia un account? 1 si 2 no 3 esci");
                    int logIn = nScan.nextInt();
                    flagLogIn = logIn == 1 || logIn == 2;
                    switch (logIn) {
                        //logIn
                        case 1:
                            System.out.println("LogIn");
                            boolean userExists = false;
                            do {
                                System.out.println("Inserisci il tuo username");
                                nomeTmp = sScan.nextLine();

                                userExists= checkUserExist(arrayUsers,nomeTmp);
                                if (userExists) {
                                    boolean correctPass = false;
                                    do {
                                        System.out.println("Inserisci la tua password");
                                        passTmp = sScan.nextLine();
                                        for (int i = 0; i < arrayUsers.size(); i++) {
                                            if (arrayUsers.get(i).nome.equals(nomeTmp)
                                                    && arrayUsers.get(i).checkPass(passTmp)) {
                                                System.out.println("password corretta");
                                                currentUser = arrayUsers.get(i).getId();
                                                System.out.println("Hai effetutato l'accesso con l'account "
                                                        + arrayUsers.get(i).nome);
                                                correctPass = true;
                                                flagLogIn = false;
                                                arrayUsers.get(i).logIn();
                                            }
                                        }
                                    } while (!correctPass);
                                } else {
                                    System.out.println(nomeTmp + " l'username non esiste");
                                }
                                System.out.println(currentUser + " id utente loggato");
                            } while (!userExists);
                            break;
                        case 2:
                            System.out.println("SignIn");
                            Boolean userExist = false;
                            System.out.println("Inserisci il tuo username");
                            nomeTmp = sScan.nextLine();
                            userExist = checkUserExist(arrayUsers, nomeTmp);
                            if (!userExist) {
                                System.out.println("Inserisci la tua password");
                                passTmp = sScan.nextLine();
                                User userRegistrazione = new User(nomeTmp, passTmp,passTmp.equals(passwordAdmin));
                                arrayUsers.add(userRegistrazione);
                                userRegistrazione.stampa();
                                System.out.println("Registrazione avvenuta");
                            }
                            break;
                        default:
                            break;
                    }
                } while (flagLogIn);

                
           
    return arrayUsers;
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
