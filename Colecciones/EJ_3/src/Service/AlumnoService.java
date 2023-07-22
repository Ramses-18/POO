package Service;

import Entidades.Alumno;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @param args the command line arguments Después de ese bucle tendremos el
 * siguiente método en el servicio de Alumno:
 */
public class AlumnoService {

    Scanner read = new Scanner(System.in).useDelimiter("\n");

    // En el servicio de Alumno deberemos tener un bucle que crea un objeto Alumno.
    //Se pide toda la información al usuario y ese Alumno se guarda en una lista de tipo Alumno
    //y se le pregunta al usuario si quiere crear otro Alumno o no.
    public Alumno crearAlumno() {
        System.out.println("Ingrese su nombre");
        String name = read.next();
        ArrayList<Integer> al = new ArrayList();
        for (int i = 0; i < 3; i++) {
            System.out.println("Ingrese nota " + (i + 1));
            al.add(read.nextInt());
        }
        return new Alumno(name, al);
    }

    // Método notaFinal(): El usuario ingresa el nombre del alumno que quiere calcular su nota final y se lo busca en
    //la lista de Alumnos. Si está en la lista, se llama al método. Dentro del método se usará la lista notas 
    //para calcular el promedio final de alumno. Siendo este promedio final, devuelto por el método y mostrado en el main.
    public double notaFinal(Alumno a, ArrayList<Alumno> al) {
        int s = 0;
        for (Integer nota : a.getNote()) {
            s += nota;
        }
        return s / a.getNote().size();
    }

}
