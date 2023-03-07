package esIncapsulamento;

public class Main {
    public static void main(String[] args) {
        SBI s = new SBI();
        ICICI i = new ICICI();
        AXIS a = new AXIS();
        System.out.println(s.getStringeOfInternet() +" rate: "+ s.getRateOfInternet());
        System.out.println(i.getStringeOfInternet() +" rate: "+ i.getRateOfInternet());
        System.out.println(a.getStringeOfInternet() +" rate: "+ a.getRateOfInternet());
        
    }
}
