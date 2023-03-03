package ristorante;

import java.util.ArrayList;

public class Piatto {
    Integer id;
    String nome;
    int prezzo;
    ArrayList<String> idIngredienti = new ArrayList<>(); //minimo 2
    private ArrayList<String> IngredientiStatici = new ArrayList<>();
    public Piatto(int id, String nome, int prezzo, ArrayList<String> idIngredienti,ArrayList<String> IngredientiStatici) {
        this.id = id;
        this.nome=nome;
        this.prezzo = prezzo;
        this.idIngredienti = idIngredienti;
        this.IngredientiStatici = IngredientiStatici;
        }
        public void stampa(){
            String ingredienti = "";
            for (String ingrediente : IngredientiStatici) {
                ingredienti += ingrediente + ", ";
            }
            for (String ingrediente : idIngredienti) {
                ingredienti += ingrediente + ", ";
            }
            System.out.println(id+ " Il nome del piatto "+nome);
            System.out.println(ingredienti);
            System.out.println("Il prezzo è "+prezzo);
        }
        public void setIngredientiStatici(String s) {
            IngredientiStatici.add(s);
        }
        public void setIngredient(int index,String ingredient) {
            IngredientiStatici.set(index, ingredient);
        }
}
