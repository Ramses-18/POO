package ej_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class EJ_1_EJ_2 {

    /**
     * @param args the command line arguments Diseñar un programa que lea y
     * guarde razas de perros en un ArrayList de tipo String. El programa pedirá
     * una raza de perro en un bucle, el mismo se guardará en la lista y después
     * se le preguntará al usuario si quiere guardar otro perro o si quiere
     * salir. Si decide salir, se mostrará todos los perros guardados en el
     * ArrayList. 
     * /////////////////////////////////////////////////////////////////////////
     * Continuando el ejercicio anterior, después de mostrar los
     * perros, al usuario se le pedirá un perro y se recorrerá la lista con un
     * Iterator, se buscará el perro en la lista. Si el perro está en la lista,
     * se eliminará el perro que ingresó el usuario y se mostrará la lista
     * ordenada. Si el perro no se encuentra en la lista, se le informará al
     * usuario y se mostrará la lista ordenada.
     */
    public static void main(String[] args) {

        ArrayList<String> razas = new ArrayList();
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        String var;
        do {
            System.out.println("Ingrese una raza, y si desea salir (N)");
            var = leer.next().toUpperCase();
            if (var.equalsIgnoreCase("N")) {
                break;
            } else {
                razas.add(var.toUpperCase());
                continue;
            }
        } while (!var.equals("N"));
        System.out.println(razas.toString());
        System.out.println("El tamaño es " + razas.size());
        
        Iterator<String> it = razas.iterator();
        System.out.println("Elige que raza queres eliminar");
        var = leer.next();
        int i = 0;
        while(it.hasNext()){
            if(it.next().equalsIgnoreCase(var)){
                i++;
                it.remove();
            }
        }
        if(i==0){
            System.out.println("No encontre");
        }else{
            System.out.println("Existe");
        }
        Collections.sort(razas);
        System.out.println(razas.toString());
    }

}
