import java.util.ArrayList;
import java.util.Scanner;

public class Student {
   

    public Student(String name, String cognome, String anno) {
        System.out.println(name);
    }
    public static void main(String[] args) {
        ArrayList<Student> arrayStudent = new ArrayList<Student>();
        Scanner Sscan = new Scanner(System.in);
        for (int index = 0; index < 2; index++) {

            System.out.println("inserire nome cognome e anno");
            Student student = new Student(Sscan.nextLine(), Sscan.nextLine(), Sscan.nextLine());
           
            System.out.println("Dati relativi allo studente.");
            arrayStudent.add(student);
       }

       for (int i = 0; i < arrayStudent.size(); i++) {
        System.out.println("Sei lo studente numero " +i+" - " + arrayStudent.get(i).nome);
       }
        
    }
    
   
}
