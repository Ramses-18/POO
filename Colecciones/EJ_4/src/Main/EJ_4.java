package Main;

import Entidades.Pelicula;
import Service.PeliculaService;
import java.util.ArrayList;

public class EJ_4 {

    
    public static void main(String[] args) {
        PeliculaService ps = new PeliculaService();
        ps.crearPelicula();
        
        System.out.println("The movies are: ");
        ps.mostrar();
        System.out.println("-----------------------------------");
        ps.duration();
        System.out.println("-----------------------------------");
        ps.order1();
        System.out.println("-----------------------------------");
        ps.order2();
        System.out.println("-----------------------------------");
        ps.order3();
        System.out.println("-----------------------------------");
        ps.order4();
    }

}
