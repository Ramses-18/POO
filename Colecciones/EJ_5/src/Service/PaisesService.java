package Service;

import Entidades.Paises;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class PaisesService {
    private Scanner sc = new Scanner(System.in).useDelimiter("\n");
    private HashSet<Paises> country = new HashSet();
    Paises paisinho;
    
    //Se requiere un programa que lea y guarde países, y para evitar que se
    //ingresen repetidos usaremos un conjunto.El programa pedirá un país en un
    //bucle , se guardará el país en el conjunto y después se le preguntará al
    //usuario si quiere guardar otro país o si quiere salir, si decide salir, se
    //mostrará todos los países guardados en el conjunto
    public void data() {
        int cont = 0;
        do {
            cont++;
            System.out.println("Enter country " + cont);
            country.add( new Paises (sc.next()));
            System.out.println("Do you want to enter other country?(N/Y)");
        } while ("Y".equalsIgnoreCase(sc.next()));
    }
    
    public void mostrar() {
        System.out.println("The countries name are ");
        for (Paises aux : country) {
            System.out.println(aux);
        }
    }
    
    public void order(){
        ArrayList<Paises> listaPais = new ArrayList(country);
        listaPais.sort(Paises.compararPais);
        System.out.println("The new order is ");
        for (Paises aux : listaPais) {
            System.out.println(aux);
        }
    }
    
    public void find() {
        //Después deberemos mostrar el conjunto ordenado alfabéticamente: para esto recordar cómo se ordena un conjunto.
        //Por último, al usuario se le pedirá un país y se recorrerá el conjunto con un Iterator, se buscará el país en el
        //conjunto y si está en el conjunto se eliminará el país que ingresó el usuario y se mostrará el conjunto.
        //Si el país no se encuentra en el conjunto se le informará al usuario.
        System.out.println("Let's find one country ");
        String var = sc.next();
        boolean check = false;
        Iterator<Paises> it = country.iterator();
        while(it.hasNext()){
            if(it.next().getPais().equalsIgnoreCase(var)){
                check = true;
                it.remove();
            }
        }
        if(check){
            System.out.println("I've found it");
            System.out.println(var + " is out");
            mostrar();
        }else{
            System.out.println("Nothing, mostri");
        }
        
        
    }
    
    
}
