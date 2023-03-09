package polimorfismo;
public class Persona {
    private String name;
     Persona(String name){
        this.name = name;
    }
    
    public void saluta(){
        System.out.println("Ciao "+this.name);
    }
}
