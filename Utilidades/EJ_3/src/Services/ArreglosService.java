/**
 *
 * @author tomyv  Crear la clase ArregloService, en
 * el paquete servicio, con los siguientes métodos:    En el Main
 * nuevamente: inicializar A, mostrar A, ordenar A, inicializar B, mostrar A y
 * B.
 */
package Services;

import java.util.Arrays;
import java.util.Comparator;

public class ArreglosService {

    //Método inicializarA recibe un arreglo por parámetro y lo inicializa con números aleatorios.
    public void inicializarA(Integer[] ar) {
        //Arrays.fill(arreglo, int desde, int  hasta, variable)
        for (int i = 0; i < ar.length; i++) {
            ar[i] = (int) (Math.random() * 20) + 1;
        }
        mostrar(ar);
    }

    //Método mostrar recibe un arreglo por parámetro y lo muestra por pantalla.
    public void mostrar(Integer[] a) {
        System.out.println(Arrays.toString(a));
    }

    //Método ordenar recibe un arreglo por parámetro y lo ordena de mayor a menor. 
    public void ordenar(Integer[] arr) {
        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        mostrar(arr);
    }

    //Método inicializarB copia los primeros 10 números del arreglo A en el arreglo B.
    //Luego llenar las últimas 10 posiciones del arreglo B con 0.5.
    public void inicializarB(Integer[] a1, double[] a2) {

        for (int i = 0; i < 10; i++) {
            a2[i] = a1[i].doubleValue();
        }
        Arrays.fill(a2, 10, 19, 0.5);
        System.out.println(Arrays.toString(a2));
    }

}
