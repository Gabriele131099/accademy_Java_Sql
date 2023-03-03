public class esclassi_1 {
    int x = 55;
    String s = "ciao";
    static Boolean flag = false;
    public esclassi_1(int x,String s,boolean flag) {
       
    }
    public esclassi_1() {
       
    }
    public esclassi_1(int x) {
       
    }
    static boolean getFlag() {
       return flag;
    } 
    static void reverseFlag() {
        flag=!flag;
    } 
    public void lockerFlag() {
        if (flag) {
            flag = false;
        }
    } 
    public void fullThrottle() {
        System.out.println("veloce la macchina");
    } 
    public void fullThrottle(Boolean flag) {
        if (flag) {
            System.out.println("veloce la macchina"); 
        }else{
            System.out.println("è lenta");
        }
    } 
    public void speed() {
        System.out.println("la velocità massima è " + x);
    } 
    public static void main(String[] args) {
        esclassi_1 myClass1 = new esclassi_1();
        esclassi_1 myClass2 = new esclassi_1();
        esclassi_1 myClass3 = new esclassi_1();
        myClass1.speed();
        myClass1.x = 70;
        if ( myClass1.x> myClass2.x) {
            myClass3.reverseFlag();
            System.out.println(myClass3.flag);
            myClass3.lockerFlag();
            System.out.println(myClass3.getFlag());
            System.out.println(myClass3.flag);
        
        } else{
            myClass1.x +=38;
        }
        if (myClass3.flag) {
            myClass2.s = "sono il secondo";
            System.out.println(myClass2.s);
            myClass1.x +=38;
        }        
        myClass2.fullThrottle();

        System.out.println(myClass1.x);
        System.out.println(myClass2.x);
    }
}
