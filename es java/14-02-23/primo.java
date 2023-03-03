public class primo{
    public static void main(String[] args){
        System.out.println("Ciao Mondo");
        // System.out.println("Sono Gabriel");
        System.out.print("Sono truddi , ");
        System.out.print("ho 12 anni");
        System.out.println(3+3);
        int num = 21;
        String text ="ciao";
        boolean flag = true;
        System.out.println(flag);
        System.out.println(num);
        System.out.println(text);
        System.out.println("numero" + num);
        String a = "ciao ";
        String b = "mondo";
        final String c = a + b;
        System.out.println(c);
        final int iva = 20;
        System.out.println(iva + num);
        num = iva;
        System.out.println(num);
        System.out.println(arrotonda((float)3.6));

        int e = 6;
        int v = 5;
        float h,k;
        h = e/v;
        k = (float)e/v;
        System.out.println(h);
        System.out.println(k);

        double myDouble = 9.8;
        int myInt = (int) myDouble;
        System.out.println(myInt);
        System.out.println(myDouble);
    } 

    static int arrotonda(float value){
            return (int)(value + 0.5);
        }
}