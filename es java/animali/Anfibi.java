package animali;

import java.util.ArrayList;

public class Anfibi {
    private ArrayList<Animale> arrayAnfibi = new ArrayList<Animale>();
    final String specie = "Anfibi" ;
    public Anfibi(){

    }
  
    public ArrayList<Animale> getArrayAnfibi() {
        return arrayAnfibi;
    }
    public void setArrayAnfibi(ArrayList<Animale> arrayAnfibi) {
        this.arrayAnfibi = arrayAnfibi;
    }
    public void showAllAnimal(){
        for (Animale animale : arrayAnfibi) {
            System.out.println(animale.getNome());
        }
    }  
    public void addAnimal(Animale pet){
        this.arrayAnfibi.add(pet);
    }
}
