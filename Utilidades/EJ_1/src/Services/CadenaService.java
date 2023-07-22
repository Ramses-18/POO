package Services;

import Entidades.Cadena;
import java.util.Scanner;

/**
 * @author tomyv
 */
public class CadenaService {

    Cadena c = new Cadena();
    Scanner sc = new Scanner(System.in).useDelimiter("\n");
    String s = new String();
    int cont = 0;

    //a) Método mostrarVocales(), deberá contabilizar la cantidad de vocales que tiene la frase ingresada.
    public void mostrarVocales() {
        String cad = "AEIOUaeiou";
        System.out.println("INGRESE UNA FRASE");
        c.setFrase(sc.next().toUpperCase());
        for (int i = 0; i < c.getLongitud(); i++) {
            char cha = c.getFrase().charAt(i);
            if (cad.indexOf(cha)!= -1){
                cont++;
            }
        }
        if (cont == 0) {
            System.out.println(c.getFrase() + " NO TIENE VOCALES");
        } else if (cont == 1) {
            System.out.println(c.getFrase() + " TIENE UNA VOCAL");
        } else if (cont > 1) {
            System.out.println(c.getFrase() + " TIENE " + cont + " VOCALES");
        }
    }

    //b) Método invertirFrase(), deberá invertir la frase ingresada y mostrarla por pantalla.
    //Por ejemplo: Entrada: "casa blanca", Salida: "acnalb asac".
    public void invertirFrase() {
        System.out.print("ASI ES LA FRASE INVERTIDA : ");
        for (int i = c.getLongitud(); i > 0; i--) {
            System.out.print(c.getFrase().substring(i - 1, i));
        }
        System.out.println("");
    }

    //c) Método vecesRepetido(String letra),recibirá un carácter ingresado por el usuario y
    //contabilizar cuántas veces se repite el carácter en la frase, por ejemplo:
    public void vecesRepetido(String letra) {
        cont = 0;
        for (int i = 0; i < c.getLongitud(); i++) {
            if (c.getFrase().substring(i, i + 1).equals(letra)) {
                cont++;
            }
        }
        if (cont == 0) {
            System.out.println(c.getFrase() + " NO TIENE " + letra);
        } else if (cont == 1) {
            System.out.println(c.getFrase() + " TIENE UNA " + letra);
        } else if (cont > 1) {
            System.out.println(c.getFrase() + " TIENE " + cont + "[" + letra + "]");
        }
    }

    //d) Método compararLongitud(String frase), deberá comparar la longitud de la frase que
    //compone la clase con otra nueva frase ingresada por el usuario.
    public int compararLongitud(String frase) {
        Integer i1 = new Integer(frase.length());
        Integer i2 = new Integer(c.getLongitud());
        return i1.compareTo(i2);
    }

    // f) Método unirFrases(String frase), deberá unir la frase contenida en la clase Cadena
    //con una nueva frase ingresada por el usuario y mostrar la frase resultante.
    public void unirFrases(String frasesinha) {
        System.out.println("LA FRASE CONCATENADAS ES : " + c.getFrase().concat(" " + frasesinha.toUpperCase()));
        c.setFrase(c.getFrase().concat(" " + frasesinha));
    }

    //g) Método reemplazar(String letra), deberá reemplazar todas las letras “a” que se encuentren
    //en la frase, por algún otro carácter seleccionado por el usuario y mostrar la frase resultante.
    public void reemplazar(String letrinha) {
        String remp = "";
        System.out.print("LA NUEVA FRASE ES: ");
        for (int i = 0; i < c.getLongitud(); i++) {
            remp = c.getFrase().replace("A", letrinha);
        }
        System.out.println(remp);
    }

    //h) Método contiene(String letra), deberá comprobar si la frase contiene una letra que ingresa el usuario y devuelve
    //verdadero si la contiene y falso si no.
    public boolean contiene(String word) {
        for (int i = 0; i < c.getLongitud(); i++) {
            if (c.getFrase().contains(word)) {
                return true;
            }
        }
        return false;
    }

}
