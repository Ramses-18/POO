package Services;

import Entidades.Electrodomestico;
import Entidades.Lavadora;
import Entidades.Televisor;
import java.util.Scanner;

/**
 *
 * @author tomyv
 */
public class Fravega {

    public void menu() {
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        Electrodomestico e = new Electrodomestico();
        Double suma = 0d;
        Boolean flag = true;
        String cont = "";
        int c = 0;
        do {
            flag = true;
            System.out.println("¿QUE ELECTRODOMESTICO DESEA SABER SU PRECIO?");
            System.out.println("1 - TELEVISOR ");
            System.out.println("2 - LAVADORA ");
            System.out.println("3 - EXIT ");
            switch (sc.nextInt()) {
                case 1:
                    e = new Televisor();
                    e.crearElectrodomestico();
                    break;
                case 2:
                    e = new Lavadora();
                    e.crearElectrodomestico();
                    break;
                case 3:
                    System.out.println("SALIENDO.........");
                    flag = false;
                    break;
                default:
                    System.out.println("OPCION INCORRECTA");
                    flag = false;
                    break;
            }
            if (flag) {
                System.out.println("SU PRECIO ES " + e.precioFinal());
                suma = suma + e.getPrice();
                c++;
                System.out.println("----------------------------------------------");
                System.out.println("¿CONTINUAR?");
                cont = sc.next();
            }
            
        } while (flag && "s".equalsIgnoreCase(cont));
        
        if(c>1){
            System.out.println("EL PRECIO TOTAL ES DE " + suma);
        }
    }

}
