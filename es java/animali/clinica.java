package animali;

import java.util.ArrayList;
import java.util.Scanner;

public class clinica {
    public static void main() {
        //scanner
        Scanner nScan = new Scanner(System.in);
        Scanner sScan = new Scanner(System.in);
        System.out.println("Buongiorno");
        Boolean flagOpenProgram = false;
        //stanzio le classi
        Roditori roditori = new Roditori();
        Anfibi anfibi = new Anfibi();
        Canidi canidi = new Canidi();
        Felini felini = new Felini();
        //array razze
        String[] arrayRazze = { roditori.specie, anfibi.specie, canidi.specie, felini.specie };
        do {
            System.out.println("Vuoi avviare il programma? 0 e 1");
            flagOpenProgram = nScan.nextInt() == 0;
            if (flagOpenProgram) {
                Boolean flagChoisePet = false;
                do {
                    //nome
                    System.out.println("Inserisci il nome dell'animale");
                    String nomePet = sScan.nextLine();
                    //anni
                    Boolean flagValidAge = false;
                    int anni = 0;
                    do {
                        System.out.println("Quanti anni ha il tuo "+nomePet);
                         anni = nScan.nextInt();
                        flagValidAge = anni>=0;
                        if (flagValidAge) {
                            
                        }else{
                            System.out.println("deve ancora nascere");
                        }
                        
                    } while (!flagValidAge);
                    //razza
                    System.out.println("Che animale è?");
                    for (int i = 0; i < arrayRazze.length; i++) {
                        System.out.println(i + " " + arrayRazze[i]);
                    }
                    int choiseRazza = nScan.nextInt();
                    System.out.println("Confermi che il tuo animale si chiami " + nomePet + ", fa parte della famiglia "
                            + arrayRazze[choiseRazza]+ "? 0 o 1");
                    Boolean flagConfirmedPet = nScan.nextInt() == 0;
                    if (flagConfirmedPet) {
                        //crea e aggiunge animale
                        Animale animale = new Animale(nomePet,anni);
                        switch (choiseRazza) {
                            case 0:
                                roditori.addAnimal(animale);
                                break;
                            case 1:
                                anfibi.addAnimal(animale);
                                break;
                            case 2:
                                canidi.addAnimal(animale);
                                break;
                            case 3:
                                felini.addAnimal(animale);
                                break;
                            default:
                                break;
                        }
                        System.out.println("Animale Salvato, ciao " + nomePet);

                    } else {
                        System.out.println("Inserimento annulato, "+nomePet+" Addio");
                    }
                    System.out.println("Vuoi inserire un altro animale? 0 o 1");
                    flagChoisePet = nScan.nextInt()==0;
                } while (flagChoisePet);

                //stampe razze
               if (!anfibi.getArrayAnfibi().isEmpty()) {
                   System.out.println( "Ci sono "+(anfibi.getArrayAnfibi().size())+ anfibi.specie.toUpperCase());
                   anfibi.showAllAnimal();
               }
               if (!canidi.getArrayCanidi().isEmpty()) {
                System.out.println( "Ci sono "+(canidi.getArrayCanidi().size())+canidi.specie.toUpperCase());
                canidi.showAllAnimal();
               }
               if (!felini.getArrayFelini().isEmpty()) {
                System.out.println( "Ci sono "+(felini.getArrayFelini().size())+felini.specie.toUpperCase());
                felini.showAllAnimal();
               }
               if (!roditori.getArrayRoditori().isEmpty()) {
                System.out.println( "Ci sono "+(roditori.getArrayRoditori().size())+roditori.specie.toUpperCase());
                roditori.showAllAnimal();
               }
                //conta animali
                System.out.println("Nella clinica ci sono "+
                (roditori.getArrayRoditori().size()
                +anfibi.getArrayAnfibi().size()
                +canidi.getArrayCanidi().size()
                +felini.getArrayFelini().size())+" Animali");            }

        } while (flagOpenProgram);
    }
   
}
