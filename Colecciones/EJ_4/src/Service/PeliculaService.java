package Service;

import Entidades.Pelicula;
import Utilidades.Comparadores;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class PeliculaService {

    ArrayList<Pelicula> pel = new ArrayList();

    //En el servicio deberemos tener un bucle que crea un objeto Pelicula
    //pidiéndole al usuario todos sus datos y guardándolos en el objeto Pelicula.
    //Después, esa Pelicula se guarda una lista de Peliculas y se le pregunta al
    //usuario si quiere crear otra Pelicula o no.
    public ArrayList crearPelicula() {
        Scanner s = new Scanner(System.in).useDelimiter("\n");
        int cont = 0;
        do {
            cont++;
            System.out.println("Movie " + cont);
            System.out.println("What`s movie`s name?");
            String name = s.next();
            System.out.println("Who shot it?");
            String director = s.next();
            System.out.println("How hours long is the movie?");
            double time = s.nextDouble();
            pel.add(new Pelicula(name, director, time));
            System.out.println("Do you want to enter other movie?(N/Y)");
        } while ("Y".equalsIgnoreCase(s.next()));

        return pel;
    }

    // • Mostrar en pantalla todas las películas.
    public void mostrar() {
        for (Pelicula aux : pel) {
            System.out.println(aux.getTitle() + " is directed by " + aux.getDirect() + " and is " + aux.getTime() + " hs long" );
        }
    }

    // • Mostrar en pantalla todas las películas con una duración mayor a 1 hora.
    public void duration() {
        for (Pelicula aux : pel) {
            if (aux.getTime() > 1) {
                System.out.println(aux.getTitle() + " is longer than 1 hour");
            }
        }
    }

    // • Ordenar las películas de acuerdo a su duración (de mayor a menor) y mostrarlo en pantalla.
    public void order1() {
        System.out.println("In terms of longest duration this the new order: ");
        Collections.sort(pel, Comparadores.ordenarPorDuracionMayor);
        mostrar();
    }

    // • Ordenar las películas de acuerdo a su duración (de menor a mayor) y mostrarlo en pantalla.
    public void order2() {
        System.out.println("This the new order in terms of shortest duration: ");
        Collections.sort(pel, Comparadores.ordenarPorDuracionMenor);
        mostrar();
    }
    
    //• Ordenar las películas por título, alfabéticamente y mostrarlo en pantalla.
    public void order3() {
        System.out.println("In terms of Title this the new order: ");
        Collections.sort(pel, Comparadores.ordenarPorTiulo);
        mostrar();
    }
    
   // • Ordenar las películas por director, alfabéticamente y mostrarlo en pantalla.
    public void order4() {
        System.out.println("In terms of director's name duration this the new order: ");
        Collections.sort(pel, Comparadores.ordenarPorDirector);
        mostrar();
    }
}
