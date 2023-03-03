package football;

import java.util.ArrayList;
import java.util.Scanner;

public class GeneratoreSquadra {
    public static void main(String[] args) {
        Scanner nScan = new Scanner(System.in);
        Scanner sScan = new Scanner(System.in);

        int choiseUser = 0;
        //creazione di una squadra
        ArrayList<Dirigenza> arrayDirigenza = new ArrayList<>();
        ArrayList<Giocatore> arrayGiocatori = new ArrayList<>();
        
        //creazione dei dirigenti
        Dirigenza dirigente1 = new Dirigenza(0, "filippo", false);
        arrayDirigenza.add(dirigente1);
        Dirigenza dirigente2 = new Dirigenza(1, "paolo", false);
        arrayDirigenza.add(dirigente2);
        Dirigenza dirigente3 = new Dirigenza(2, "antonio", false);
        arrayDirigenza.add(dirigente3);
        Dirigenza dirigente4 = new Dirigenza(3, "boss", true);
        arrayDirigenza.add(dirigente4);

        //creazione dei giocatori
        Giocatore giocatore1 = new Giocatore(0, true, "pino");
        arrayGiocatori.add(giocatore1);
        Giocatore giocatore2 = new Giocatore(1, true, "rony");
        arrayGiocatori.add(giocatore2);
        Giocatore giocatore3 = new Giocatore(2, true, "mara");
        arrayGiocatori.add(giocatore3);
        Giocatore giocatore4 = new Giocatore(3, false, "giuseppe");
        arrayGiocatori.add(giocatore4);
        Giocatore giocatore5 = new Giocatore(4, true, "ale");
        arrayGiocatori.add(giocatore5);

        //creazione della squadra
        Squadra Squadra = new Squadra(0,"nomeSquadra", arrayDirigenza, arrayGiocatori);
        Squadra.stampaAll();
        do {
            System.out.println("Vuoi modificare la squadra?0 e 1");
            choiseUser = nScan.nextInt();
            if (choiseUser == 0) {
               System.out.println("Vuoi modificare I giocatori o i dirigenti? 0 e 1");
               int choiseModify = nScan.nextInt();
               switch (choiseModify) {
                case 0:
                    System.out.println("scegli un giocatore, tramite il suo id");
                    Squadra.stampaPlayer();
                    int choisePlayer = nScan.nextInt();
                    System.out.println("Hai scelto "+ Squadra.giocatori.get(choisePlayer).nome);
                    if (Squadra.giocatori.get(choisePlayer).panchina) {
                        System.out.println("Il giocatore gioca");
                    } else {
                        System.out.println("Il giocatore è in panchina");
                    }
                    System.out.println("Vuoi modificare il nome o il suo stato?0 e 1");
                    int choiseModifyPlayer=nScan.nextInt();
                    switch (choiseModifyPlayer) {
                        case 0:
                            System.out.println("modifica il nome");
                            System.out.println("Nome attuale "+ Squadra.giocatori.get(choisePlayer).nome);
                            System.out.println("Inserisci la modifica");
                            Giocatore giocatoreTmp = new Giocatore(99999, Squadra.giocatori.get(choisePlayer).panchina, sScan.nextLine());
                            Squadra.giocatori.set(choiseModifyPlayer, giocatoreTmp);
                            System.out.println("Sono il giocatore "+giocatoreTmp.nome);
                            Squadra.giocatori.remove(giocatoreTmp);
                            break;
                            case 1:
                            System.out.println("modifica il suo status");
                            System.out.println(Squadra.giocatori.get(choisePlayer).nome);
                            if (Squadra.giocatori.get(choisePlayer).panchina) {
                                System.out.println("Il giocatore gioca");
                            } else {
                                System.out.println("Il giocatore è in panchina");
                            }
                            System.out.println("Inserisci la modifica, 0 gioca 1 panchina");
                            Boolean flagPanchina = nScan.nextInt()==0;
                            Giocatore giocatoreTmp2 = new Giocatore(99998,flagPanchina,  Squadra.giocatori.get(choisePlayer).nome);
                            Squadra.giocatori.set(choiseModifyPlayer, giocatoreTmp2);
                            System.out.println("Sono il giocatore "+giocatoreTmp2.nome+", ora " +( giocatoreTmp2.panchina?"gioco":"non gioco"));
                            Squadra.giocatori.remove(giocatoreTmp2);
                            break;
                    
                        default:
                            break;
                    }
                    break;
                case 1:
                System.out.println("scegli un direttore, tramite il suo id");
                    Squadra.stampaPlayer();
                    int choiseDirector = nScan.nextInt();
                    System.out.println("Hai scelto "+ Squadra.dirigenti.get(choiseDirector).dirigente);
                    if (Squadra.giocatori.get(choiseDirector).panchina) {
                        System.out.println("è un dirigente");
                    } else {
                        System.out.println("è il boss");
                    }
                   
                            System.out.println("modifica il nome");
                            System.out.println("Nome attuale "+ Squadra.dirigenti.get(choiseDirector).dirigente);
                            System.out.println("Inserisci la modifica");
                            Dirigenza dirigenzaTmp = new Dirigenza(99999 ,sScan.nextLine(),Squadra.dirigenti.get(choiseDirector).boss);
                            Squadra.dirigenti.set(choiseDirector, dirigenzaTmp);
                            System.out.println("Sono un direttore "+dirigenzaTmp.dirigente+", sono " +( dirigenzaTmp.boss?"il boss":"un dirigente"));

                            Squadra.dirigenti.remove(dirigenzaTmp);
                            break;

                        default:
                            break;
                    }
                break;
                
               }
            
        } while (choiseUser == 0);

        Squadra.stampaAll();
    }
}
