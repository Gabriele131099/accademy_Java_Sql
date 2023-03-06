package animali;

import java.util.ArrayList;

public class Roditori {
    private ArrayList<Animale> arrayRoditori = new ArrayList<Animale>();
    final String specie = "Roditori" ;
    public Roditori(){

    }
    public void addAnimal(Animale pet){
        this.arrayRoditori.add(pet);
    }
    public ArrayList<Animale> getArrayRoditori() {
        return arrayRoditori;
    }
    public void setArrayRoditori(ArrayList<Animale> arrayRoditori) {
        this.arrayRoditori = arrayRoditori;
    }
    public void showAllAnimal(){
        for (Animale animale : arrayRoditori) {
            System.out.println(animale.getNome());
        }
    }
}
