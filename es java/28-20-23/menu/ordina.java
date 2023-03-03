package menu;

import java.util.ArrayList;
import java.util.Scanner;

public class ordina {
    public static void main(String[] args) {
        Scanner nScan = new Scanner(System.in);
        Scanner sScan = new Scanner(System.in);
        System.out.println("salve");
        boolean userExist = false;
        ArrayList<user> arrayUsers = new ArrayList<>();
        ArrayList<piatto> arrayPlates = new ArrayList<>();
        ArrayList<Ingrediente> arrayIngredients = new ArrayList<>();
        do {
            System.out.println("hai un account? 0 e 1");
            userExist = nScan.nextInt()==0;
            int searchUser=0;
            if (userExist) {
                System.out.println("come ti chiami?");
                String nome=sScan.nextLine();
                for (int i = 0; i < arrayUsers.size(); i++) {
                   userExist = arrayUsers.get(i).nome.equals(nome);
                   if (userExist) {
                       System.out.println("ciao " + arrayUsers.get(i).nome);
                       searchUser = arrayUsers.get(i).id;
                   }
                   
                }
            }else{
                System.out.println("registrati");
                System.out.println("nome");
                String nome = sScan.nextLine();
                System.out.println("budget");
                int budget = nScan.nextInt();
                user user = new user(arrayUsers.size(), nome, budget);
            }
        } while (userExist);
        int orderFlag= 0;
        do {
            System.out.println("Ordina un piatto o crea, 0 e 1");
            orderFlag = nScan.nextInt();
            if (orderFlag==0) {
                System.out.println("compra un Piatto");
            }
            if (orderFlag==1) {
                System.out.println("crea un Piatto");
                System.out.println("Come lo vuoi chiamare");
                String plateName = sScan.nextLine();
                System.out.println("Inserisci gli ingredienti");
                int addIngredient=0;
                do {
                    System.out.println("nome ingrediente");
                    Ingrediente ingr = new Ingrediente(0, sScan.nextLine());
                    arrayIngredients.add(ingr);
                    System.out.println("Vuoi aggiungerne un altro? 0 1");
                    addIngredient= nScan.nextInt();
                } while (addIngredient==0);
                System.out.println("tipo del piatto");
                String typePlate = sScan.nextLine();
                System.out.println("costo");
                int costo = nScan.nextInt();
                piatto plate = new piatto(arrayPlates.size(),plateName,typePlate,arrayIngredients,costo);
                arrayPlates.add( plate);
            }
        } while (orderFlag<2);
    }
}
