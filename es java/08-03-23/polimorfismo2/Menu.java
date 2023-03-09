package polimorfismo2;

import java.util.ArrayList;
import java.util.UUID;


public class Menu {
    private String id = UUID.randomUUID().toString();
    String nome;
    Menu(String nome){
        this.nome=nome;
    }
    public String getNome() {
        return nome;
    }
    public static void main(String[] args) {

        Menu menuPrimi = new Menu("Primi");

        ArrayList<Piatto> arrayPiatti = new ArrayList<Piatto>();
        String [] arrayIngredienti = {"pasta","Sugo","Formaggio"};
        Piatto piattoTest = new Piatto(arrayIngredienti, 15, "Filippo", menuPrimi.getNome());
        arrayPiatti.add(piattoTest);
        String[] arrayIngredientiBis = {"pasta","carbo-crema","Formaggio"};
        Piatto piattoTestBis = new Piatto(arrayIngredientiBis, 25, "Filippo", menuPrimi.getNome());
        arrayPiatti.add(piattoTestBis);

        ArrayList<Ordinazione> arrayOrdini = new ArrayList<Ordinazione>();
        Ordinazione ordine = new Ordinazione(piattoTest.getId());
        arrayOrdini.add(ordine);







        int totPrice = 0;
        for (Piatto piatto : arrayPiatti) {
            System.out.println(piatto.getId());
            for (Ordinazione ordinazione : arrayOrdini) {
                System.out.println(ordinazione.getIdPiatto());
                if (ordinazione.getIdPiatto().equalsIgnoreCase(piatto.getId())) {
                    totPrice += piatto.prezzo;
                }
            }
        }
        System.out.println("Hai speso "+ totPrice);
    }
}
