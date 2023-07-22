/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.Scanner;

/**
 *
 * @author Lenovo
 */
public class Lavadora extends Electrodomestico {
    
    protected int carga;

    public Lavadora() {
    }

    public Lavadora(int carga, Double precio, String color, char consumo, Double peso) {
        super(precio, color, consumo, peso);
        this.carga = carga;
    }

    public int getCarga() {
        return carga;
    }

    public void setCarga(int carga) {
        this.carga = carga;
    }
    
//    Método crearLavadora (): este método llama a crearElectrodomestico() de la clase
//padre, lo utilizamos para llenar los atributos heredados del padre y después llenamos
//el atributo propio de la lavadora.
    
    public void crearLavadora(){
        System.out.println("LAVADORA");
        
        Scanner read = new Scanner(System.in).useDelimiter("\n");
        crearElectrodomestico();
        
        System.out.println("Cual es la capacidad de carga de la Lavadora");
        this.carga = read.nextInt();
        
        precioFinal();
        
    }
    
//    Método precioFinal(): este método será heredado y se le sumará la siguiente
//funcionalidad. Si tiene una carga mayor de 30 kg, aumentará el precio en $500, si la
//carga es menor o igual, no se incrementará el precio. Este método debe llamar al
//método padre y añadir el código necesario. Recuerda que las condiciones que hemos
//visto en la clase Electrodoméstico también deben afectar al precio.
    
    @Override
    public void precioFinal() {
        super.precioFinal(); //To change body of generated methods, choose Tools | Templates.
        
        if (this.carga > 30) {
            this.precio += 500d;
        }
         
    }

    @Override
    public String toString() {
        return "Lavadora{" + "carga=" + carga + ", precio=" + precio + ", color=" + color + ", consumo=" + consumo + ", peso=" + peso + '}';
    }

    
    
    
    
    
    
    
    
    
    
}
