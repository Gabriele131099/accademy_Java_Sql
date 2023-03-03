package menu;

import java.util.ArrayList;

public class piatto {
    int id;
    String nome;
    int prezzo;
    String tipo;
    ArrayList<Ingrediente> arrayIngredienti = new ArrayList<Ingrediente>();
    public piatto(int id,String nome, String tipo,ArrayList<Ingrediente> ingredienti,int prezzo) {
        this.id = id;
        this.nome=nome;
        this.tipo = tipo;
        this.arrayIngredienti=ingredienti;
        this.prezzo = prezzo;
    }
}
