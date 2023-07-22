package Main;

import Entidades.Circulo;
import Entidades.Rectangulo;

/**
 *
 * @author tomyv
 */
public class EJ_4 {

    /**
     * @param args the command line arguments
     *
     * Se plantea desarrollar un programa que nos permita calcular el área y el
     * perímetro de formas geométricas, en este caso un círculo y un rectángulo.
     *
     * Ya que este cálculo se va a repetir en las dos formas geométricas, vamos
     * a crear una Interfaz, llamada calculosFormas que tendrá, los dos métodos
     * para calcular el área, el perímetro y el valor de PI como constante.
     *
     * Desarrollar el ejercicio para que las formas implementen los métodos de
     * la interfaz y se calcule el área y el perímetro de los dos.
     *
     * En el main se crearán las formas y se mostrará el resultado final.
     *
     * Área circulo: PI *radio ^ 2 / Perímetro circulo: PI * diámetro.
     *
     * Área rectángulo: base * altura / Perímetro rectángulo: (base + altura) *
     * 2.
     */
    public static void main(String[] args) {
        Circulo c = new Circulo();
        System.out.println("EL AREA DEL CIRCULO ES " + c.calcularArea());
        System.out.println("EL PERIMETRO DEL CIRCULO ES " + c.calcularPerimetro());
        Rectangulo r = new Rectangulo();
        System.out.println("---------------------------------------------------");
        System.out.println("EL AREA DEL RECTANGULO ES " + r.calcularArea());
        System.out.println("EL PERIMETRO DEL RECTANGULO ES " + r.calcularPerimetro());
    }

}
