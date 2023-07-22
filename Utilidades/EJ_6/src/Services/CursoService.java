package Services;

import Entidades.Curso;
import java.util.Scanner;

public class CursoService{

    Scanner sc = new Scanner(System.in).useDelimiter("\n");

    //Método cargarAlumnos(): este método le permitirá al usuario ingresar los alumnos
    //que asisten a las clases. Nosotros nos encargaremos de almacenar esta información 
    //en un arreglo e iterar con un bucle, solicitando en cada repetición que se ingrese el nombre de cada alumno.
    public void cargarAlumnos(Curso c) {
        String name[] = new String[5];
        for (int i = 0; i < name.length; i++) {
            System.out.println("Enter name`s number " + (i + 1) + " :");
            name[i] = sc.next();
        }
        c.setAlumnos(name);
    }
    
    //Método crearCurso(): el método crear curso, le pide los valores de los atributos al usuario y
    //después se le asignan a sus respectivos atributos para llenar el objeto Curso. En este método 
    //invocamos al método cargarAlumnos() para asignarle valor al atributo alumnos.
    public Curso crearCurso(){
        String n = "";
        System.out.println("How many hours do you work per day?");
        int hours = sc.nextInt();
        System.out.println("How many days per week?");
        int days = sc.nextInt();
        System.out.println("Are you teaching at morning or afternoon (M/A)?");
        boolean time = true;
        String t = Boolean.toString(time);
        t = sc.next();
        System.out.println("How much money per hour?");
        double money = sc.nextDouble();
        Curso c2 = new Curso(n,hours,days,time,money);
        cargarAlumnos(c2);
        return c2;
    }
    
    //Método calcularGananciaSemanal(): este método se encarga de calcular la ganancia en una semana por curso. Para
    //ello, se deben multiplicar la cantidad de horas por día, el precio por hora,
    //la cantidad de alumnos y la cantidad de días a la semana que se repite el encuentro.
    public double calcularGananciaSemanal(Curso c3){
        return c3.getCantidadHorasPorDia()*c3.getPrecioPorHora()*c3.getAlumnos().length*c3.getCantidadDiasPorSemana();
    }
    
    
}
