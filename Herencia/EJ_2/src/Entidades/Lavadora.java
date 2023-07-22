/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.Scanner;

/**
 *
 * @author tomyv
 *
 * Los constructores que se implementarán serán:
 *
 * • Un constructor vacío.
 *
 * • Un constructor con la carga y el resto de los atributos heredados. Recuerda
 * que debes llamar al constructor de la clase padre.
 */
public class Lavadora extends Electrodomestico {

    protected Integer carga;

    public Lavadora() {
    }

    public Lavadora(Integer carga, Double price, String colour, char consElec, Integer height) {
        super(price, colour, consElec, height);
        this.carga = carga;
    }

    public Integer getCarga() {
        return carga;
    }

    public void setCarga(Integer carga) {
        this.carga = carga;
    }

    //Método crearLavadora (): este método llama a crearElectrodomestico() de la clase padre,
    //lo utilizamos para llenar los atributos heredados del padre y después llenamos el atributo propio de la lavadora.
    @Override
    public void crearElectrodomestico() {
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        super.crearElectrodomestico();
        System.out.println("CARGA");
        this.carga = sc.nextInt();
        precioFinal();
    }

    //Método precioFinal(): este método será heredado y se le sumará la siguiente
    //funcionalidad. Si tiene una carga mayor de 30 kg, aumentará el precio en $500, si la
    //carga es menor o igual, no se incrementará el precio. Este método debe llamar al
    //método padre y añadir el código necesario. Recuerda que las condiciones que hemos
    //visto en la clase Electrodoméstico también deben afectar al precio.
    @Override
    public Double precioFinal() {
        super.precioFinal();
        if (carga > 30) {
            this.price += 500d;
        }
        return price;
    }

    @Override
    public String toString() {
        return super.toString() + "kg, Carga:" + carga + "kg" + '}' ; 
    }

    
    
    
}
