package Utilidades;

import Entidades.Pelicula;
import java.util.Comparator;

/**
 *
 * @author tomyv
 */
public class Comparadores {

    public static Comparator<Pelicula> ordenarPorDuracionMayor = new Comparator<Pelicula>() {
        @Override
        public int compare(Pelicula t1, Pelicula t2) {
            return t2.getTime().compareTo(t1.getTime());
        }

    };
    
    public static Comparator<Pelicula> ordenarPorDuracionMenor = new Comparator<Pelicula>() {
        @Override
        public int compare(Pelicula t1, Pelicula t2) {
            return t1.getTime().compareTo(t2.getTime());
        }

    };
    
    public static Comparator<Pelicula> ordenarPorTiulo = new Comparator<Pelicula>() {
        @Override
        public int compare(Pelicula t1, Pelicula t2) {
            return t1.getTitle().compareTo(t2.getTitle());
        }

    };
    
    public static Comparator<Pelicula> ordenarPorDirector = new Comparator<Pelicula>() {
        @Override
        public int compare(Pelicula t1, Pelicula t2) {
            return t1.getDirect().compareTo(t2.getDirect());
        }

    };
    
}
