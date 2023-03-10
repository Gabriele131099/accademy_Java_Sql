package libreria;

import java.util.ArrayList;
import java.util.Scanner;

public class Libreria {
    int nLibri ;
    private ArrayList<Libro> listaLibri = new ArrayList<Libro>();
    public int getnLibri() {
        return nLibri;
    }
    public void setnLibri() {
        this.nLibri = this.listaLibri.size()+1;
    }
    public ArrayList<Libro> getListaLibri() {
        return listaLibri;
    }
    private class Libro{
        String genere;
        Libro(String enere){
            this.genere = enere;
        }
        public String getGenere() {
            return genere;
        }
        public void setGenere(String genere) {
            this.genere = genere;
        }
      
        
    }
    public  void setLibro() {
        Scanner nScan = new Scanner(System.in);
        System.out.println("Dammi il genere libro");
        Libro libro = new Libro(nScan.nextLine());
        this.setnLibri();
        
    }
    public static void main(String[] args) {
        Libreria libreria = new Libreria();
        libreria.setLibro();
        libreria.setLibro();
        libreria.setLibro();
        libreria.setLibro();
        System.out.println(libreria.nLibri);
        for (Libreria.Libro libro : libreria.getListaLibri()) {
            System.out.println(libro.genere);
        }
    }
}
