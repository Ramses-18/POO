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
public class Televisor extends Electrodomestico {
    
        protected int resolucion;
        protected boolean tdt;

    public Televisor() {
    }

    public Televisor(int resolucion, boolean tdt, Double precio, String color, char consumo, Double peso) {
        super(precio, color, consumo, peso);
        this.resolucion = resolucion;
        this.tdt = tdt;
    }

    public int getResolucion() {
        return resolucion;
    }

    public void setResolucion(int resolucion) {
        this.resolucion = resolucion;
    }

    public boolean isTdt() {
        return tdt;
    }

    public void setTdt(boolean tdt) {
        this.tdt = tdt;
    }
        
//        Método crearTelevisor(): este método llama a crearElectrodomestico() de la clase
//padre, lo utilizamos para llenar los atributos heredados del padre y después llenamos
//los atributos del televisor.
    
    public void crearTelevisor(){
        
        System.out.println("TELEVISOR");
        
        Scanner read = new Scanner(System.in).useDelimiter("\n");
        crearElectrodomestico();
        
        System.out.println("RESOLUCION EN PULGADAS");
        this.resolucion = read.nextInt();
        
        System.out.println("Tiene sistema TDT s / n");
        String res = read.next();
        
        if (res.equalsIgnoreCase("s")) {
            this.tdt = true;
        }else{
            this.tdt = false;
        }
        precioFinal();
    }
    
    
//    Método precioFinal(): este método será heredado y se le sumará la siguiente
//funcionalidad. Si el televisor tiene una resolución mayor de 40 pulgadas, se
//incrementará el precio un 30% y si tiene un sintonizador TDT incorporado, aumentará
//$500. Recuerda que las condiciones que hemos visto en la clase Electrodomestico
//también deben afectar al precio.

    @Override
    public void precioFinal() {
        super.precioFinal(); //To change body of generated methods, choose Tools | Templates.
    
        if(this.resolucion > 40){
        
            this.precio*= 1.3;
        }
        
        if(this.tdt == true){
            this.precio += 500d;
        }
    }

    @Override
    public String toString() {
        return "Televisor{"  + ", precio=" + precio + ", color=" + color + ", consumo=" + consumo + ", peso=" + peso +"resolucion=" + resolucion + ", tdt=" + tdt + '}';
    }
    
    
    
    
    
    
    
    
}
