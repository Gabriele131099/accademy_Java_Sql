package animali;

import java.util.ArrayList;

public class Felini {
    private ArrayList<Animale> arrayFelini = new ArrayList<Animale>();
    final String specie = "Felini" ;
    public Felini(){

    }
    public void addAnimal(Animale pet){
        this.arrayFelini.add(pet);
    }
    public ArrayList<Animale> getArrayFelini() {
        return arrayFelini;
    }
    public void setArrayFelini(ArrayList<Animale> arrayFelini) {
        this.arrayFelini = arrayFelini;
    }
    public void showAllAnimal(){
        for (Animale animale : arrayFelini) {
            System.out.println(animale.getNome());
        }
    }
}
