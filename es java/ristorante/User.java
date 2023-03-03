package ristorante;

import java.util.ArrayList;
import java.util.UUID;

public class User {

    private String id = UUID.randomUUID().toString();
    String nome;
    String password;
    ArrayList<Ordine> idOrdini = new ArrayList<>();
    private double budget = Math.random() * 300;
    Boolean log = false;
    Boolean admin;

    public User(String nome, String password, ArrayList<Ordine> arrayOrdini) {
        this.nome = nome;
        this.password = password;
        this.idOrdini = arrayOrdini;
    }

    public User(String nome, String password, boolean admin) {
        this.nome = nome;
        this.password = password;
        this.admin = admin;
    }

    public String getId() {
        return id;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public ArrayList<Ordine> getIdOrdini() {
        return idOrdini;
    }

    public void setIdOrdini(ArrayList<Ordine> idOrdini) {
        this.idOrdini = idOrdini;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void stampa() {
        System.out.println("username: " + nome);
        System.out.println("Con budget " + budget);
    }

    public boolean checkPass(String pass) {
        return this.password.equals(pass);
    }
    public Boolean getLog() {
        return log;
    }
    public void setLog(Boolean log) {
        this.log = log;
    }
    public void logIn() {
        this.log = true;
    }

    public void logOut() {
        this.log = false;
    }
    public Boolean isLog(){

        return true;
    }
    public String pay(int price) {
        boolean flagPayment = false;
        String s;
        if (this.budget <= price) {
            System.out.println("Budget non sufficente");
            flagPayment = false;
        } else {
            this.budget -= price;
            flagPayment = true;
        }

        if (flagPayment) {
            s = "Grazie per l'acquisto.";
           s = "Il tuo budget rimanente è pari a " + this.budget;
        } else {
           s = "Mi dispace, credito inferiore";
        }
        return s;
    }

}
