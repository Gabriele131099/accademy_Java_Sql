import java.util.ArrayList;

public class es1Method {
    public static void main(String[] args) {
        ArrayList<Integer> arrayInt = new ArrayList<Integer>();

        myMethodVoid("nome");
        System.out.println(myMethodReturnInt(5));
        System.out.println(myMethodReturnFloat(2));
        System.out.println(myMethodReturnDouble(2));
        System.out.println(myMethodReturnBool(2));
        System.out.println(myMethodReturnChar("ciao"));
        System.out.println(myMethodReturnArrayList(arrayInt));
    }
    static void myMethodVoid(String s){
        //appartiene al main
        //void non torna niente "return"
        System.out.println(s);
    }
    static int myMethodReturnInt(int n){
        //appartiene al main
        //void non torna niente "return"
       return n* 5;
    }
    static float myMethodReturnFloat(int n){
        //appartiene al main
       return n* 5;
    }
    static double myMethodReturnDouble(int n){
        //appartiene al main
       return n* 5.2;
    }
    static Boolean myMethodReturnBool(int n){
        //appartiene al main 
       return n > 5;
    }
    static char myMethodReturnChar(String s){
        //appartiene al main
       return s.charAt(1);
    }
    static ArrayList myMethodReturnArrayList(ArrayList array){
        //appartiene al main
        array.add(10);
       return array;
    }
}
