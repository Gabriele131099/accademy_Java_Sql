package concessionaria;

public class Main {
    public static void main(String[] args) {
        // Macchine Auto
        Auto mac1 = new Auto("Ford", "Focus", 2000, 3, 
            "Disel", 26);
        Auto mac2 = new Auto("Opel", "Corsa", 2006, 5, 
                "Benzina", 23);

        mac1.stampaMacchina();
        mac2.stampaMacchina();

        // Moto
        Moto moto1 = new Moto("Aprilia", "X12", 2008, 400,
                "Sportiva", 200);
        Moto moto2 = new Moto("BMW", "Y2", 2015, 600,
                "Strada", 500);

        moto1.stampaMoto();
        moto2.stampaMoto();
    }
}
