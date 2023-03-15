package forzeSpeciali;

import java.util.ArrayList;
import java.util.Scanner;

abstract class ForzeSpeciali {
    public String GradiSpeciali(int anniServizio) {
        String grado = "Recluta";
        if (anniServizio >= 1 && anniServizio < 3) {
            grado = "Sergente";
        } else if (anniServizio >= 3 && anniServizio < 5) {
            grado = "Capitano";
        } else if (anniServizio >= 5) {
            grado = "Caporale";
        } else {
            grado = "Recluta";
        }

        return grado;
    }

    public void Annodiinizio() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("da quanti anni sei nell esercito");
        int anniServizio = scanner.nextInt();
        String grado = specializzazione(GradiSpeciali(anniServizio));

    }

    public String specializzazione(String s) {
        System.out.println("ciao " + s);
        return s;
    }
}

public class Esercito {
    int nSoldati = 0;
    private ArrayList<Soldato> soldati = new ArrayList<>();

    public int getnSoldati() {
        return nSoldati;
    }

    public void setnSoldati(int nSoldati) {
        this.nSoldati = nSoldati;
    }

    public ArrayList<Soldato> getSoldati() {
        return soldati;
    }

    public void setSoldati(ArrayList<Soldato> soldati) {
        this.soldati = soldati;
    }

    public void addSoldati(Soldato soldato) {
        this.soldati.add(soldato);
    }
    private class Soldato extends ForzeSpeciali {
        private String nome;
        private int AnnodiNascita;
        private Boolean forzeSpeciali = false;

        Soldato(String nome, int annoNascita, boolean apeciale) {
            this.nome = nome;
            this.AnnodiNascita = annoNascita;
            this.forzeSpeciali = apeciale;
            if (apeciale) {
                Annodiinizio();
            } else {
                System.out.println("Sei una recluta");
            }

        }

        

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public int getAnnodiNascita() {
            return AnnodiNascita;
        }

        public void setAnnodiNascita(int annodiNascita) {
            AnnodiNascita = annodiNascita;
        }

        public Boolean getForzeSpeciali() {
            return forzeSpeciali;
        }

        public void setForzeSpeciali(Boolean forzeSpeciali) {
            this.forzeSpeciali = forzeSpeciali;
        }
    }

    public static void main(String[] args) {
        Scanner sscan = new Scanner(System.in);
        Scanner nscan = new Scanner(System.in);
        Esercito esercito = new Esercito();

        Boolean flagStart = false;
        do {
            System.out.println("Vuoi Avviare il programma? 1 o 2");
            int choiseStart = nscan.nextInt();
            flagStart = choiseStart == 1;
            if (flagStart) {
                Boolean flagSoldato = false;
                do {
                    System.out.println("Vuoi aggiungere un soldato? 1 o 2");
                    int choise = nscan.nextInt();
                    flagSoldato = choise == 1;
                    if (flagSoldato) {
                        System.out.println("Inserisci il nome del soldato");
                        String nometmp = sscan.nextLine();
                        System.out.println("Inserire l'anno di nascita");
                        int anno = nscan.nextInt();

                        System.out.println("Fai parte delle forze speciali? 1 o 2");
                        Boolean flagForzeSpeciali = nscan.nextInt() == 1;
                        boolean flagConfirmData = false;
                        System.out.println("Vuoi confermare i dati del soldato? 1 o 2");
                        flagConfirmData = nscan.nextInt() == 1;
                        if (flagConfirmData) {
                            Esercito.Soldato soldato = esercito.new Soldato(nometmp, anno, flagForzeSpeciali);
                            System.out.println("Il soldato è stato aggiunto, " + soldato.getNome());
                            esercito.addSoldati(soldato);
                            esercito.setnSoldati(esercito.getSoldati().size());
                        } else {
                            System.out.println("Dati annullati");
                        }
                    }
                } while (flagSoldato);
            }
        } while (flagStart);
    }
}
