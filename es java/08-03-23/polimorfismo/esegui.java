package polimorfismo;
public class esegui {
    public static void main(String[] args) {
        Persona giuseppe = new Persona("Giuseppe");
       
        Persona filippo = new Persona("Filippo");
        Persona antonio = new Persona("Antonio");
        giuseppe.saluta();
        filippo.saluta();
        antonio.saluta();
        Persona pirata = new Pirata("Pirata pepe");
        pirata.saluta();
        // ((Persona) pirata).saluta();
        Persona pepe =  ((Persona) pirata);
        pepe.saluta();
    }
}
