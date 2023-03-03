package ristorante;

import java.util.ArrayList;
import java.util.UUID;

public class Piatto {
    private String id = UUID.randomUUID().toString();
    String nome;
    int prezzo;
    ArrayList<Ingrediente> idIngredienti = new ArrayList<>(); // minimo 2
    private ArrayList<Ingrediente> IngredientiStatici = new ArrayList<>();

    public Piatto(String nome, int prezzo, ArrayList<Ingrediente> idIngredienti, ArrayList<Ingrediente> IngredientiStatici) {
        this.nome = nome;
        this.prezzo = prezzo;
        this.idIngredienti = idIngredienti;
        this.IngredientiStatici = IngredientiStatici;
    }
    public String getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Ingrediente> getIdIngredienti() {
        return idIngredienti;
    }

    public void setIdIngredienti(ArrayList<Ingrediente> idIngredienti) {
        this.idIngredienti = idIngredienti;
    }

    public ArrayList<Ingrediente> getIngredientiStatici() {
        return IngredientiStatici;
    }
    public int getPrezzo() {
        return prezzo;
    }
    public void setPrezzo(int prezzo) {
        this.prezzo = prezzo;
    }

    public void setIngredientiStatici(Ingrediente s) {
        IngredientiStatici.add(s);
    }

    public void modifyIngredientiTatici(int index, Ingrediente ingredient) {
        IngredientiStatici.set(index, ingredient);
    }

    public void addIngredient(Ingrediente s){
        idIngredienti.add(s);
    }
    public void stampa(int i) {
        String ingredienti = "";
        for (Ingrediente ingrediente : IngredientiStatici) {
            ingredienti += ingrediente.nome + ", ";
        }
        for (Ingrediente ingrediente : idIngredienti) {
            ingredienti += ingrediente.nome + ", ";
        }
        System.out.println(i + " Il nome del piatto " + nome);
        System.out.println(ingredienti);
        System.out.println("Il prezzo è " + prezzo);
    }


}
