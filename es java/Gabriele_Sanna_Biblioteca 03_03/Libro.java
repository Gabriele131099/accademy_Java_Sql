package Gabriele_Sanna_test;

import java.util.UUID;

public class Libro {
    private String uid = UUID.randomUUID().toString();
    String nome;
    private int quantity;
    private int countNoleggi;

    public Libro(String nome, int quantity) {
        this.nome = nome;
        this.quantity = quantity;
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
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public int getCountNoleggi() {
        return countNoleggi;
    }
    public void setCountNoleggi(int countNoleggi) {
        this.countNoleggi = countNoleggi;
    }
    //aggiungi noleggio
    public void addNoleggio(){
        this.countNoleggi +=1;
    }
    public void removeNoleggio(){
        this.countNoleggi -=1;
    }

    // stampa
    public void stampa(int i){
        System.out.println(i+" "+this.nome + ", ci sono "+ quantity+", di cui "+countNoleggi+", rimaneti " + (quantity-countNoleggi));
    }
}
