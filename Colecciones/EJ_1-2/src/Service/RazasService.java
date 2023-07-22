/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author tomyv
 */
public class RazasService {

    private Scanner leer = new Scanner(System.in).useDelimiter("\n");
    private boolean check = true;

    //Diseñar un programa que lea y guarde razas de perros en un ArrayList de tipo String.
    //El programa pedirá una raza de perro en un bucle, el mismo se guardará en la lista y después
    // se le preguntará al usuario si quiere guardar otro perro o si quiere salir. Si decide salir,
    //se mostrará todos los perros guardados en el ArrayList. 
    public ArrayList crearRazas() {
        ArrayList<String> razas = new ArrayList();

        do {
            System.out.println("Ingrese una raza");
            razas.add(leer.next());
            System.out.println("¿Quiere salir?(S/N)");
        } while (!"S".equalsIgnoreCase(leer.next()));
        mostrar(razas);
        return razas;
    }

    public void mostrar(ArrayList<String> r1) {
        if (check) {
            System.out.println("Las razas son");
            check = false;
        }else{
           System.out.println("Las razas ordenadas son"); 
        }
        
        for (String aux : r1) {
            System.out.println(aux);
        }
    }

    //Continuando el ejercicio anterior, después de mostrar los perros, al usuario se le pedirá un perro y
    //se recorrerá la lista con un Iterator, se buscará el perro en la lista. Si el perro está en la lista,
    // se eliminará el perro que ingresó el usuario y se mostrará la lista ordenada.
    //Si el perro no se encuentra en la lista, se le informará al usuario y se mostrará la lista ordenada.
    public void search(ArrayList<String> r2) {
        Iterator<String> it = r2.iterator();
        System.out.println("Elige que raza queres eliminar");
        String var = leer.next();
        boolean check = true;
        while (it.hasNext()) {
            if (it.next().equalsIgnoreCase(var)) {
                check = false;
                it.remove();
            }
        }
        if (check) {
            System.out.println("No encontre");
        } else {
            System.out.println("Existe");
        }
        order(r2);
    }
    
    public void order(ArrayList<String> r3) {
        Collections.sort(r3);
        mostrar(r3);
    }

}
