package animali;

import java.util.ArrayList;

public class Canidi {
    private ArrayList<Animale> arrayCanidi = new ArrayList<Animale>();
    final String specie = "Canidi" ;
    public Canidi(){

    }
    public void addAnimal(Animale pet){
        this.arrayCanidi.add(pet);
    }
    public ArrayList<Animale> getArrayCanidi() {
        return arrayCanidi;
    }
    public void setArrayCanidi(ArrayList<Animale> arrayCanidi) {
        this.arrayCanidi = arrayCanidi;
    }
    public void showAllAnimal(){
        for (Animale animale : arrayCanidi) {
            System.out.println(animale.getNome());
        }
    }
}
