package es_ristorante;

import java.util.ArrayList;
import java.util.Scanner;

public class esClassiresturant {
    public static void main(String[] args) {
        Scanner nScan = new Scanner(System.in);
        Scanner sScan = new Scanner(System.in);
        int choise=0;
        ArrayList<user> arrayUsers = new ArrayList();
        ArrayList<user> arrayUsersTmp = new ArrayList();
        do {
            System.out.println("vuoi inserire un utente o modificarne uno o elimina o inserisci? 0 e 1 e 2");
            choise = nScan.nextInt();
            if (choise==0) {
                System.out.println("nome utente");
                String nomeTmp = sScan.nextLine();
                System.out.println("Inserisci la password");
                String passwordTmp= sScan.nextLine();
                System.out.println("Sai già il tuo ruolo");
                String ruolo = sScan.nextLine();
                user user = new user(nomeTmp, passwordTmp, ruolo);
                arrayUsers.add(user);
                user.stampa();
            }
            if (choise==1) {
                System.out.println("seleziona un utente");
                for (int i = 0; i < arrayUsers.size(); i++) {
                    if (arrayUsers.get(i).ruolo!= "chef capo") {
                        System.out.println(i);
                        arrayUsers.get(i).stampa();
                    }
                   
                }
                int choiseUser = nScan.nextInt();
                System.out.println("hai scelto l'utente");
                arrayUsers.get(choiseUser).stampa();
                System.out.println("Inserisci la password");
                if (sScan.nextLine().equals(arrayUsers.get(choiseUser).password)) {
                    System.out.println("Password corretta");
                    String ruoloTmp = "unsigned";
                    do {
                        System.out.println("Inserisci il nuovo ruolo");
                         ruoloTmp = sScan.nextLine();
                        if (arrayUsers.get(choiseUser).assignedRuolo(ruoloTmp).equals("unsigned")) {
                            System.out.println("RUOLO NON ESISTENTE");
                        }else{
                            System.out.println("ruolo assegnato");
                            arrayUsers.get(choiseUser).stampa();
                        }
                    } while (arrayUsers.get(choiseUser).Cosasei().equals("unsigned"));
                }
            }
            if (choise==2) {
                System.out.println("Elimina un user");
                for (int i = 0; i < arrayUsers.size(); i++) {
                    if (arrayUsers.get(i).Cosasei()!= "chef capo") {
                        System.out.println(i);
                        arrayUsers.get(i).stampa();
                    }
                }
                int choiseUser = nScan.nextInt();
                System.out.println("hai scelto l'utente");
                arrayUsers.get(choiseUser).stampa();
                System.out.println("Inserisci la password");
                if (sScan.nextLine().equals(arrayUsers.get(choiseUser).password)) {
                    System.out.println("Password corretta");
                    arrayUsers.remove(choiseUser);
                    System.out.println("eliminato");
                }else{
                    System.out.println("password errata");
                }
            }
            if (choise>2 || choise<0) {
                System.out.println("arrivederci");
            }
        } while (choise<3 && choise>0);
    }
}
