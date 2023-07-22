/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g12_ej3practicos.herencia;

import Entidades.Electrodomestico;
import Entidades.Lavadora;
import Entidades.Televisor;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class EJ_3 {

//   Siguiendo el ejercicio anterior, en el main vamos a crear un ArrayList de Electrodomésticos
//para guardar 4 electrodomésticos, ya sean lavadoras o televisores, con valores ya asignados.
//Luego, recorrer este array y ejecutar el método precioFinal() en cada electrodoméstico. Se
//deberá también mostrar el precio de cada tipo de objeto, es decir, el precio de todos los
//televisores y el de las lavadoras. Una vez hecho eso, también deberemos mostrar, la suma del
//precio de todos los Electrodomésticos. Por ejemplo, si tenemos una lavadora con un precio de
//2000 y un televisor de 5000, el resultado final será de 7000 (2000+5000) para
//electrodomésticos, 2000 para lavadora y 5000 para televisor.
    public static void main(String[] args) {
        
        
        
       
        List <Electrodomestico> ae = new ArrayList();
        
        ae.add(new Televisor(60,  true, 0d, "negro", 'a', 45d ));
        ae.add(new Televisor(45,  false, 0d, "azul", 'c', 60d ));
        ae.add(new Lavadora(35, 0d, "gris", 'd', 80d));
        ae.add(new Lavadora(8, 0d, "rojo", 'a', 60d));
        
        double aux = 0;
        
        for (Electrodomestico electrodomestico : ae) {
            
            electrodomestico.precioFinal();
            System.out.println(electrodomestico.getPrecio() +" " +  electrodomestico.getClass());
             aux += electrodomestico.getPrecio();
        }
        
        System.out.println("La suma de los precios de los electrodomesticos es: " + aux);
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
    
    
    
    
}
