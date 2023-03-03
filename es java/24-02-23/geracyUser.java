import java.util.*;

public class geracyUser {
    public static void main(String[] args) {
        geracyUser geracy = new geracyUser();
        // scanner
        Scanner nScan = new Scanner(System.in);
        Scanner sScan = new Scanner(System.in);
        // password
        String password = "Ciao";
        String passwordTmp;
        // array nome Utenti
        ArrayList<String> arrayUserName = new ArrayList<String>();
        arrayUserName.add("filippoKen");
        arrayUserName.add("giuseppeRen");
        arrayUserName.add("gabNey");
        arrayUserName.add("and");
        arrayUserName.add("king");

        // array ruolo Utente
        ArrayList<Integer> arrayUserRuoli = new ArrayList<Integer>();
        arrayUserRuoli.add(0);
        arrayUserRuoli.add(1);
        arrayUserRuoli.add(1);
        arrayUserRuoli.add(0);
        arrayUserRuoli.add(2);

        // arrayruoli
        ArrayList<String> arrayRuoli = new ArrayList<String>();
        arrayRuoli.add("user");
        arrayRuoli.add("admin");
        arrayRuoli.add("capo");

        int log = 0;
        String username;
        do {
            System.out.println("Ciao,vuoi accedere? 1 si 2 no 3 exit");
            log = nScan.nextInt();

            if (log == 1) {
                System.out.println("Inserisci l'username");
                 username = sScan.nextLine();

                System.out.println("Inserisci password");
                 passwordTmp = sScan.nextLine();

                boolean flagUser = false;
                boolean flagAdmin = false;
                boolean flagCapo = false;
                System.out.println(arrayUserName.indexOf(username));
                if (arrayUserName.indexOf(username) >= 0) {
                    if (!passwordTmp.equals(password) && arrayUserRuoli.get(arrayUserName.indexOf(username)) == 0) {
                        flagUser = true;
                        System.out.println("user");
                        geracy.addUser(username);
                    }
                    if (passwordTmp.equals(password) && arrayUserRuoli.get(arrayUserName.indexOf(username)) == 1) {
                        flagAdmin = true;
                        System.out.println("admin");
                        geracy.addUser(username, password);
                    }

                    if (passwordTmp.equals(password) && arrayUserRuoli.get(arrayUserName.indexOf(username)) == 2) {
                        flagCapo = true;
                        System.out.println("capo");
                        geracy.addUser(username, password, flagCapo);
                    }

                } 
                }else {
                    System.out.println("Ti vuoi registrare? 1 si 2 no");
                    int registrer = nScan.nextInt();
                    if (registrer == 1) {
                        System.out.println("UserName");
                        username = sScan.nextLine();
                        System.out.println("password");
                        passwordTmp = sScan.nextLine();
                        arrayUserName.add(username);
                        if (passwordTmp.equals(password)) {
                            arrayUserRuoli.add(1);
                        } else {
                            arrayUserRuoli.add(0);
                        }
                    }
                for (int i = 0; i < arrayUserName.size(); i++) {
                    System.out.println(arrayUserName.get(i) + " sei un " + arrayRuoli.get(arrayUserRuoli.get(i)));
                }

            }
        } while (log <2 && log>=0);
    }

    public void addUser(String Username) {
        System.out.println("sei un user");
    }

    public void addUser(String Username, String password) {
        System.out.println("Sei admin " + Username);
    }

    public void addUser(String Username, String password, boolean flag) {
        if (flag) {
            System.out.println("Sei il capo " + Username);
        }
    }
}
