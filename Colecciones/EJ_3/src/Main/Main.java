package Main;

import Entidades.Alumno;
import Service.AlumnoService;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        // TODO code application logic here
        Scanner read = new Scanner(System.in).useDelimiter("\n");
        AlumnoService as = new AlumnoService();
        ArrayList<Alumno> sre = new ArrayList();
        int v = 0;
        String p;
        do {
            v++;
            System.out.println("Alumno " + v);
            sre.add(as.crearAlumno());
            System.out.println("¿Queres inscribir otro alumno?(s/n)");
            p = read.next();
        } while (!p.equalsIgnoreCase("n"));
        System.out.println(sre.toString());

        System.out.println("¿De quien queres ver la nota final?");
        String ans = read.next();
        boolean flag = true;
        for (Alumno al : sre) {
            if (al.getName().equals(ans)) {
                flag = false;
                System.out.println("La nota final de " + ans + " es " + as.notaFinal(al,sre));
            } 
        }
        
        if(flag){
            System.out.println("No existe ese nombre");
        }
        

    }

}
