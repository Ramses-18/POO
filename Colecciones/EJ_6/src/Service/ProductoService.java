package Service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

/**
 * @param args the command line arguments Se necesita una aplicación para una
 * tienda en la cual queremos almacenar los distintos productos que venderemos y
 * el precio que tendrán. Además, se necesita que la aplicación cuente con las
 * funciones básicas. Estas las realizaremos en el servicio. Como, introducir un
 * elemento, modificar su precio, eliminar un producto y mostrar los productos
 * que tenemos con su precio (Utilizar Hashmap). El HashMap tendrá de llave el
 * nombre del producto y de valor el precio. Realizar un menú para lograr todas
 * las acciones previamente mencionadas.
 */
public class ProductoService {

    public void options() {
        HashMap<String, Double> hashproducto = new HashMap();
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        //Mostramos el menu
        boolean check = true;
        do {
            System.out.println("¿Que quieres hacer?");
            System.out.println("1- Añadir algun producto");
            System.out.println("2- Modificar algun precio");
            System.out.println("3- Eliminar algun producto");
            System.out.println("4- Mostrar todos los precios");
            System.out.println("5- Salir");
            switch (sc.nextInt()) {
                case 1:
                    crearProducto(sc, hashproducto);
                    break;
                case 2:
                    modificarPrecio(sc, hashproducto);
                    break;
                case 3:
                    eliminarProducto(sc, hashproducto);
                    break;
                case 4:
                    mostrarPrecios(hashproducto);
                    break;
                case 5:
                    check = false;
                    System.out.println("Saliendo..............");
                    break;
                default:
                    System.out.println("Opcion incorreccta");
            }
        } while (check);
    }

    public void crearProducto(Scanner sc, HashMap<String, Double> prod1) {
        do {
            System.out.println("¿Que producto?");
            String name = sc.next();
            System.out.println("¿Que precio tiene " + name + "?");
            Double price = sc.nextDouble();
            prod1.put(name, price);
            System.out.println("¿Otro mas? S/N");
        } while ("S".equalsIgnoreCase(sc.next()));
    }

    public void modificarPrecio(Scanner sc, HashMap<String, Double> prod2) {

        //Creamos un Iterator para recorrer el HashMap y encontrar si lo que ingreso coincide con el nombre de algun del producto
        String ans;
        String ans2;
        boolean check;

        do {
            Iterator<Map.Entry<String, Double>> it = prod2.entrySet().iterator();
            System.out.println("¿El precio de que producto queres modificar?");
            //Nos responde
            ans = sc.next();
            check = true;
            while (it.hasNext()) {
                Map.Entry<String, Double> entry = it.next();
                if (entry.getKey().equalsIgnoreCase(ans)) {
                    System.out.println("¿Que precio desear colocarle?");
                    entry.setValue(sc.nextDouble());
                    System.out.println("Modificado");
                    check = false;
                }
            }

            if (check) {
                System.out.println("Nothing, mostri");
            }

            System.out.println("¿Otro mas? S/N");
            ans2 = sc.next();
        } while ("S".equalsIgnoreCase(ans2));

    }

    public void eliminarProducto(Scanner sc, HashMap<String, Double> prod3) {
        String ans4;
        do {
            System.out.println("¿Que producto queres eliminar?");
            //Nos responde
            String ans3 = sc.next();
            boolean check = true;
            //Creamos un Iterator para recorrer el HashMap y encontrar si lo que ingreso coincide con el nombre de algun del producto
            Iterator<Map.Entry<String, Double>> it2 = prod3.entrySet().iterator();
            while (it2.hasNext()) {
                Map.Entry<String, Double> entry2 = it2.next();
                if (entry2.getKey().equalsIgnoreCase(ans3)) {
                    check = false;
                    it2.remove();
                    System.out.println("Eliminado");
                }
            }

            if (check) {
                System.out.println("Nothing, mostri");
            }
            System.out.println("¿Otro mas? S/N");
            ans4 = sc.next();
        } while ("S".equalsIgnoreCase(ans4));

    }

    public void mostrarPrecios(HashMap<String, Double> prod4) {
        for (Map.Entry<String, Double> aux : prod4.entrySet()) {
            String key = aux.getKey();
            Double value = aux.getValue();
            System.out.println(key + " = $" + value);
        }
    }

}
