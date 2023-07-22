package Servicie;

import Entidades.Ahorcado;
import java.util.Random;
import java.util.Scanner;

public class AhorcadoService {

    Scanner sc = new Scanner(System.in).useDelimiter("\n");
    Ahorcado ah = new Ahorcado();

    //Metodo crearJuego(): le pide la palabra al usuario y cantidad de jugadas
    //máxima. Con la palabra del usuario, pone la longitud de la palabra, como la
    //longitud del vector. Después ingresa la palabra en el vector, letra por
    //letra, quedando cada letra de la palabra en un índice del vector. Y también,
    //guarda la cantidad de jugadas máximas y el valor que ingresó el usuario.
    public void crearJuego() {
        System.out.println("Enter the word");
        String w = sc.next().toLowerCase();
        String vec[] = new String[w.length()];
        for (int i = 0; i < vec.length; i++) {
            vec[i] = w.substring(i, i + 1);
        }
        ah.setSearch(vec);
    }

    //Método longitud(): muestra la longitud de la palabra que se debe encontrar.
    //Nota: buscar como se usa el vector.length.
    public int longitud() {
        return ah.getSearch().length;
    }

    //Método buscar(letra): este método recibe una letra dada por el usuario y
    //busca si la letra ingresada es parte de la palabra o no.
    //También informará si la letra estaba o no.
    public boolean buscar(String letra) {
        for (int i = 0; i < longitud(); i++) {
            if (letra.equals(ah.getSearch()[i])) {
                return true;
            }
        }
        return false;
    }

    //Método encontradas(letra): que reciba una letra ingresada por el usuario y muestre
    //cuantas letras han sido encontradas y cuántas le faltan. Este método además
    //deberá devolver true si la letra estaba y false si la letra no estaba, ya
    //que, cada vez que se busque una letra que no esté, se le restará uno a sus oportunidades.
    public void encontradas(String letra) {
        int c = 0;
        for (int i = 0; i < longitud(); i++) {
            if (letra.equals(ah.getSearch()[i])) {
                c++;
            }
        }
        ah.setCanl(c);
        System.out.println("Found " + ah.getCanl() + " No found " + (longitud() - ah.getCanl()));
    }

    //Método intentos(): para mostrar cuántas oportunidades le queda al jugador.
    public void intentos() {
        Random r = new Random();
        ah.setJmax(r.nextInt(10));
        System.out.println("You have " + ah.getJmax() + " oportunities");
    }

    //Método juego(): el método juego se encargará de llamar todos los
    //métodos previamente mencionados e informará cuando el usuario descubra toda
    //la palabra o se quede sin intentos. Este método se llamará en el main.
    public void juego() {
        String w;
        crearJuego();
        System.out.println("The word`s extention is " + longitud());
        intentos();
        int s = ah.getJmax();
        do {
            System.out.println("What word do you wanna search?");
            w = sc.next().toLowerCase();
            if (buscar(w)) {
                System.out.println("I found the word");
            } else {
                System.out.println("I wasn`t able to find it");
            }
            encontradas(w);
            s--;
            if (ah.getCanl() == ah.getSearch().length) {
                s = 0;
            }else{
                System.out.println("You still having " + s + " chances");
            }
        } while (s > 0);

        if (ah.getCanl() == ah.getSearch().length) {
            System.out.println("You have won");
        } else {
            System.out.println("Game Over");
        }
    }

}
