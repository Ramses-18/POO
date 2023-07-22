package Services;

import Entidades.ParDeNumeros;
import static java.lang.Math.max;
import static java.lang.Math.min;

public class ParDeNumerosService {

    ParDeNumeros p = new ParDeNumeros();

    //Método mostrarValores que muestra cuáles son los dos números guardados. 
    public void mostrarValores() {
        System.out.println("EL PRIMER NUMERO ES : " + p.getN1());
        System.out.println("EL SEGUNDO NUMERO ES : " + p.getN2());
    }

    //Método devolverMayor para retornar cuál de los dos atributos tiene el mayor valor.
    public double devolverMayor() {
        return max(p.getN1(), p.getN2());
    }

    //Método calcularPotencia para calcular la potencia del mayor valor de la clase
    //elevado al menor número. Previamente se deben redondear ambos valores.
    public void calcularPotencia() {
        long r1 = Math.round(p.getN1());
        long r2 = Math.round(p.getN2());
        long max = max(r1, r2);
        long min = min(r1,r2);
        System.out.println( max(r1, r2) + " POTENCIADO A  " + min(r1,r2) + " ES " + Math.pow(max, min) );
    }

    //Método calculaRaiz,para calcular la raíz cuadrada del menor de los dos valores. Antes de
    //calcular la raíz cuadrada se debe obtener el valor absoluto del número.
    public void calcularRaiz(){
        double abs = Math.abs(Math.min(p.getN1(), p.getN2()));
        System.out.println("LA RAIZ CUADRADA DE " + Math.min(p.getN1(), p.getN2()) + " ES " + Math.sqrt(abs) );
    }
}
