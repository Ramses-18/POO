package Service;

import Entidades.Student;
import java.util.Scanner;

public class StudentService {

    Student st []  = new Student[8];

    public void datear() {
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        for (int i = 0; i < st.length; i++) {
            System.out.println("NAME " + (i + 1) + ":");
            String nam = sc.next().toUpperCase();
            System.out.println("WHAT WAS " + nam + "`S NOTE?");
            int not = sc.nextInt();
            st[i] = new Student(nam, not);
        }
    }

    // Calcular y mostrar el promedio de notas de todo el curso
    public double calculate() {
        double suminha = 0;
        for (int i = 0; i < st.length; i++) {
            suminha = suminha + st[i].getNote();
        }
        return suminha / st.length;
    }

    // Retornar otro arreglo con los nombre de los alumnos que recibieron una nota mayor al promedio del curso
    public String[] over() {
        int j = 0;
        for (int i = 0; i < st.length; i++) {
            if (st[i].getNote() > calculate()) {
                j++;
            }
        }
        String est[] = new String[j];
        j = 0;
        for (int i = 0; i < est.length; i++) {
            if (st[i].getNote() > calculate()) {
                est[i] = st[i].getName();
            }
        }
        return est;
    }

    //Por último, deberemos mostrar todos los estudiantes con una nota mayor al promedio
    public void print() {
        System.out.println("THE STUDENTS WITH A NOTE OVER THE MEDIA ARE: ");
        for (int i = 0; i < st.length; i++) {
            if (st[i].getNote() > calculate()) {
                System.out.println( st[i].getName() + " WITH " + st[i].getNote());
            }
        }
    }

}
