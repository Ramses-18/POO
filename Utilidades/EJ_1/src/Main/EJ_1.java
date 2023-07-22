package Main;


import Services.CadenaService;
import java.util.Scanner;

public class EJ_1 {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        CadenaService cs = new CadenaService();
        
        cs.mostrarVocales();
      
        cs.invertirFrase();

        System.out.println("¿QUE LETRA QUIERES SABER CUANTO SE REPITE?");
        cs.vecesRepetido(sc.next().toUpperCase());

        System.out.println("¿QUE FRASE QUIERES COMPARAR?");
        if (cs.compararLongitud(sc.next()) == 0) {
            System.out.println("TIENEN LA MISMA LONGITUD");
        } else {
            System.out.println("TIENEN DIFERENTE LONGITUD");
        }

        System.out.println("¿QUE FRASE QUIERES CONCATENAR?");
        cs.unirFrases(sc.next().toUpperCase());

        System.out.println("¿POR QUE CARACTER QUIERES REEMPLAZAR LAS A?");
        cs.reemplazar(sc.next().toUpperCase());

        System.out.println("¿QUE LETRA DESEA BUSCAR EN LA FRASE ORIGINAL?");
        if (cs.contiene(sc.next().toUpperCase()) == true) {
            System.out.println("ESA LETRA EXISTE EN LA FRASE");
        }else{
            System.out.println("NO HEMOS LOGRADO UBICAR LA LETRA");
        }

        
    }

}
