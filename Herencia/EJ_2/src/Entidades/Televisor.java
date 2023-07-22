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
 * Se debe crear también una subclase llamada Televisor con los siguientes
 * atributos: resolución (en pulgadas) y sintonizador TDT (booleano), además de
 * los atributos heredados.
 *
 * Los constructores que se implementarán serán:
 *
 *
 *
 *
 */
public class Televisor extends Electrodomestico {

    protected Integer resolucion;
    protected Boolean sintTDT;

    // • Un constructor vacío.
    public Televisor() {
    }

    // • Un constructor con la resolución, sintonizador TDT y el resto de los
    //atributos heredados. Recuerda que debes llamar al constructor de la clase padre.
    public Televisor(Integer resolucion, Boolean sintTDT) {
        this.resolucion = resolucion;
        this.sintTDT = sintTDT;
    }

    public Televisor(Integer resolucion, Boolean sintTDT, Double price, String colour, char consElec, Integer height) {
        super(price, colour, consElec, height);
        this.resolucion = resolucion;
        this.sintTDT = sintTDT;
    }

    //Método get y set de los atributos resolución y sintonizador TDT.
    public Integer getResolucion() {
        return resolucion;
    }

    public void setResolucion(Integer resolucion) {
        this.resolucion = resolucion;
    }

    public Boolean getSintTDT() {
        return sintTDT;
    }

    public void setSintTDT(Boolean sintTDT) {
        this.sintTDT = sintTDT;
    }

    //Método crearTelevisor(): este método llama a crearElectrodomestico() de la clase
    //padre, lo utilizamos para llenar los atributos heredados del padre y después llenamos los atributos del televisor.
    @Override
    public void crearElectrodomestico() {
        super.crearElectrodomestico();
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        System.out.println("RESOLUCION");
        this.resolucion = sc.nextInt();
        System.out.println("SINTONIZADOR? S/N");
        if (sc.next().equalsIgnoreCase("s")) {
            this.sintTDT = true;
        } else {
            this.sintTDT = false;
        }
    }

    //Método precioFinal(): este método será heredado y se le sumará la siguiente funcionalidad.
    //Si el televisor tiene una resolución mayor de 40 pulgadas, se incrementará el precio un 30%
    //y si tiene un sintonizador TDT incorporado, aumentará $500.
    //Recuerda que las condiciones que hemos visto en la clase Electrodomestico también deben afectar al precio.
    @Override
    public Double precioFinal() {
        super.precioFinal();
        if (this.resolucion > 40) {
            this.price = this.price + this.price * 0.30;
            if (this.sintTDT.equals(true)) {
                this.price += 500;
            }
        }
        return price;
    }

    @Override
    public String toString() {
        return super.toString() + "kg, Resolucion:" + resolucion + ", Sintetizador:" + sintTDT + '}';
    }

}
