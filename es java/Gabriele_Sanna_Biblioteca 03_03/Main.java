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
        do {
            System.out.println("Vuoi avviare il programma? 0 o 1");
            flagAvvioProgramma = nScan.nextInt() == 0;
            if (flagAvvioProgramma) {
                Boolean flagEnterMenu = false;
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

            }
        } while (flagAvvioProgramma);
    }
}
