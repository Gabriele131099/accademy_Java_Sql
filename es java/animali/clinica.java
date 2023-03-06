package animali;

import java.util.Scanner;

public class clinica {
    public static void main(String[] args) {
        Scanner nScan = new Scanner(System.in);
        Scanner sScan = new Scanner(System.in);
        System.out.println("Buongiorno");
        Boolean flagOpenProgram = false;
        Roditori roditori = new Roditori();
        Anfibi anfibi = new Anfibi();
        Canidi canidi = new Canidi();
        Felini felini = new Felini();
        String[] arrayRazze = { roditori.specie, anfibi.specie, canidi.specie, felini.specie };
        do {
            System.out.println("Vuoi avviare il programma? 0 e 1");
            flagOpenProgram = nScan.nextInt() == 0;
            if (flagOpenProgram) {
                Boolean flagChoisePet = false;
                do {
                    System.out.println("Inserisci il nome dell'animale");
                    String nomePet = sScan.nextLine();

                    System.out.println("Che animale è?");
                    for (int i = 0; i < arrayRazze.length; i++) {
                        System.out.println(i + " " + arrayRazze[i]);
                    }
                    int choiseRazza = nScan.nextInt();
                    System.out.println("Confermi che il tuo animale si chiami " + nomePet + ", fa parte della famiglia "
                            + arrayRazze[choiseRazza]+ "? 0 o 1");
                    Boolean flagConfirmedPet = nScan.nextInt() == 0;
                    if (flagConfirmedPet) {
                        Animale animale = new Animale(nomePet);
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
               
                System.out.println( roditori.specie.toUpperCase() +" "+(roditori.getArrayRoditori().size()-1));
                roditori.showAllAnimal();
                System.out.println( anfibi.specie.toUpperCase()+" "+(anfibi.getArrayAnfibi().size()-1));
                anfibi.showAllAnimal();
                System.out.println( canidi.specie.toUpperCase()+" "+(canidi.getArrayCanidi().size()-1));
                canidi.showAllAnimal();
                System.out.println( felini.specie.toUpperCase()+" "+(felini.getArrayFelini().size()-1));
                felini.showAllAnimal();
                System.out.println("Nella clinica ci sono "+
                ((roditori.getArrayRoditori().size()-1))
                +(anfibi.getArrayAnfibi().size()-1)
                +(canidi.getArrayCanidi().size()-1)
                +(felini.getArrayFelini().size()-1));            }

        } while (flagOpenProgram);
    }
}
