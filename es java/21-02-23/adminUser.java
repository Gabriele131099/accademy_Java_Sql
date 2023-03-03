import java.util.*; // import the Scanner class
import java.util.ArrayList;

public class adminUser {
    public static void main(String[] args) {
        // array Admin
        ArrayList<String> arrayAdmin = new ArrayList<String>();
        // array Nome
        ArrayList<String> arrayName = new ArrayList<String>();
        // array password
        ArrayList<String> arrayPassword = new ArrayList<String>();
        // array Età
        ArrayList<Integer> arrayAge = new ArrayList<Integer>();
        // Scanner
        Scanner dataString = new Scanner(System.in);
        Scanner nScan = new Scanner(System.in);
        // Variabili d'appoggio tmp
        String nameTmp = "";
        String passwordTmp = "";
        int ageTmp = 0;
        int choiseAction = 0;
        // counter lenght array user name
        int nUser = 0;
        do {
            do {
                System.out.println("Vuoi 1 inserire, 2 modificare, 3 rimuovere un utente, 4 logga, 5 exit");
                choiseAction = nScan.nextInt();

            } while (choiseAction < 0 || choiseAction > 5);
            // switch per selezione azione

            switch (choiseAction) {
                // add
                case 1:
                    System.out.println("Quanti utenti vuoi aggiungere?");
                    int count = nScan.nextInt();
                    nUser += count;
                    // prende i 3 dati degli user
                    for (int i = 0; i < count; i++) {
                        System.out.println("Inserisci i dati dell'utente");
                        do {
                            System.out.println("Nome Utente");
                            nameTmp = dataString.nextLine();
                            if (arrayName.indexOf(nameTmp) >= 0) {
                                System.out.println("L'utente esiste gia");
                            }
                        } while (arrayName.indexOf(nameTmp) >= 0);
                        System.out.println("Età Utente");
                        ageTmp = nScan.nextInt();
                        System.out.println("Inserisci la Password");
                        passwordTmp = dataString.nextLine();
                        // carico i dati del nuovo user
                        System.out.println("Confermi i dati inseriti? 1 si, 2 no");
                        if (nScan.nextInt() == 1) {
                            arrayName.add(nameTmp);
                            arrayAge.add(ageTmp);
                            arrayPassword.add(passwordTmp);
                        } else {
                            System.out.println("annullato");
                            i--;
                        }
                    }

                    break;

                // modify
                case 2:
                    System.out.println("Vuoi modificare i dati del tuo account? 1 si 2 no");
                    if (nScan.nextInt() == 1) {
                        System.out.println("Cerca per nome");
                        nameTmp = dataString.nextLine();
                        int positionInArray = arrayName.indexOf(nameTmp);
                        Boolean existElement = positionInArray >= 0;
                        System.out.println(existElement);
                        if (existElement) {
                            System.out.println("Ciao " + arrayName.get(positionInArray));
                            do {
                                System.out.println("Nome Utente nuovo");
                                nameTmp = dataString.nextLine();
                                if (arrayName.indexOf(nameTmp) >= 0) {
                                    System.out.println("Il nome esiste gia");
                                }
                            } while (arrayName.indexOf(nameTmp) >= 0);
                            do {
                                System.out.println("Inserisci la tua nuova età");
                                ageTmp = nScan.nextInt();
                            } while (ageTmp > 0);
                            System.out.println("Confermi la Modifica? 1 si 2 no");
                            if (nScan.nextInt() == 1) {
                                System.out.println("Inserisci la password");
                                passwordTmp = dataString.nextLine();
                                if (passwordTmp.equals(arrayPassword.get(positionInArray))) {
                                    arrayName.set(positionInArray, nameTmp);
                                    arrayAge.set(positionInArray, ageTmp);
                                    System.out.println("Modifiche effettuate " + arrayName.get(positionInArray));
                                } else {
                                    System.out.println("password errata");
                                }
                            } else {
                                System.out.println("modifiche annullate");
                            }
                        }
                    }
                    break;
                // delete
                case 3:
                    int choiseDelete = 0;
                    do {
                        System.out.println("Vuoi rimuovere un uente o tutti? 1 per 1 e 2 per tutti");
                        choiseDelete = nScan.nextInt();
                    } while (choiseDelete > 0 && choiseDelete < 3);
                    if (choiseDelete == 1) {
                        System.out.println("Rimuovi un utente");
                        System.out.println("Cerca per nome");
                        nameTmp = dataString.nextLine();
                        int positionInArray = arrayName.indexOf(nameTmp);
                        Boolean existElement = positionInArray >= 0;
                        System.out.println(existElement);
                        if (existElement) {
                            System.out.println("Ciao " + arrayName.get(positionInArray));
                            System.out.println("Inserisci la password per eliminare l'utente");
                            passwordTmp = dataString.nextLine();
                            if (passwordTmp.equals(arrayPassword.get(positionInArray))) {
                                arrayName.remove(positionInArray);
                                arrayAge.remove(positionInArray);
                                arrayPassword.remove(positionInArray);
                                nUser -= 1;
                                System.out.println("Utente eliminato, " + nameTmp);
                            } else {
                                System.out.println("password errata");
                            }
                        }
                    } else {
                        arrayName.clear();
                        arrayAge.clear();
                        arrayPassword.clear();
                        nUser = 0;
                        System.out.println("Rimuovi tutti gli user");
                    }

                    break;
                // login
                case 4:
                    System.out.println("Login");
                    System.out.println("Inserisci il tuo nome");
                    nameTmp = dataString.nextLine();
                    int positionInArray = arrayName.indexOf(nameTmp);
                    Boolean existElement = positionInArray >= 0;
                    System.out.println(existElement);
                    if (existElement) {
                        System.out.println("Ciao " + arrayName.get(positionInArray));
                        System.out.println("Inserisci la password per loggare");
                        passwordTmp = dataString.nextLine();
                        if (passwordTmp.equals(arrayPassword.get(positionInArray))) {
                            System.out.println("Utente loggato, " + nameTmp);
                            do {
                                System.out.println("aggiungi elementi nell array");
                                arrayAdmin = myMethodReturnArrayList(arrayAdmin, dataString.nextLine());
                                System.out.println("Vuoi iserire altre stringhe? 1 si 2 no");
                            } while (nScan.nextInt() == 1);
                            System.err.println(arrayAdmin);
                            System.out.println("Sloggato, arrivederci " + arrayName.get(positionInArray));
                        } else {
                            System.out.println("password errata");
                        }
                    }
                    break;
                default:
                    break;
            }
            // Stampo i vari user
            for (int j = 0; j < nUser; j++) {
                System.out.println(arrayName.get(j) + " " + arrayAge.get(j));
            }
        } while (choiseAction != 5);
        dataString.close();
        nScan.close();
    }
//controlli sulla password
    static ArrayList<String> myMethodReturnArrayList(ArrayList<String> array, String s) {
        // appartiene al main
        array.add(s);
        System.out.println(s + " è stato aggiunto");
        return array;
    }
}
