package Main;

import Services.Fravega;

/**
 *
 * @author tomyv
 */
public class EJ_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Vamos a crear una Lavadora y un Televisor y llamar a los métodos
        //necesarios para mostrar el precio final de los dos electrodomésticos.
        Fravega frav = new Fravega();
        frav.menu();
    }
    
}
