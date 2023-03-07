package esOverride;

public class Client extends Prent{
    @Override
    void show(){
        super.show();
        System.out.println("child show()");
    }
    
    public static void main(String[] args) {
        Prent obj = new Client();
        obj.show();
        obj.showBis();
    }
}
