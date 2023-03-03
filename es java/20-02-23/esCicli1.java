
import java.util.*; // import the Scanner class
public class esCicli1 {
    public static void main(String[] args) {
        for (int i = 0; i <= 10; i++) {
            if (i%2 == 0 && i<=8) {
            }else{
                if (i>8 ) {
                    break;
                }
                i++;
            }
            System.out.println(i);
        }
    }

}
