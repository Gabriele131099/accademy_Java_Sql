package polimorfismo;
public class Pirata extends Persona{
 
    Pirata(String namePersona){
        super(namePersona);
      
    }
  
    @Override
   public void saluta(){
      System.out.println("Corpo di mille balene");
   }
}
