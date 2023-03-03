package ristorante;

import java.util.ArrayList;

public class User {
    
    Integer id;
    String nome;
    String password;
    ArrayList<Ordine> idOrdini = new ArrayList<>();
    private double budget = Math.random()*300;
    Boolean log=false;
    Boolean admin;
    public User(int id, String nome, String password, ArrayList<Ordine> arrayOrdini) {
    this.id = id;
    this.nome=nome;
    this.password = password;
    this.idOrdini = arrayOrdini;
    }
    public User(int id, String nome, String password,boolean admin) {
        this.id = id;
        this.nome=nome;
        this.password = password;
        this.admin = admin;
        }
    public void stampa(){
        System.out.println("username: "+nome);
        System.out.println("Con budget "+budget);
    }
    public boolean checkPass(String pass){
       
        return  this.password.equals(pass);

    }
    public double getBudget(){
        return budget;
    }
    public void logIn(){
        this.log = true;
    }
    public void logOut(){
        this.log = false;
    }
    
    public void update(int price){
        this.budget-=price;
    }
    
}
