package Main;

import Entidades.Persona;
import Servicios.PersonaServicio;

/**
 *
 * @author tomyv
 */
public class Main {

    /**
     * @param args the command line arguments A continuación, en la clase main
     * hacer lo siguiente:
     *
     *
     * Inicializar un objeto de la clase Persona ejercicio 3 de la guía 8
     * Servicios, a null y tratar de invocar el método esMayorDeEdad() a través
     * de ese objeto. Luego, englobe el código con una cláusula try-catch para
     * probar la nueva excepción que debe ser controlada.
     */
    public static void main(String[] args) {
        
        PersonaServicio ps = new PersonaServicio();
        Persona pNull = null;
//        Exception in thread "main" java.lang.NullPointerException
//	at Servicios.PersonaServicio.esMayorDeEdad(PersonaServicio.java:22)
//	at Main.Main.main(Main.java:27)
//C:\Users\tomyv\AppData\Local\NetBeans\Cache\8.2\executor-snippets\run.xml:53: Java returned: 1
//BUILD FAILED (total time: 0 seconds)
        ps.esMayorDeEdad(pNull);
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
//
//        /**
//         * ● Crear 4 objetos de tipo Persona con distintos valores, a
//         * continuación, llamaremos todos los métodos para cada objeto, deberá
//         * comprobar si la persona está en su peso ideal, tiene sobrepeso o está
//         * por debajo de su peso ideal e indicar para cada objeto si la persona
//         * es mayor de edad.
//         */
//        PersonaServicio ps1 = new PersonaServicio();
//        PersonaServicio ps2 = new PersonaServicio();
//        PersonaServicio ps3 = new PersonaServicio();
//        PersonaServicio ps4 = new PersonaServicio();
//
//        int IMC[] = new int[4];
//        boolean ME[] = new boolean[4];
//        String NAME[] = new String[4];
//
//        NAME[0] = ps1.crearPersona();
//        ME[0] = ps1.esMayorDeEdad();
//        IMC[0] = ps1.calcularIMC();
//        System.out.println("----------------------------");
//        NAME[1] = ps2.crearPersona();
//        ME[1] = ps2.esMayorDeEdad();
//        IMC[1] = ps2.calcularIMC();
//        System.out.println("----------------------------");
//        NAME[2] = ps3.crearPersona();
//        ME[2] = ps3.esMayorDeEdad();
//        IMC[2] = ps3.calcularIMC();
//        System.out.println("----------------------------");
//        NAME[3] = ps4.crearPersona();
//        ME[3] = ps4.esMayorDeEdad();
//        IMC[3] = ps4.calcularIMC();
//
//        /**
//         * ● Por último, guardaremos los resultados de los métodos calcularIMC y
//         * esMayorDeEdad en distintas variables(arrays), para después calcular
//         * un porcentaje de esas 4 personas cuantas están por debajo de su peso,
//         * cuantas en su peso ideal y cuantos, por encima, y también
//         * calcularemos un porcentaje de cuantos son mayores de edad y cuantos
//         * menores. Para esto, podemos crear unos métodos adicionales.
//         */
//        for (int i = 0; i < 4; i++) {
//            if (ME[i] = true) {
//                System.out.print(NAME[i].toUpperCase() + " ES MAYOR DE EDAD");
//            } else {
//                System.out.print(NAME[i].toUpperCase() + " ES MENOR DE EDAD");
//            }
//            if (IMC[i] == -1) {
//                System.out.print(" Y ESTA DEBAJO DE SU PESO IDEAL ");
//            } else if (IMC[i] == 0) {
//                System.out.print(" Y ESTA EN SU PESO IDEAL ");
//            } else {
//                System.out.print(" Y ESTA POR ENCIMA DE SU PESO IDEAL ");
//            }
//            System.out.println("");
//        }
    }
}
