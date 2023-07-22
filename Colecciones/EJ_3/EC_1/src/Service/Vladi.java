package Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

/**
 *
 * @author tomyv Array<int> listado = new ArrayList; TreeSet<String> =
 * TreeSet(); HashMap<Integer> personas = new HashMap<>;
 *
 * Array<int> listado = new ArrayList; TreeSet<String> = TreeSet();
 * HashMap<Integer> personas = new HashMap<>;
 */
public class Vladi {
    
    public void Agregar() {
        Scanner sc = new Scanner(System.in).useDelimiter("\n");

        ////////////////////////////////////////
        //LISTAS
        ArrayList<Integer> al = new ArrayList();
        System.out.println("Old " + al.size());
        for (int i = 0; i < 10; i++) {
            al.add(i+5);
        }
        
        System.out.println("New " + al.size());
        for(Integer cadena : al){
            System.out.print("{" + cadena + "}");
        }
        System.out.println("");
        al.remove(1);
        al.remove(2);
        System.out.println("New " + al.size());
        
        for(Integer cadena : al){
            System.out.print("{" + cadena + "}");
        }
        System.out.println("");
        System.out.println("--------------------------------");
        
        ////////////////////////////////////////
        //CONJUNTOS
        HashSet<Double> ts = new HashSet();
        Double y = 20.2;
        for (int i = 0; i < 10; i++) {
            ts.add(y + 20.1);
        }
        System.out.println("Old " + ts.size());
        ts.remove(19.22);
        System.out.println("New " + ts.size());
        for(Double tree : ts){
            System.out.println(tree);
        }
        System.out.println("--------------------------------");
        ////////////////////////////////////////
        //MAPAS
        HashMap<Long,String> hm = new HashMap();
        long dni = 45612200;
        for (int i = 0; i < 1; i++) {
            hm.put(sc.nextLong(),sc.next());
        }
        System.out.println("Old " + hm.size());
        hm.remove(dni,"Kylian");
        System.out.println("New " + hm.size());
        System.out.println(hm.toString());
        /////////////////////////////////////////////
        ////////////////////////////////////////////
        ///////////////////////////////////////////
        HashMap<Integer,String> personas = new HashMap<>();
        int n1 = 123;
        String n2 = "Severus";
        personas.put(n1,n2);
        System.out.println(personas.toString());
        //////////////////////////////////////////////////
        ArrayList<String> bebidas = new ArrayList();
        bebidas.add("café");
        bebidas.add("té");
        Iterator<String> it = bebidas.iterator();
        while (it.hasNext()){
            if (it.next().equals("café")){
                it.remove();
            }
        }
        
    }
}
