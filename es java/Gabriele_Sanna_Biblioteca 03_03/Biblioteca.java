package Gabriele_Sanna_test;

import java.util.ArrayList;
import java.util.UUID;

public class Biblioteca {
    private String uid = UUID.randomUUID().toString();
    String nome;
    int allNoleggi ;
    ArrayList<Libro> arrayLibri = new  ArrayList<Libro>();
    
    public Biblioteca(String nome,ArrayList<Libro> arrayLibri) {
        this.nome = nome;
      getAllNoleggi();
        this.arrayLibri = arrayLibri;
    }
    public String getUid() {
        return uid;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void getAllNoleggi() {
        this.allNoleggi = 0;
        for (int i = 0; i < this.arrayLibri.size(); i++) {
            //cicla i libri e somma i noleggi di ogni libro
           this.allNoleggi += arrayLibri.get(i).getCountNoleggi();
            
        }
    }
   
    public ArrayList<Libro> getArrayLibri() {
        return arrayLibri;
    }
    public void setArrayLibri(ArrayList<Libro> arrayLibri) {
        this.arrayLibri = arrayLibri;
    }

    //metodi azioni
    public void prestaLibro(String uidLibro) {
        for (int i = 0; i < this.arrayLibri.size(); i++) {
            //cicla i libri e compara i libri con quello scelto dall utente
            if (arrayLibri.get(i).getUid().equals(uidLibro)) {
                //controlla se esistono ancora libri disponibili
                if (arrayLibri.get(i).getCountNoleggi()<arrayLibri.get(i).getQuantity()) {
                    arrayLibri.get(i).addNoleggio();
                    System.out.println("Noleggio effetuato, hai preso il libro" + arrayLibri.get(i).getNome());
                }else{
                    System.out.println("Libro esaurito");
                }
            }
        }
    }

    public void restituisciLibro(String uidLibro){
        for (int i = 0; i < this.arrayLibri.size(); i++) {
            //cicla i libri e compara i libri con quello scelto dall utente
            if (arrayLibri.get(i).getUid().equals(uidLibro)) {
                //controlla se esistono ancora libri disponibili
                if (arrayLibri.get(i).getCountNoleggi()>0) {
                    arrayLibri.get(i).removeNoleggio();
                }else{
                    System.out.println("Libro esaurito");
                }
            }
        }
    }

    //aggiungi libro
    public void aggiungiLibro(String nome, int quantity){
        Libro libro = new Libro(nome, quantity);
        arrayLibri.add(libro);
        System.out.println("Libro aggiunto");
    }
    public void rimuoviLibro(String uidLibro){
        for (int i = 0; i < this.arrayLibri.size(); i++) {
            if (arrayLibri.get(i).getUid().equals(uidLibro)) {
                 this.arrayLibri.remove(i);
                 System.out.println("Libro rimosso");
            }else{
                System.out.println("Libro non esistente");
            }
         
        }
    }
    public void rimuoviLibri(){
        arrayLibri.clear();
        System.out.println("rimossi tutti i libri");
    }

    public void stampaLibriDisponibili(){
        for (int j = 0; j < arrayLibri.size(); j++) {
             if (arrayLibri.get(j).getQuantity()>arrayLibri.get(j).getCountNoleggi()) {
                arrayLibri.get(j).stampa(j);
            }
        }
       
    }
}
