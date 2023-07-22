/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Entidades.Persona;

/**
 *
 * @author tomyv
 */
public class EJ_2 {

    /**
     * @param args the command line arguments 
     * 
     * Definir una Clase que contenga
     * algún tipo de dato de tipo array y agregue el código para generar y
     * capturar una excepción ArrayIndexOutOfBoundsException (índice de arreglo
     * fuera de rango).
     */
    
    public static void main(String[] args) {
        
        int [] u = {1,2,3,4,12,2,3};
        Persona p = new Persona("JULI",20,u);
        p.test(21, 20);
    }

}
