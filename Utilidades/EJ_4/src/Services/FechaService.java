package Services;

import java.util.Date;
import java.util.Scanner;

public class FechaService {

    Scanner sc = new Scanner(System.in).useDelimiter("\n");

    //Método fechaNacimiento que pregunte al usuario día, mes y año de su nacimiento.
    //Luego los pase por parámetro a un nuevo objeto Date.
    //El método debe retorna el objeto Date. Ejemplo fecha: Date fecha = new Date(anio, mes, dia);
    public Date fechaNacimiento() {

        System.out.println("What day were you born?");
        int day = sc.nextInt();

        System.out.println("What month?");
        int month = sc.nextInt();

        System.out.println("What year?");
        int year = sc.nextInt();

        Date r = new Date(year - 1900, month - 1, day);
        System.out.println(r);
        return r;
    }

    //Método fechaActual que cree un objeto fecha con el día actual. Para esto
    //usaremos el constructor vacío de la clase Date. Ejemplo: Date fechaActual = new Date();
    //El método debe retornar el objeto Date.
    public Date fechaActual() {
        Date fechaActual = new Date();
        fechaActual.toString();
        System.out.println("Today is " + fechaActual);
        return fechaActual;
    }

    //Método diferencia que reciba las dos fechas por parámetro y retorna la diferencia de
    //años entre una y otra (edad del usuario).
    public int diferencia(Date d1, Date d2) {
        
        if (d1.getMonth() < d2.getMonth()) {
            d2.setYear(d1.getYear()-1);
        }else if(d1.getMonth() == d2.getMonth() && d1.getDate() < d2.getDate()){
            d2.setYear(d1.getYear()-1);
        }  
        return d2.getYear() - d1.getYear();
    }
    
}
